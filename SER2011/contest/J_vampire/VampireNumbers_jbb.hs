{-# OPTIONS_GHC -O2 #-}

module Main where

import qualified System.IO as IO
import Data.List

main = do IO.getContents >>= outerLoop . map read . words
                
outerLoop [0] = return ()
outerLoop (x:xs) =
  do IO.putStrLn $ solve x
     outerLoop xs
        
solve :: Int -> String
solve x
  | isVampire x = show x
  | otherwise = solve (x+1)
                
isVampire :: Int -> Bool
isVampire v = any check (map myMult (concatMap splitter (perms v)))
  where check x = v == x
        perms x = permutations $ digits x
    
myMult :: ([Int],[Int]) -> Int
myMult (a,b) = (undigits a) * (undigits b)
    
splitter :: [Int] -> [([Int],[Int])]
splitter xs = map (\i->splitAt i xs) [1..(length xs)-1]
    
digits :: Int -> [Int]
digits 0 = [0]
digits i = helper i []
  where helper i ds
          | i == 0 = ds
          | otherwise = helper d (m:ds)
            where (d,m) = i `divMod` 10
          
undigits :: [Int] -> Int
undigits ds = helper 0 ds
  where helper result [] = result
        helper result (d:ds) = helper (10*result + d) ds
