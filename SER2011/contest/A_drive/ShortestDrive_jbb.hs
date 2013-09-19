{-# OPTIONS_GHC -O2 #-}

module Main where

import qualified System.IO as IO
import Data.Array.Unboxed
import Debug.Trace
import Text.Printf -- non-standard library usage here...

laneWidth = 10.0
changeDist = 100.0

enableTrace = False

main = do IO.getContents >>= outerLoop . words
                
outerLoop (nStr:mStr:strs)
  | (n==0)||(m==0) = return ()
  | otherwise = 
    do IO.putStrLn $ printf "%.2f" (solve n m (parse x))
       outerLoop y
    where (x,y) = splitAt (2*n) strs
          n = read nStr::Int
          m = read mStr::Int
        
data Segment = S Double | L Double | R Double deriving (Eq,Show)

parse [] = []
parse (c:v:ss)
  | c == "S" = S value : rest
  | c == "L" = L value : rest
  | c == "R" = R value : rest
    where value = fromIntegral $ read v
          rest = parse ss

solve :: Int -> Int -> [Segment] -> Double
solve n m segs = minimum $ elems lanes
  where lanes = foldl doOneSegment (listArray (0,(m-1)) (repeat 0.0)) segs
        
doOneSegment :: Array Int Double -> Segment -> Array Int Double
doOneSegment ary seg
  | enableTrace = trace (unwords msg) result
  | otherwise = result
    where result = doOneSegment' ary seg
          msg = ["doOneSegment:",
                 "inAry=", show $ elems ary,
                 "seg=", show seg,
                 "is", show $ elems result]
          
doOneSegment' inAry (L v) = listArray (bounds inAry) newValues
  where newValues = [(inAry!i) + (circum i v) | i <- indices inAry]
        
doOneSegment' inAry (R v) = listArray (bounds inAry) newValues
  where newValues = [(inAry!i) + (circum (m-i) v) | i <- indices inAry]
        (_,m) = bounds inAry
        
doOneSegment' inAry (S v) = listArray (bounds inAry) [(newV i) | i <- indices inAry]
  where newV i = minimum $ map (laneChange inAry v i) (indices inAry)

circum i v = (((fromIntegral i) + 0.5) * laneWidth + v) * (2.0 * pi / 4.0)

laneChange inAry v i j
  | i == j = (inAry!i) + v
  | (deltaLanes * changeDist) <= v = (inAry!j) + hypot
  | otherwise = (inAry!i) + v -- not enuf distance, stay in lane
    where deltaLanes = fromIntegral $ abs (i-j)
          hypot = sqrt ((v*v)+(x*x))
          x =  deltaLanes * laneWidth

