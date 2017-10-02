(ns space-age)

(defn on-earth
  [seconds]
  (let [sec-per-year 31557600.0]
    (/ seconds sec-per-year)))

(defn planet-values
  [seconds orbit]
  (/ (on-earth seconds) orbit))

(defn on-mercury [sec] (planet-values sec 0.2408467))

(defn on-mars [sec] (planet-values sec 1.8808158))

(defn on-venus [sec] (planet-values sec  0.61519726))

(defn on-jupiter [sec] (planet-values sec 11.862615))

(defn on-saturn [sec] (planet-values sec 29.447498))

(defn on-uranus [sec] (planet-values sec 84.016846))

(defn on-neptune [sec] (planet-values sec 164.79132))
