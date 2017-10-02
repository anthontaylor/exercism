(ns crypto-square
  (:require [clojure.string :as s]))

(def normalize (zipmap "abcdefghijklmnopqrstuvwxyz0123456789"
                       "abcdefghijklmnopqrstuvwxyz0123456789"))

(defn normalize-plaintext
  [x]
  (->> x
       s/lower-case
       seq
       (map normalize)
       (remove nil?)
       (apply str)
       s/join))

(defn square-size
  [sq]
  (-> sq count Math/sqrt Math/ceil int))

(defn plaintext-segments
  [x]
  (let [text (normalize-plaintext x)
        size (square-size text)]
    (->> text
         (partition-all size)
         (map #(apply str %)))))

(defn cipher
  [x]
  (let [text (normalize-plaintext x)
        size (square-size text)]
    (->> text
         (partition size size (repeat nil))
         (apply (partial map str)))))

(defn normalize-ciphertext
  ([x]
   (->> x cipher (s/join " "))))

(defn ciphertext
  [x]
  (-> x cipher s/join))
