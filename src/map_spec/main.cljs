
(ns map-spec.main
  (:require [map-spec.core :refer [map-spec]]
            [cljs.spec.alpha :as s]
            [expound.alpha :refer [expound]]))

(s/def ::example (map-spec :req {:foo string?, "bar" number?} :closed? true))

(defn task! []
  (println (s/valid? ::example {}))
  (println (s/valid? ::example {:foo "foo", "bar" 1}))
  (println (s/explain ::example {}))
  (println (s/explain ::example {:foo "foo", "bar" 1, :extra 1}))
  (println (expound ::example {:foo "foo"})))

(defn main! [] (println "Started.") (task!))

(defn reload! [] (.clear js/console) (println "Reloaded.") (task!))
