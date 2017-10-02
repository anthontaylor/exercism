(ns perfect-numbers)

(defn aliquot
  [n x]
  (case (compare n x)
    -1 :abundant
    0 :perfect
    1 :deficient))

(defn get-divisors [n]
  (filter #(zero? (mod n %)) (range 1 n)))

(defn classify [n]
  (assert (pos? n)(throw (IllegalArgumentException. "Negative Number")))
  (->> n
       get-divisors
       (reduce +)
       (aliquot n)))
