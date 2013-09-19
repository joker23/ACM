{-# OPTIONS_GHC -O2 #-}

module Main where

import qualified System.IO as IO
import Data.Int
import qualified Data.List as DL
import qualified Data.Map as DM
import Debug.Trace

main =
  do IO.getContents >>=
       IO.putStr . DL.unlines . DL.map (show . solve) . parse . DL.lines

parse :: [String] -> [(Int,[Int])]
parse [x]
  | (read x) == 0 = []
  | otherwise = error "non-zero input terminator"
parse (nStr:tStr:strs) = (read nStr, parseEle $ tokenize tStr):(parse strs)

tokenize "" = []
tokenize str = (frst:tokenize snd)
  where [(frst,snd)] = lex str

parseEle :: [String] -> [Int]
parseEle [] = []
parseEle [""] = [] -- ms-dos end of line marker ??
parseEle (s:ss)
  | s == "(" = (concat $ replicate (read k) ts_0) ++ parseEle ss_0
  | otherwise = read s : parseEle ss
    where (ts_0,"*":k:ss_0) = parsePatn ss
          
parsePatn :: [String] -> ([Int],[String])
parsePatn (s:ss)
  | s == ")" = ([],ss)
  | s == "(" = ((concat $ replicate (read k) ts_1) ++ ts_2, ss_2)
  | otherwise = (read s : ts_0, ss_0)
    where (ts_0,ss_0) = parsePatn ss
          (ts_1,"*":k:ss_1) = parsePatn ss
          (ts_2,ss_2) = parsePatn ss_1

solve :: (Int,[Int]) -> Int64
solve (n,ts) = on (0,0) (cycle ts)
  where
    on :: (Int,Int64) -> [Int] -> Int64
    on (onSum,duration) (t:ts)
      | onSum + (fromIntegral t) >= n = duration + (fromIntegral (n-onSum))
      | otherwise = off (onSum+t,duration+(fromIntegral t)) ts
    off :: (Int,Int64) -> [Int] -> Int64
    off (onSum,duration) (t:ts) =
      onSum `seq` duration `seq` on (onSum,duration+(fromIntegral t)) ts
