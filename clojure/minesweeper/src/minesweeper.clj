(ns minesweeper
  (:require [clojure.string :refer [join]]))

(defn parse-board
  [x]
  x)

(defn draw
  [x]
  (if-not (empty? x)
    (parse-board x)
    x))
