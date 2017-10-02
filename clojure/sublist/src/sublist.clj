(ns sublist
  (:require [clojure.string :as s]))

(defn return-subset
  [coll1 coll2]
  (let [x (s/join (mapcat #(str % ",") coll1))
        y (s/join (mapcat #(str % ",") coll2))]
    (re-find (re-pattern x) y)))

(defn classify
  [x y]
  (cond
    (= x y) :equal
    (return-subset x y) :sublist
    (return-subset y x) :superlist
    :else :unequal))
