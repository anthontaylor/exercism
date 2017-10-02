(ns clock
  (:require [clojure.string :as s]
            [clojure.tools.trace :refer [trace]]))


(defn clock->string
  [x]
  x)

(defn rollover-hours
  [hrs min]
  (let [hours (mod hrs 24)
        rollover (quot min 60)
        result (mod (+ hours rollover) 24)]
    (if (neg? min)
      (mod (dec result) 24)
      result)))

(defn rollover-minutes
  [x]
  (mod x 60))

(defn handle-digits
  [x]
  (if (and (< x 10) (>= x 0))
    (s/join (concat "0" (str x)))
    (str x)))

(defn clock
  [x y]
  (let [minutes (handle-digits (rollover-minutes y))
        hours (handle-digits (rollover-hours x y))]
    (str hours ":" minutes)))

(defn parse-string [x]
  (Integer. (s/join x)))

(defn add-time
  [x y]
  (let [hours (parse-string (take 2 x))
        mins (parse-string (drop 3 x))]
    (clock hours (+ mins y))))
