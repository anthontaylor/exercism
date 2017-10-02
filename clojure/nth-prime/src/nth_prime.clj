(ns nth-prime)

(defn prime?
  [n]
  (->> n
       inc
       Math/sqrt
       Math/ceil
       (range 2)
       (filter #(zero? (mod n %)))
       (empty?)))

(defn nth-prime
  [n]
  (if (> n 0)
    (->> (iterate inc 2)
        (filter prime?)
        (take n)
        last)
    (throw (IllegalArgumentException.))))
