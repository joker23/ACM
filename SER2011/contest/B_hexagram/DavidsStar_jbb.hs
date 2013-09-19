{-# OPTIONS_GHC -O2 #-}

module Main where

import qualified System.IO as IO
import qualified Data.List as DL
import Debug.Trace

main = do IO.getContents >>= outerLoop . map read . DL.words
                
outerLoop (0:_) = return ()
outerLoop vs =
  do IO.putStrLn $ show $ length $ solve (take 12 vs)
     outerLoop (drop 12 vs)
        
solve :: [Int] -> [[Int]]
solve vs
  | m /= 0 = []
  | otherwise = 
    DL.nubBy reflected $ DL.nubBy rotated $ filter sumOk $ generate s vs
      where
        (s,m) = (2*(sum vs)) `divMod` 6 -- 6 lines, each v appears in 2 lines
                

reflected [a,b,c,d,e,f,g,h,i,j,k,l] y
  | [a,l,k,j,i,h,g,f,e,d,c,b] == y = True -- along the a..g axis
--
-- note that the way generate selects a permutation of the vertices by
-- ensuring that the abde line has different values from the ghjk line
-- means that other reflections are not possible...
--
-- probably should add the other refelctions here anyway just to be
-- safe, but i am too lazy...
--
  | otherwise = False

-- i think that only the six rotations by 60 degrees maintain the
-- constraint on the sum of the vertices along the lines. but we
-- include all rotations just to be safe...
rotated [a,b,c,d,e,f,g,h,i,j,k,l] y
  | [a,b,c,d,e,f,g,h,i,j,k,l] == y = True
  | [l,a,b,c,d,e,f,g,h,i,j,k] == y = True
  | [k,l,a,b,c,d,e,f,g,h,i,j] == y = True
  | [j,k,l,a,b,c,d,e,f,g,h,i] == y = True
  | [i,j,k,l,a,b,c,d,e,f,g,h] == y = True
  | [h,i,j,k,l,a,b,c,d,e,f,g] == y = True
  | [g,h,i,j,k,l,a,b,c,d,e,f] == y = True
  | [f,g,h,i,j,k,l,a,b,c,d,e] == y = True
  | [e,f,g,h,i,j,k,l,a,b,c,d] == y = True
  | [d,e,f,g,h,i,j,k,l,a,b,c] == y = True
  | [c,d,e,f,g,h,i,j,k,l,a,b] == y = True
  | [b,c,d,e,f,g,h,i,j,k,l,a] == y = True
  | otherwise = False

sumOk [a,b,c,d,e,f,g,h,i,j,k,l]
  | (u==v)&&(v==w)&&(w==x)&&(x==y)&&(y==z) = True
  | otherwise = False
    where u = a + b + d + e
          v = c + d + f + g
          w = e + f + h + i
          x = g + h + j + k
          y = i + j + l + a
          z = k + l + b + c

generate targetSum vs = map properOrder stars
  where
    stars = [(xs,ys',zs'')| (xs,ys) <- filteredChoice targetSum vs,
             (ys',zs') <- filteredChoice targetSum ys,
             zs'' <- DL.permutations zs']
    properOrder ([a,b,d,e],[g,h,j,k],[c,f,i,l]) = [a,b,c,d,e,f,g,h,i,j,k,l]
    
filteredChoice targetSum vs = filter filt (chooseFrom 4 vs)
  where filt (xs,ys) = sum xs == targetSum
    
chooseFrom 1 xs = [([x],(DL.delete x xs)) | x<-xs]
chooseFrom n xs = (concatMap nestedChoice xs)
  where nestedChoice x =
          [((x:xs'),ys')| (xs',ys') <- (chooseFrom (n-1) (DL.delete x xs))]

-- filteredChoice targetSum vs =
--   filter myPredicate [([w,x,y,z],vs\\[w,x,y,z]) | w<-vs, x<-vs, y<-vs, z<-vs]
--   where
--     myPredicate (ps@[w,x,y,z],_)
--       | w == x = False
--       | w == y = False
--       | w == z = False
--       | x == y = False
--       | x == z = False
--       | y == z = False
--       | otherwise = (sum ps) == targetSum

tryit = solve [3, 17, 15, 18, 11, 22, 12, 23, 21, 7, 9, 13]
