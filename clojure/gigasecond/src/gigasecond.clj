(ns gigasecond
  (:require [clj-time.core :as t]
            [clj-time.format :as f]
            [clojure.string :as s]))

(defn from [y m d]
  (let [date (t/plus (t/date-time y m d) (t/seconds 1000000000))]
    (->> (s/split (f/unparse (f/formatters :year-month-day) date) #"-")
         (mapv #(Integer. %)))))
