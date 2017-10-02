(ns acronym
  (:require [clojure.string :as s]))

(defn parse
  [x]
  (if (every? #(Character/isUpperCase %) x)
    x
    (s/split x #"(?=[A-Z])")))

(defn acronym
  [words]
  (->> (s/split words #"[ :-]")
       (map parse)
       flatten
       (remove empty?)
       (map (comp first s/upper-case))
       (apply str)))
