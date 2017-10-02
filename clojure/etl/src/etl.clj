(ns etl
  (:require [clojure.string :as s]))

(defn parse-map
  [coll]
  (let [db {}]
    (map (fn [[key vals]]
           (map #(assoc db (s/lower-case %) key) vals)) coll)))

(defn transform
  [coll]
  (->> coll
       parse-map
       flatten
       (into {})))
