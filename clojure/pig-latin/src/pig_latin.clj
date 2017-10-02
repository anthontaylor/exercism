(ns pig-latin
  (:require [clojure.string :as s]))

(defn vowel?
  [x]
  (contains? #{\a \e \i \o \u} x))

(defn cluster-number
  [word]
  (case (take 2 word)
    [\y \t] 0
    [\x \r] 0
    [\c \h] 2
    [\q \u] 2
    [\t \h] (if (= [\t \h \r] (take 3 word)) 3 2)
    [\s \q] (if (vowel? (first word)) false 3)
    [\s \c] (if (= [\s \c \h] (take 3 word)) 3 2)
    1))

(defn rule-2
  [word]
  (let [n (cluster-number word)]
    (-> (drop n word)
        (cons [(take n word)])
        (cons [\a \y])
        flatten)))

(defn rule-1
  [word]
  (->>  [\a \y]
        (cons word)
        flatten))

(defn pig-latinize
  [word]
  (if (vowel? (first word))
    (rule-1 (seq word))
    (rule-2 (seq word))))

(defn translate
  [word]
  (->> (s/split word #" ")
       (map (comp #(apply str %) pig-latinize))
       (s/join #" ")))
