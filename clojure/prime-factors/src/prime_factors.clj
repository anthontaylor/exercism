(ns prime-factors)

(defn of
  ([n] (of 2 n))
  ([x n]
   (cond
     (> x (Math/sqrt n)) (if (= n 1) [] [n])
     (zero? (mod n x)) (cons x (of x (/ n x)))
     :else (recur (inc x) n))))
