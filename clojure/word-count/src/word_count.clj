(ns word-count)

;;Count the words.
;; (defn word-count
;;   [yes]
;;   (frequencies (map clojure.string/lower-case  (re-seq #"\w+" yes))))

(defn word-count
  [x]
  (->> x
       (re-seq #"\w+")
       (map clojure.string/lower-case)
       (frequencies)))
