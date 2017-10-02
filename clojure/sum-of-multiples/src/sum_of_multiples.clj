(ns sum-of-multiples)

(defn multiple?
  [n coll]
  (->> coll
       (map #(zero? (rem n %)))
       (some true?)))

(defn sum-of-multiples
  [coll n]
  (->> n
       (range 1)
       (filter #(multiple? % coll))
       (reduce +)))
