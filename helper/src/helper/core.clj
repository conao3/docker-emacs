;;; core.clj

;; Copyright (C) 2019 Naoya Yamashita

;; This program is free software: you can redistribute it and/or modify
;; it under the terms of the Affero GNU General Public License as
;; published by the Free Software Foundation, either version 3 of the
;; License, or (at your option) any later version.

;; This program is distributed in the hope that it will be useful, but
;; WITHOUT ANY WARRANTY; without even the implied warranty of
;; MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the Affero
;; GNU General Public License for more details.

;; You should have received a copy of the Affero GNU General Public
;; License along with this program.
;; If not, see <https://www.gnu.org/licenses/>.

(ns helper.core
  (:require [clojure.edn :as edn]
            [clojure.string :as string]
            [clojure.tools.cli :refer [parse-opts]])
  (:use [clostache.parser])
  (:gen-class))

(def cli-options
  ;; An option with a required argument
  [
   ;; ["-v" nil "Verbosity level"
   ;;  :id :verbosity
   ;;  :default 0
   ;;  :update-fn inc] ; Prior to 0.4.1, you would have to use:
   ;; ;; :assoc-fn (fn [m k _] (update-in m [k] inc))
   ;; A boolean option defaulting to nil
   ["-e" "--version TARGET-VERSION" "Target emacs version (`all` or version)"
    :default "all"]
   ["-s" "--os TARGET-OS" "Target docker image OS (`alpine` or `ubuntu`)"
    :default "alpine"]
   ["-h" "--help" "Show this help"]])

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
           (#{"gen" "build"} (first arguments)))
      {:action (first arguments) :options options}

      :else ; failed custom validation => exit with usage summary
      {:exit-message (usage summary)})))

(defn exit [status msg]
  (println msg)
  (System/exit status))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn- gen-dockerfiles
  "generate dockerfiles"
  [^String version]
  ;; (render "Hello, {{name}}!" {:name version})
  (render-resource "Dockerfile-alpine.mustache" {:min true :version "26.1"}))

(defn action-gen [option]
  (println option)
  ;; (println (gen-dockerfiles option))
  (let [{:keys [version os]} option
        data (edn/read-string (slurp "resources/data.edn"))]
    (cond
      (= version "all")
      (println data)

      :default
      (println version))))

(defn action-build [option]
  (println option))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [{:keys [action options exit-message ok?]} (validate-args args)]
    (if exit-message
      (exit (if ok? 0 1) exit-message)
      (case action
        "gen"     (action-gen options)
        "build"   (action-build options)))))
