(ns anagram
  (:require [clojure.string :as s]))

(defn anagram?
  [x y]
  (and (= (sort x)
          (sort y))
       (not= x y)))

(defn anagrams-for
  [x coll]
  (->> (map s/lower-case coll)
       (filter #(anagram? (s/lower-case x) %))))
