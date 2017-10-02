(ns queen-attack
  (:require [clojure.string :refer [join]]
            [clojure.tools.trace :refer [trace]]))

(defn board
  [{w-coordinates :w b-coordinates :b}]
  (->> (for [x (range 8)
             y (range 8)]
         (cond
           (= [x y] w-coordinates) :w
           (= [x y] b-coordinates) :b
           :else :e))
       (partition 8)))

(defn format-board
  [row]
  (let [result (->> row
                   (map (fn [x] (case x :e \_ :b \B :w \W)))
                   (interpose \space))]
    (concat result "\n")))

(defn board-string
  [{w-coordinates :w b-coordinates :b :as coordinates}]
  (let [symbol-mapping {:e \_ :w \W :b \B}
        chess-board (board coordinates)]
    (->> chess-board
         (map format-board)
         (map #(apply str %))
         join)))

(defn- diagonal?
  [[wx wy] [bx by]]
  (= (- wx bx) (- wy by)))

(defn can-attack
  [{[wx wy] :w [bx by] :b}]
     (cond
       (= wx bx) true
       (= wy by) true
       (diagonal? [wx wy] [bx by]) true
       :else false))
