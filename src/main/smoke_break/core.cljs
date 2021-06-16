(ns smoke-break.core
  (:require [reagent.dom :as dom]
            [smoke-break.storage :as store]))


(defn ^:dev/after-load start []
  (dom/render
   [:h1 "hello"]
   (.getElementById js/document "app")))

(defn ^:export main []
  (start))