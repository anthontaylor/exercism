(ns allergies)

(defn binary
  [x sum]
  (let [n (cond
            (< x 1) 0
            (< x 2) 1
            (< x 4) 2
            (< x 8) 4
            (< x 16) 8
            (< x 32) 16
            (< x 64) 32
            (< x 128) 64
            :else 128)]
    (if (zero? n)
      sum
      (recur (mod x n) (conj sum n)))))

(defn num->allergy [x]
  (case x
    1 :eggs
    2 :peanuts
    4 :shellfish
    8 :strawberries
    16 :tomatoes
    32 :chocolate
    64 :pollen
    128 :cats))

(defn allergies
  [n]
  (->> []
       (binary n)
       reverse
       (map num->allergy)))

(defn allergic-to?
  [x y]
  (-> x
      allergies
      set
      (contains? y)))
