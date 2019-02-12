(ns helper.core
  (:gen-class)
  (:use [clostache.parser]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (println (render "Hello, {{name}}!" {:name "Felix"})))
