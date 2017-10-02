(ns kindergarten-garden
  (:require [clojure.string :as s]))

(defn plants
  [x]
  (case x
    \V :violets
    \R :radishes
    \C :clover
    \G :grass))

(defn assign-plants
  [[k v] item]
  (let [value (-> (conj v item) flatten vec)]
    {k value}))

(defn populate
  [x coll]
  (let [s-coll (into (sorted-map) coll)]
    (->> x
         (map plants)
         (partition-all 2)
         (map assign-plants s-coll)
         (into {}))))

(defn kindergarten
  [x names]
  (let [[x y] (->> x s/split-lines (map seq))
        data (map (fn [x] {x []}) names)
        students-plants (->> (populate x data) (populate y))]
    students-plants))

(defn garden
  ([x]
   (garden x ["Alice" "Bob" "Charlie" "David" "Eve" "Fred" "Ginny" "Harriet" "Ileana" "Joseph" "Kincaid" "Larry"]))
  ([x students]
   (let [names (->> students (map s/lower-case) (map keyword))]
     (kindergarten x names))))
