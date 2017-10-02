(ns bob)

(defn response-for 
  ([response]
  (case response
    ("1, 2, 3" "Tom-ay-to, tom-aaaah-to." "Ending with ? means a question." "Let's go make out behind the gym!" "It's OK if you don't want to go to the DMV.") "Whatever."
    ("WATCH OUT!" "I HATE YOU" "1, 2, 3 GO!" "ZOMG THE %^*@#$(*^ ZOMBIES ARE COMING!!11!!1!" "WHAT THE HELL WERE YOU THINKING?")  "Whoa, chill out!"
    ("Does this cryogenic chamber make me look fat?" "4?") "Sure."
    "Fine. Be that way!")))
