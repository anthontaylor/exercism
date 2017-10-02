(ns meetup)

(defn- day-value
  [d m y c]
  (-> (+ d (quot (- (* 13 m) 1) 5))
      (+ y)
      (+ (quot y 4))
      (+ (quot c 4))
      (- (* 2 c))))

(defn- zellers
  [d m y]
  (let [x (str y)
        c (Integer. (apply str (take 2 x)))
        year (Integer. (apply str (drop 2 x)))
        month (inc (mod (- m 3) 12))
        yr (if (> month 10) (dec year) year)
        weekday (mod (day-value d month yr c) 7)]
    (case weekday
      0 :sunday
      1 :monday
      2 :tuesday
      3 :wednesday
      4 :thursday
      5 :friday
      6 :saturday)))

(defn- more-days?
  [d month]
  (let [month-map {:1 31 :2 28 :3 31 :4 30 :5 31 :6 30 :7 31 :8 31 :9 30 :10 31 :11 30 :12 31}
        length ((keyword (str month)) month-map)
        days-left (- length d)]
    (if (> days-left 6)
      true
      false)))

(defn- find-week
  [counter w d m]
  (if (and (not= w :teenth)
           (not= w :last))
    (case counter
     1 :first
     2 :second
     3 :third
     4 :fourth)
    (case [(= w :teenth)
           (and (< d 20)
                (> d 12))
           (more-days? d m)]
      [true true false] :teenth
      [true true true] :teenth
      [false false false] :last
      nil)))

(defn- find-day
  [m y wd w]
  (loop [d 1
         counter 1]
    (let [day (zellers d m y)]
      (if (or (= day wd) (> d 31))
        (if (= (find-week counter w d m) w)
          d
          (recur (inc d) (inc counter)))
        (recur (inc d) counter)))))

(defn meetup
  [m y wd w]
  (let [day (find-day m y wd w)]
    [y m day]))
