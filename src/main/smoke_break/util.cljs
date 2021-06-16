(ns smoke-break.util
  (:require [clojure.set :as s]))

(defn update-in-set [my-set key value new-record]
  (merge (s/select #(not= (get % key) value) my-set) new-record))
