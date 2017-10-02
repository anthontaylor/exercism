(ns rna-transcription)

(def rna  #{\G \C \T \A})

(defn to-set
  [a]
 (set a))

(defn check
  [input]
  (assert (= true (every? rna (to-set input)))))

(defn to-rna
  [input]
  (check input)
  (clojure.string/replace input #"G|C|T|A"  {"G" "C" "C" "G" "T" "A" "A" "U"}))
