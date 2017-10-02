(ns leap
  (:require [clojure.string :as s]))

(defn leap-year?
  [year]
  (if (and (= 0 (mod year 4)) (not= 0 (mod year 100)))
    true
    (if (= 0 (mod year 100))
      (if (= 0 (mod year 400))
        true
        false)
      false)))
