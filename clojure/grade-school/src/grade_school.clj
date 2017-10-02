(ns grade-school
  (:require [clojure.string :as s]
            [clojure.tools.trace :refer [trace]]))

(defn grade [db num]
  (vec (get db num)))

(defn add [db name num]
  (let [coll (grade db num)
        n (conj coll name)]
   (assoc db num n)))

(defn sort-names
  [coll]
  (into {} (for [[k v] coll]
            (assoc {} k(vec (sort v))))))

(defn sorted [vals]
  (->> vals
       (into (sorted-map))
       sort-names))
