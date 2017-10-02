(ns roman-numerals
  (:require [clojure.string :as s]))

(defn single
  [x]
  (case x
    \1 "I"
    \2 "II"
    \3 "III"
    \4 "IV"
    \5 "V"
    \6 "VI"
    \7 "VII"
    \8 "VIII"
    \9 "IX"
    \0 ""))

(defn tenth
  [x]
  (case x
    \1 "X"
    \2 "XX"
    \3 "XXX"
    \4 "XL"
    \5 "L"
    \6 "LX"
    \7 "LXX"
    \8 "LXXX"
    \9 "XC"
    \0 ""))

(defn hundredth
  [x]
  (case x
    \1 "C"
    \2 "CC"
    \3 "CCC"
    \4 "CD"
    \5 "D"
    \6 "DC"
    \7 "DCC"
    \8 "DCCC"
    \9 "CM"
    \0 ""))

(defn thousandth [x]
  (case x
    \1 "M"
    \2 "MM"
    \3 "MMM"
    (throw (Exception. "Value Not Accepted"))))

(defn parse
  ([a] [(single a)])
  ([a b] [(tenth a) (single b)])
  ([a b c] [(hundredth a) (tenth b) (single c)])
  ([a b c d] [(thousandth a) (hundredth b) (tenth c) (single d)]))

(defn numerals [x]
  (let [coll ((comp vec str) x)
        [a b c d] coll
        res (condp > x
              10 (parse a)
              100 (parse a b)
              1000 (parse a b c)
              3001 (parse a b c d)
              (throw (Exception. "Value Not Accepted")))]
    (s/join (map #(s/join "" %) res))))
