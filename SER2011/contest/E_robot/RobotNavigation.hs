{-# OPTIONS_GHC -O2 #-}

module Main where

import qualified System.IO as IO
import qualified Data.List as DL

import Data.Array.IO
import Data.Array.Base
import Debug.Trace
import Text.Printf -- non-stand library usage here, likely not in contest environment.

enableTrace = False

main = do IO.getContents >>=  outerLoop . DL.lines
                
outerLoop :: [String] -> IO ()
outerLoop [] = return ()
outerLoop (line:lines)
  | (n==0) || (m==0) = return ()
  | otherwise = do grid <- mkGrid n m $ concatMap (\s->take m s) $ DL.take n lines
                   item@Item{loc=start,dir=dir} <- findStart grid
                   finish <- findFinish grid
                   memo <- mkMemo n m
                   writeArray memo (start,dir) (Just Path{pathLen=0,pathCnt=1})
                   (len,cnt) <- solve memo grid finish [item]
                   IO.putStrLn (show len++" "++show cnt)
                   outerLoop (DL.drop n lines)
    where (n:m:_) = map read $ DL.words line

data Direction = North | East | South | West deriving (Eq, Ord, Enum, Ix)

instance Show Direction where
  showsPrec p North = showChar 'N'
  showsPrec p East  = showChar 'E'
  showsPrec p South = showChar 'S'
  showsPrec p West  = showChar 'W'

toDirection 'N' = North
toDirection 'E' = East
toDirection 'S' = South
toDirection 'W' = West

type Location = (Int,Int)

type Grid = IOUArray Location Char

mkGrid :: Int -> Int -> String -> IO (Grid)
mkGrid n m chars = newListArray ((1,1),(n,m)) chars
 
showGrid :: Grid -> IO ([String])
showGrid grid =
  do (_,(_,m)) <- getBounds grid
     g <- getElems grid
     return (helper m g)
    where helper _ [] = []
          helper m gs = f:(helper m b) where (f,b) = splitAt m gs
        

findStart :: Grid -> IO (Item)
findStart grid = do do a <- getAssocs grid ; return (helper a)
  where helper ((i,v):as) =
          if DL.elem v ['N','E','S','W']
          then Item{loc=i, dir=(toDirection v), path=Path{pathLen=0,pathCnt=1}}
          else helper as

findFinish :: Grid -> IO (Location)
findFinish grid = do a <- getAssocs grid ; return (helper a)
  where helper ((i,v):as) = if v == 'X' then i else helper as

gridValue :: Grid -> Location -> IO(Char)
gridValue grid loc =
  do b <- getBounds grid
     if inRange b loc
       then do v <- readArray grid loc; return v
       else return '*'

data Path = Path { pathLen::Int, pathCnt::Int } deriving (Eq)
instance Show Path where
  showsPrec p Path{pathLen=x,pathCnt=y} =
    showString "P{" . shows x . showChar ',' . shows y . showChar '}'
  
type Memo = IOArray (Location,Direction) (Maybe Path)

mkMemo :: Int -> Int -> IO(Memo)
mkMemo n m = newArray (((1,1),North),((n,m),West)) Nothing
showMemoLoc l memo =
  do ms <- mapM (\d->(readArray memo (l,d))) [North .. West]
     return ( [(show l)++":"++(foldl oneElement "" (zip [North .. West] ms))] )
  where oneElement str (_,Nothing)  = str
        oneElement str (d,Just v) = str++(show d)++":"++(show v)++","
        
solve :: Memo -> Grid -> Location -> [Item] -> IO (Int,Int)
solve memo grid finish states | memo `seq` grid `seq` states `seq` False = undefined
solve _ _ _ [] = return (0,0)
solve memo grid finish items@(Item{loc=l,dir=d,path=Path{pathLen=c,pathCnt=x}}:ss)
  | l == finish = do ms <- mapM (\dir->readArray memo (finish,dir)) [North .. West]
                     return (c,addUp c ms)
  | otherwise = do traceSolve
                   ahead <- travel memo grid l d (c+1) x ss
                   left <- update memo l (turnLeft d) (c+1) x ahead
                   right <- update memo l (turnRite d) (c+1) x left
                   solve memo grid finish right
    where
      traceSolve
        | enableTrace = do bg <- getBounds grid
                           mLoc <- showMemoLoc l memo
                           mFin <- showMemoLoc finish memo
                           IO.hPutStrLn IO.stderr $ DL.unlines $ msg bg mLoc mFin
        | otherwise = return ()
          where msg (_,(n,m)) mLoc mFin = [banner,show (take 5 items)]++mFin++mLoc
                  where banner = printf "n:%d m:%d f:(%d,%d) l:(%d,%d)" n m iF jF iL jL
                        (iF,jF) = finish
                        (iL,jL) = l
    
addUp len ms
  | enableTrace = trace (DL.unwords msg) result
  | otherwise = result
    where result = sum values
          values = map (maybe 0 helper) ms
          msg = ["addUp:", show ms]
          helper Path{pathLen=l,pathCnt=cnt} =
            if l < len then error "addUp: shorter path in memo"
            else if l == len then cnt else 0

turnLeft North = West
turnLeft West  = South
turnLeft South = East
turnLeft East  = North

turnRite North = East
turnRite East  = South
turnRite South = West
turnRite West  = North

travel :: Memo -> Grid -> Location -> Direction -> Int -> Int -> [Item] -> IO ([Item])
travel memo grid loc dir len cnt items =
  do v <- gridValue grid nextLoc
     if (v /= '.') && (v /= 'X')
       then return items
       else do newQ <- update memo nextLoc dir len cnt items
               travel memo grid nextLoc dir len cnt newQ
    where nextLoc = move dir loc
          
update :: Memo -> Location -> Direction -> Int -> Int -> [Item] -> IO ([Item])
update memo loc dir len cnt items =
  do m <- readArray memo idx ; r <- maybe initial revise m ; return r
    where
      initial :: IO([Item])
      initial = do writeArray memo idx (Just Path{pathLen=len,pathCnt=cnt}) ; return (newQ cnt)
      revise :: Path -> IO([Item])
      revise Path{pathLen=pLen,pathCnt=pCnt} =
        if len < pLen -- shorter path, reset memo entry
        then do writeArray memo idx (Just Path{pathLen=len,pathCnt=cnt})
                return (newQ cnt)
        else if len == pLen -- equal path, increment path count
             then let newC = (pCnt+cnt) `mod` 1000000
                  in do writeArray memo idx (Just Path{pathLen=pLen,pathCnt=newC})
                        return (newQ newC)
             else return items -- longer path, ignore
      idx = (loc,dir)
      newQ c = enqueue Item{loc=loc,dir=dir,path=Path{pathLen=len,pathCnt=c}} items
  
move :: Direction -> Location -> Location
move North (i,j) = ((i-1), j)
move East  (i,j) = (i,     (j+1))
move South (i,j) = ((i+1), j)
move West  (i,j) = (i,     (j-1))

data Item = Item{ loc::Location, dir::Direction, path::Path } deriving (Eq)
instance Show Item where
  showsPrec p Item{loc=loc,dir=dir,path=path} =
    showString "I{" . shows loc . showChar ',' . shows dir . showChar ','
    . shows path . showChar '}'

enqueue :: Item -> [Item] -> [Item]
enqueue item [] = [item]
enqueue item'@Item{loc=loc',dir=dir',path=Path{pathLen=len',pathCnt=cnt'}}
  all@(item@Item{loc=loc,dir=dir,path=Path{pathLen=len,pathCnt=cnt}}:items)
  | item == item' = all
  | (len' < len)
    || ((len' == len) && (loc' < loc))
    || ((len' == len) && (loc' == loc) && (dir' < dir)) = (item' : all)
  | ((len' == len) && (loc' == loc) && (dir' == dir)) = (item' : items)
  | otherwise = (item : enqueue item' items)
