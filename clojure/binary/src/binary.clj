(ns binary)

(defn to-decimal [x]
  (if (every? #{\0 \1} x)
    (->> x
        seq
        (map (comp read-string str))
        (reduce #(+ (* %1 2) %2)))
    0))
