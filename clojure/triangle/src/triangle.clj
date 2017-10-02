(ns triangle
  (:refer-clojure :exclude [type]))


(defn check-sides
  [a b c]
  (case [(= a b) (= a c) (= b c)]
    [true true true] :equilateral
    [false false false] :scalene
    :isosceles))

(defn logical?
  [a b c]
  (and
   (< c (+ a b))
   (< b (+ a c))
   (< a (+ b c))))

(defn type
  [a b c]
  (if (logical? a b c)
    (check-sides a b c)
    :illogical))
