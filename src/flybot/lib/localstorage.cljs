(ns flybot.lib.localstorage
  
  (:require [flybot.db :refer [app-db]]
            [flybot.lib.class-utils :as cu]))

(defn set-item
  "Set `key' in browser's localStorage to `val`."
  [key val]
  (.setItem (.-localStorage js/window) key val))

(defn get-item
  "Returns value of `key' from browser's localStorage."
  [key]
  (.getItem (.-localStorage js/window) key))

(defn init-theme! []
  (if-let [l-storage-theme (keyword (get-item "theme"))]
    (swap! app-db assoc :theme l-storage-theme)
    (set-item :theme (:theme @app-db)))
  (cu/add-class!
   (. js/document -documentElement)
   (:theme @app-db)))