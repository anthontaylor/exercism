(ns octal)

(defn oct->dec [val exp]
  (* val (reduce * (repeat exp 8))))

(defn converter [acc x]
  (let [{:keys [exp value]} x]
    (update acc :value + (oct->dec value exp))))

(defn to-decimal [x]
  (if (every? #{\0 \1 \2 \3 \4 \5 \6 \7} x)
    (->> x
         seq
         (map (comp read-string str))
         reverse
         (map-indexed (fn [exp val] {:exp exp :value val}))
         (reduce converter {:exp 0 :value 0})
         :value)
    0))
