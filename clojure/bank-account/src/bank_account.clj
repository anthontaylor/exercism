(ns bank-account)

(defn open-account
  []
  (atom 0))

(defn get-balance
  [account]
  @account)

(defn close-account
  [account]
  (reset! account nil))

(defn update-balance [account n]
  (swap! account + n))
