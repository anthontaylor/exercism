(ns difference-of-squares)

(defn square
  [n]
  (* n n))

(defn square-of-sums
  [n]
  (->> n
       inc
       (range 1)
       (reduce +)
       square))

(defn sum-of-squares
  [n]
  (->> n
       inc
       (range 1)
       (map square)
       (reduce +)))

(defn difference
  [n]
  (- (square-of-sums n)
     (sum-of-squares n)))
