(ns rotational-cipher
  (:require [clojure.string :as s]))

(defn find-letter-value
  [letter number]
  (let [alpha "abcdefghijklmnopqrstuvwxyz"]
    (if (Character/isLetter letter)
      (if (Character/isUpperCase letter)
        (nth (-> alpha s/upper-case) number)
        (nth alpha number))
      letter)))

(defn find-letter-number
  [letter]
  (let [alpha "abcdefghijklmnopqrstuvwxyz"]
    (if (Character/isUpperCase letter)
      (.indexOf (-> alpha s/upper-case seq) letter)
      (.indexOf (-> alpha seq) letter))))

(defn rotate
  [text rotation]
  (->> text
       (map (comp #(mod % 26) #(+ rotation %) find-letter-number))
       (map #(find-letter-value %1 %2) (seq text))
       (apply str)))
