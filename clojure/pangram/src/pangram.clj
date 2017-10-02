(ns pangram
  (:require [clojure.set :refer [subset?]]
            [clojure.string :refer [lower-case]]))

(defn pangram?
  [x]
  (let [alpha (->> (range 97 123) set)]
    (->> x
         lower-case
         seq
         (map int)
         (filter #(and (> % 96) (< % 124)))
         set
         (subset? alpha))))
