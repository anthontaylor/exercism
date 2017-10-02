(ns pascals-triangle)


(defn calculate
  [coll]
  (->> coll
       (concat [0])
       (partition-all 2 1)
       (map #(reduce +' %))))

(def triangle (iterate calculate [1]))

(defn row
  [n]
  (last (take n triangle)))
