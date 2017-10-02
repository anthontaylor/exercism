(ns trinary)

(defn to-decimal [x]
  (if (every? #{\0 \1 \2} x)
    (->> x
         seq
         (map (comp read-string str))
         (reduce #(+ (* %1 3) %2)))
    0))
