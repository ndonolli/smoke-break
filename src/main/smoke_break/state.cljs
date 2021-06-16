(ns smoke-break.state
  (:require [reagent.core :as r]
            [smoke-break.storage :as store]))

(defonce ACTIVE_TIMER_DB "smoke-break.active")
(defonce HISTORY_DB "smoke-break.history")

(def collapsed (r/atom false))

(def active-timer (r/atom (store/get ACTIVE_TIMER_DB)))

(def history (r/atom (store/get HISTORY_DB)))

(def view-limit (r/atom 5))

(add-watch active-timer :active-timer-db
           (fn [key this old-state new-state]
             (tap> @this)
             (store/set! active-timer @this)))

(add-watch history :history-db
           (fn [key this old-state new-state]
             (tap> @this)
             (store/set! HISTORY_DB @this)))