(ns helper.core
  (:require [clojure.string :as string]
            [clojure.tools.cli :refer [parse-opts]])
  (:use [clostache.parser])
  (:gen-class))

(def cli-options
  ;; An option with a required argument
  [;; ["-p" "--port PORT" "Port number"
   ;;  :default 80
   ;;  :parse-fn #(Integer/parseInt %)
   ;;  :validate [#(< 0 % 0x10000) "Must be a number between 0 and 65536"]]
   ;; ;; A non-idempotent option (:default is applied first)
   ;; ["-v" nil "Verbosity level"
   ;;  :id :verbosity
   ;;  :default 0
   ;;  :update-fn inc] ; Prior to 0.4.1, you would have to use:
   ;; ;; :assoc-fn (fn [m k _] (update-in m [k] inc))
   ;; A boolean option defaulting to nil
   ["-t" "--target TARGET-TAG" "Target docker image tag"]
   ["-h" "--help" "Show this help"]])

(defn- generate-dockerfiles
  "generate dockerfiles"
  [^String version]
  ;; (render "Hello, {{name}}!" {:name version})
  (render-resource "Dockerfile-alpine.mustache" {:min true :version "26.1"}))

(defn usage [options-summary]
  (->> ["docker-emacs helper CLI tool."
        ""
        "Usage: lein run <actions> [options]"
        ""
        "Actions:"
        "  gen      Generate Dockerfiles, Project readme"
        "  build    Build docker images"
        ""
        "Options:"
        options-summary
        ""
        "Please refer to the readme for more information."]
       (string/join \newline)))

(defn error-msg [errors]
  (str "The following errors occurred while parsing your command:\n\n"
       (string/join \newline errors)))

(defn validate-args
  "Validate command line arguments. Either return a map indicating the program
  should exit (with a error message, and optional ok status), or a map
  indicating the action the program should take and the options provided."
  [args]
  (let [{:keys [options arguments errors summary]} (parse-opts args cli-options)]
    (cond
      (:help options) ; help => exit OK with usage summary
      {:exit-message (usage summary) :ok? true}

      errors ; errors => exit with description of errors
      {:exit-message (error-msg errors)}

      ;; custom validation on arguments
      (and (= 1 (count arguments))
           (#{"start" "stop" "status"} (first arguments)))
      {:action (first arguments) :options options}

      :else ; failed custom validation => exit with usage summary
      {:exit-message (usage summary)})))

(defn exit [status msg]
  (println msg)
  (System/exit status))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [{:keys [action options exit-message ok?]} (validate-args args)]
    (if exit-message
      (exit (if ok? 0 1) exit-message)
      (do
        (println "Hello, World!")
        (println (render "Hello, {{name}}!" {:name "Felix"}))
        (println (generate-dockerfiles "26.1"))))))

