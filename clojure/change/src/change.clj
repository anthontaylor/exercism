(ns change)

(defn change
  [coins leftover n]
  (if-not (zero? leftover)
    (if (>= leftover n)
      (change (conj coins n) (- leftover n) n)
      {:coins coins :leftover leftover})
    {:coins coins :leftover leftover}))

(defn collect
  [{:keys [leftover coins]} n]
  (change coins leftover n))

(defn lesser?
  [leftover coin]
  (if (and (< leftover coin)
           (not (zero? leftover)))
    true
    false))

(defn variations
  [n xs]
  (->> xs
       (reduce collect {:leftover n :coins []})
       :coins
       sort))

(defn change-variations
  [n xs]
  (let [coll (sort > xs)]
    (->> xs
         count
         range
         (map #(drop % coll))
         (map #(variations n %)))))

(defn issue
  [n xs]
  (if-not (or (neg? n) (every? #(lesser? n %) xs))
    (reduce (fn [acc x]
              (if (> (count acc) (count x))
                x
                acc))
            (change-variations n xs))
    (throw (IllegalArgumentException. "cannot change"))))
