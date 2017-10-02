(ns luhn)

(defn sum-divisible?
  [x]
  (let [sum (reduce + x)]
    (zero? (rem sum 10))))

(defn double-it
  [n]
  (let [x (->> n (repeat 2) (reduce +))]
    (if (> x 9)
      (- x 9)
      x)))

(defn map-nth [f n coll]
  (map-indexed #(if (zero? (mod (inc %1) n)) (f %2) %2) coll))

(defn doubling
  [x]
  (->> x
       reverse
       (map #(Integer. %))
       (map-nth double-it 2)
       reverse))

(defn parse
  [x]
  (let [nums #{\0 \1 \2 \3 \4 \5 \6 \7 \8 \9 \space}
        digits (re-seq #"\d" x)]
    (when (and (every? nums (seq x))
               (> (count digits) 1))
      digits)))

(defn valid?
  [x]
  (if (some-> x parse doubling sum-divisible?)
    true
    false))
