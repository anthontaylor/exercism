(ns phone-number
  (:require [clojure.string :as s]))


(defn valid? [x]
  (let [num-length (count x)]
    (if (= 11 num-length)
      (= "1" (str (first x)))
      (and (> num-length 9)(< num-length 12)))))

(defn parse-string
  [x]
  (->> x
   (re-seq #"\d")
   s/join))

(defn number [x]
  (let [phone-number (parse-string x)]
    (if (valid? phone-number)
      (if (= 11 (count phone-number))
        (subs phone-number 1 11)
        phone-number)
      "0000000000")))

(defn area-code
  [x]
  (let [phone-number (parse-string x)]
    (when (valid? phone-number)
      (if (= 11 (count phone-number))
        (subs phone-number 1 4)
        (subs phone-number 0 3)))))

(defn pretty-print
  [x]
  (let [phone-number (parse-string x)]
    (when (valid? phone-number)
      (if (= 11 (count phone-number))
        (str "(" (subs phone-number 1 4) ") "
             (subs phone-number 4 7) "-"
             (subs phone-number 7 11))
        (str "(" (subs phone-number 0 3) ") "
             (subs phone-number 3 6) "-"
             (subs phone-number 6 10))))))
