module Main where

data Person = Person { name     :: String
                     , children :: [Person]
                     } deriving (Show)

isEmpty :: [a] -> Bool
isEmpty [] = True
isEmpty [a] = False

contains :: Person -> String -> Bool
contains (Person n []) val = n == val
contains p val
    | n == val  = True
    | otherwise = case (p2 `contains` val) of
                      True  -> True
                      False -> case (isEmpty xs) of
                                  True  -> False
                                          -- Create with 'leftovers'
                                  False -> (Person n xs) `contains` val
  where (Person n (p2:xs)) = p


searchGenOf :: Person -> String -> Int
searchGenOf (Person name []) val = if (name == val) then 0 else (error "Wrong")
searchGenOf (Person name (p2:xs)) val
    | name == val = 0
    | otherwise   = case (p2 `contains` val) of
                      True  -> 1 + (searchGenOf p2 val)
                      False -> (Person name xs) `searchGenOf` val

main :: IO ()
main = do
  let children = [Person "Andreas" [Person "Lukas" [] ], Person "Roswitha" []]
  let josef = Person "Josef" children

  print $ josef `contains `"Lukas"
  print $ josef `searchGenOf` "Roswitha"
