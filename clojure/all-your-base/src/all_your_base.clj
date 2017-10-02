(ns all-your-base)

(defn valid-digits?
  [from xs]
  (when-not (empty? xs)
    (-> from range set (every? xs))))

(defn valid-base?
  [from to]
  (->> [from to]
       (map #(or (nil? %) (< % 2)))
       (every? false?)))

(defn valid?
  [from xs to]
  (and (valid-base? from to)
       (valid-digits? from xs)))

(defn from-base
  [from xs]
  (->> xs (reduce #(+ (* %1 from) %2))))

(defn to-base [to n]
  (if-not (zero? n)
    (loop [n n
             xs '()]
        (if (zero? n)
          xs
          (recur (quot n to)
                 (conj xs (mod n to)))))
      '(0)))

(defn convert
  [from xs to]
  (when (valid? from xs to)
    (->> xs (from-base from) (to-base to))))
