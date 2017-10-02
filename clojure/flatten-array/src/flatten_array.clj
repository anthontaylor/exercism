(ns flatten-array
  (:require [clojure.string :as s]
            [clojure.core :as c]))

(defn flatten
  [coll]
  (->> coll
   c/flatten
   (remove nil?)
   vec))
