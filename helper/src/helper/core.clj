(ns helper.core
  (:gen-class)
  (:use [clostache.parser]))

(defn- generate-dockerfiles
  "generate dockerfiles"
  [^String version]
  ;; (render "Hello, {{name}}!" {:name version})
  (render-resource "Dockerfile-alpine.mustache" {:min? true}))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (println (render "Hello, {{name}}!" {:name "Felix"}))
  (println (generate-dockerfiles "26.1")))

