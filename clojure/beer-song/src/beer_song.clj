(ns beer-song)
 
(defn verse
  [n]
  (if (pos? n)
    (let [x (- n 1)]
      (println n " bottles of beer on the wall," n "bottles of beer.\nTake one down and pass it around," x "bottles of beer on the wall.\n"))
    (println "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.")))

(defn sing [n]
  (verse n)
  (when (not= true (= n 0))
    (recur (- n 1))))


