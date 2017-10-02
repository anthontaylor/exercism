(ns accumulate)

(defn my-map
  [f [x & xs] new]
  (if (nil? x)
    new
    (recur f xs (conj new (f x)))))

(defn accumulate
  [f coll]
  (if (empty? coll)
    coll
    (my-map f coll [])))
