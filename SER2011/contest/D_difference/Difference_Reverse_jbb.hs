{-# OPTIONS_GHC -O2 #-}

module Main where

import qualified System.IO as IO

main = do IO.getContents >>= outerLoop . map read . words
                
outerLoop (0:0:0:0:_) = return ()
outerLoop (a:b:c:d:vs) =
  do IO.putStrLn $ show $ solve 0 (a,b,c,d)
     outerLoop vs
        
solve :: Int -> (Int,Int,Int,Int) -> Int
solve count tup = if check tup then count else solve (count+1) (diff tup)
    
check (a,b,c,d) = a==b && b==c && c==d && d==a
                
diff (a,b,c,d) = (abs (a-b),abs (b-c),abs (c-d), abs (d-a))
