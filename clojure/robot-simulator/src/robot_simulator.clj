(ns robot-simulator)

(defn robot
  [coordinates bearing]
  {:coordinates coordinates :bearing bearing})

(defn turn-left
  [x]
  (case x
    :north :west
    :east :north
    :south :east
    :west :south))

(defn turn-right
  [x]
  (case x
    :north :east
    :east :south
    :south :west
    :west :north))

(defn advance
  [{x :x y :y} bearing]
  (case bearing
    :east {:x (inc x) :y y}
    :west {:x (dec x) :y y}
    :north {:x x :y (inc y)}
    :south {:x x :y (dec y)}))

(defn move
  [x coordinates bearing]
  (case x
    \L {:coordinates coordinates :bearing (turn-left bearing)}
    \R {:coordinates coordinates :bearing (turn-right bearing)}
    \A {:coordinates (advance coordinates bearing) :bearing bearing}))

(defn run-robot
  [{:keys [coordinates bearing]} {go :go}]
  (move go coordinates bearing))

(defn simulate
  [x robot]
  (->> x
       seq
       (map #(assoc robot :go %))
       (reduce run-robot robot)))
