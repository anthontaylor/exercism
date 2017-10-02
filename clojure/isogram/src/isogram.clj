(ns isogram
  (:require [clojure.string :as s]))

(defn isogram?
  [x]
  (->> x
       s/lower-case
       seq
       (remove #(or (= \space %) (= \- %)))
       frequencies
       (map (fn [[k v]] (< v 2)))
       (every? true?)))
