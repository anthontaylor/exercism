(ns largest-series-product)

(defn largest
  [length xs]
  (->> xs
       seq
       (map (comp read-string str))
       (partition length 1)
       (map #(reduce * %))
       (apply max)))

(defn largest-product
  [length xs]
  (cond
    (> length (count xs)) (throw (Exception.))
    (zero? length) 1
    :else (largest length xs)))
