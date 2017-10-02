(ns raindrops
  (:require [clojure.string :as s]))

(defn rain
  [n]
  (case n
    3 "Pling"
    5 "Plang"
    7 "Plong"
    nil))

(defn convert
  [n]
  (let [coll  (->> (inc n)
                   (range 1)
                   (filter #(zero? (rem n %)))
                   (map rain)
                   (s/join))]
    (if (empty? coll)
      (str n)
      coll)))
