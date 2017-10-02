(ns grains)

(defn square
  [x]
  (->> (repeat (dec x) 2)
       (reduce *')))

(defn total
  []
  (->> (range 1 65)
       (map square)
       (reduce +)))
