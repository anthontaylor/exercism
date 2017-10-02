(ns wordy
  (require [clojure.string :as s]))

(defn remove-question
  [x]
  (->> x
       seq
       (remove
        #(= \? %))))

(defn words?
  [x]
  (or (= "What" x)
      (= "is" x)
      (= "by" x)))

(defn parse-words
  [x]
  (condp = x
    "plus" +
    "minus" -
    "divided" /
    "multiplied" *
    (read-string x)))

(defn run-expression
  ([x1 op x2] (op x1 x2))
  ([x1 op1 x2 op2 x3] (op2 (op1 x1 x2) x3)))

(defn evaluate
  [x]
  (->> (s/split x #" ")
       (remove words?)
       (map (comp parse-words
                  #(apply str %)
                  remove-question))
       (apply run-expression)))
