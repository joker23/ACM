{-# OPTIONS_GHC -O2 #-}

module Main where

import qualified System.IO as IO
import Data.Array
import Data.Bits
import qualified Data.List as DL
import qualified Data.Map as DM

import Debug.Trace
import Text.Printf -- non-standard library usage here, probably not in Contest Environment...

enableTrace = False

maxTime = 1e10

main = do IO.getContents >>= outerLoop . map read . words
                
outerLoop (n:c:values)
  | (n==0)||(c==0) = return ()
  | otherwise = 
    do IO.putStrLn $ printf "%.2f" $ solve (fromIntegral c) (parse n ps)
       outerLoop remainder
    where (ps,remainder) = splitAt (4*n) values
          
type Memo = DM.Map (Int,Int) Double

type Points = Array Int Point             
data Point = Point{x::Double,y::Double,dx::Double,dy::Double}
instance Show Point where
  showsPrec p Point{x=x,y=y,dx=dx,dy=dy} =
    showString $ printf "<%.2f,%.2f,%.2f,%.2f>" x y dx dy

parse :: Int -> [Int] -> Points
parse n vs = listArray (0,n-1) (helper 0 vs)
  where
    helper _ [] = []
    helper i (x:y:d:s:vs) = (p:helper (i+1) vs)
      where theta = toRadians $ fromIntegral d
            velocity = fromIntegral s
            dX = velocity * (cos theta)
            dY = velocity * (sin theta)
            p = Point{x=fromIntegral x, y=fromIntegral y, dx=dX, dy=dY}

toRadians degrees = (pi / 180.0) * degrees

solve :: Double -> Points -> Double
solve c points
  | enableTrace = trace (unlines msg) result
  | otherwise = result
    where
      result = minimum endTimes
      (memo',endTimes) = DL.mapAccumL (oneStep points c state) memo ixs
      msg = [banner, show points]
      banner = printf "%.2f seconds at speed=%.2f to visit:" result c
      memo = DM.fromList $ map (initial points c) ixs
      state = foldl setBit 0 ixs
      ixs = indices points
        
oneStep :: Points -> Double -> Int -> Memo -> Int -> (Memo,Double)
oneStep points cS state memo i | points `seq` state `seq` memo `seq` False = undefined
oneStep points cS state memo i
  | enableTrace = trace (unlines msg) result
  | otherwise = result
    where result = oneStep' points cS state memo i
          msg = [banner,"memo:"++show memo]
          banner = printf "oneStep: state=%d i=%d" state i

oneStep' points cS state memo i =
  maybe (DM.insert (state,i) result memo',result) (\x->(memo,x)) $ DM.lookup (state,i) memo
    where
      result = minimum endTimes'
      endTimes' = map (extend points cS i) $ zip ixs endTimes
      (memo',endTimes) = DL.mapAccumL (oneStep points cS state') memo ixs
      state' = clearBit state i
      ixs = members state' 0
        
initial :: Points -> Double -> Int -> ((Int,Int),Double)
initial points cS i = ((setBit 0 i, i), getCollisionTime 0.0 0.0 cS tX tY dX dY)
  where Point{x=tX,y=tY,dx=dX,dy=dY} = points!i

extend :: Points -> Double -> Int -> (Int,Double) -> Double  
extend points cS to (from,t) = t + (getCollisionTime cX cY cS tX tY dX dY)
  where Point{x=cX,y=cY} = relocate t (points!from)
        Point{x=tX,y=tY,dx=dX,dy=dY} = relocate t (points!to)

members i j
  | i == 0 = []
  | even i = rest
  | odd i = j:rest
    where rest = members (i `div` 2) (j+1)
          
relocate :: Double -> Point -> Point
relocate t Point{x=x,y=y,dx=dx,dy=dy} = Point{x=x',y=y',dx=dx,dy=dy}
  where x' = x + dx * t
        y' = y + dy *t

-- copied from Brianna's solution (with mods, which are my fault)....
getCollisionTime cX cY cS tX tY dX dY
  | (cX==tX) && (cY==tY) = 0.0
  | otherwise = ((0.0-b) - (sqrt (b*b-4*a*c)))/(2*a)
    where
      pX = tX - cX
      pY = tY - cY
      a = dX * dX + dY * dY - cS * cS;
      b = 2 * dX * pX + 2 * dY * pY;
      c = pX * pX + pY * pY;
