(ns hello-world)

(defn hello   
([] "Hello, World!")
([name] 
(if (identical? name "Alice")
  "Hello, Alice!"
  "Hello, Bob!")))
