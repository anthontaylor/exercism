(ns nucleotide-count
  (:require [clojure.string :as s]))

(defn nucleotide-counts
  [dna]
  (merge {\A 0 \T 0 \C 0 \G 0} (frequencies dna)))

(defn count [letter dna]
  {:post [(not (nil? %))]}
  (get (nucleotide-counts dna) letter))
