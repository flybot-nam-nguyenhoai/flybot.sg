(ns flybot.pages.home
  (:require [flybot.components.section :refer [section]]))

(defn home-page [] 
  [:section.container.home
   (section "home")])