(ns atbash-cipher
  (:require [clojure.string :as s]))


(def atbash-key (zipmap "abcdefghijklmnopqrstuvwxyz0123456789"
                        "zyxwvutsrqponmlkjihgfedcba0123456789"))

(defn encode
  [x]
  (->> x
       s/lower-case
       seq
       (map atbash-key)
       (remove nil?)
       (apply str)
       (partition-all 5)
       (map s/join)
       (s/join " ")))
