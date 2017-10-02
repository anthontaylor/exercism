(ns binary-search-tree)

(defn value
  [tree]
  (first tree))

(defn singleton
  [n]
  [n nil nil])

(defn left
  [tree]
  (second tree))

(defn right
  [tree]
  (last tree))

(defn insert
  [n tree]
  (let [root (value tree)]
    (cond
      (nil? root) (singleton n)
      (<= n root) [root (insert n (left tree)) (right tree)]
      (> n root) [root (left tree) (insert n (right tree))])))

(defn from-list
  [[x & xs]]
  (reduce #(insert %2 %1) (singleton x) xs))

(defn to-list
  [coll]
  (->> coll
       flatten
       (remove nil?)
       sort))
