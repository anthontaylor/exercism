(ns binary-search)

(defn middle [coll]
  (quot (count coll) 2))

(defn search-for [target numlist]
  (loop [lower 0
         upper (dec (count numlist))]
    (if (> lower upper)
      (throw (Exception. "not found"))
      (let [mid (quot (+ lower upper) 2)
            midvalue (nth numlist mid)]
        (cond
          (> midvalue target) (recur lower (dec mid))
          (< midvalue target) (recur (inc mid) upper)
          (= midvalue target) mid)))))
