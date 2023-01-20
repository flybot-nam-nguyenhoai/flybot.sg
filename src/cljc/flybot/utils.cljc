(ns cljc.flybot.utils
  (:require #?(:clj [datalevin.core :as d])))

(defn mk-uuid
  []
  #?(:clj (d/squuid) :cljs (random-uuid)))

(defn mk-date
  []
  #?(:clj (java.util.Date.) :cljs (js/Date.)))

(defn temporary-id?
  [id]
  (= "new-post-temp-id" id))

(defn to-indexed-maps
  "Transforms a vector of maps `v` to a map of maps using the given key `k` as index.
   i.e: [{:a :a1 :b :b1} {:a :a2 :b :b2}]
   => {:a1 {:a :a1 :b :b1} :a2 {:a :a2 :b :b2}}"
  [k v]
  (into {} (map (juxt k identity) v)))

