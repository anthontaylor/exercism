(ns hamming
  (:require [clojure.string :as s]))

(defn hamming
  [x y coll]
  (when (not= x y)
    (conj coll x)))

(defn distance [f g]
  (when (= (count f)
           (count g))
    (->> (map #(hamming %1 %2 []) f g)
         (filter identity)
         count)))
