(ns strain)

(defn retain
  [f coll]
  (->> coll
       (reduce (fn [acc x] (if (f x) (conj acc x) acc)) [])))

(defn discard
  [f coll]
  (->> coll
   (reduce (fn [acc x] (if-not (f x) (conj acc x) acc)) [])))
