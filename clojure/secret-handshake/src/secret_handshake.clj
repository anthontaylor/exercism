(ns secret-handshake)

(defn check-reverse
  [x coll]
  (if (= x "reverse")
    (reverse coll)
    coll))

(defn secret
  [i n]
  (case [i n]
    [0 \1] "wink"
    [1 \1] "double blink"
    [2 \1] "close your eyes"
    [3 \1] "jump"
    [4 \1] "reverse"
    false))

(defn commands
  [n]
  (as-> (->> (Integer/toString n 2)
             seq
             reverse
             (map-indexed secret)
             (remove false?)) coll
    (->> coll
         (map #(check-reverse % coll))
         last
         (remove #(= % "reverse")))))
