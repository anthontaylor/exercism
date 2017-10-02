(ns robot-name
  (:require [clojure.string :as s]))

(defn random-name
  []
  (let [alpha-char  "ABCDEFGHIJKLMNOPQRSTUVWXYZ"]
   (str (s/join (take 2 (repeatedly #(rand-nth alpha-char))))
        (+ (rand-int 100) 899))))

(defn robot
  []
  (atom {:name (random-name)}))

(defn robot-name
  [robot]
  (:name @robot))

(defn reset-name
  [robot]
  (swap! robot assoc :name (random-name)))
