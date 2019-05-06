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
  (:use [clostache.parser]
        [clojure.string :only (join split)]
        [clojure.java.shell :only (sh)])
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
   ["-s" "--os TARGET-OS" "Target docker image OS (`all` or `alpine` or `ubuntu`)"
    :default "all"]
   ["-e" "--version TARGET-VERSION" "Target emacs version (`all` or version)"
    :default "all"]
   ["-t" "--type TARGET-TYPE" "Target type (`all` or `min`)"
    :default "all"]
   ["-h" "--help" "Show this help"]])

(defn usage [options-summary]
  (->> ["docker-emacs helper CLI tool."
        ""
        "Usage: lein run <actions> [options]"
        ""
        "Actions:"
        "  gen      Generate Dockerfiles, Project readme"
        "  build    Build docker images"
        "  push     Push image toDocker Hub"
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
           (#{"gen" "build" "push"} (first arguments)))
      {:action (first arguments) :options options}

      :else ; failed custom validation => exit with usage summary
      {:exit-message (usage summary)})))

(defn exit [status msg]
  (println msg)
  (System/exit status))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn- gen-dockerfiles
  "generate dockerfiles"
  [{:keys [os tags version branch type], :as option}]
  ;; (render "Hello, {{name}}!" {:name version})
  (let [readfile  (format "Dockerfile-%s.mustache" os)
        writefile (format "../Dockerfiles/Dockerfile-%s-%s-%s" os type version)]
    (spit writefile
          (render-resource readfile option))
    (println (format "Wrote %s" writefile))))

(defn action-gen [{:keys [version os type], :as option}]
  (let [data          (edn/read-string (slurp "resources/data.edn"))
        param-os      (if (not (= os "all"))
                        [os]
                        ["alpine" "ubuntu"])
        param-version (if (not (= version "all"))
                        [version]
                        ["26.1" "26.2"
                         "25.1" "25.2" "25.3"
                         "24.1" "24.2" "24.3" "24.4" "24.5"
                         "23.3" "23.4"])
        param-type    (if (not (= type "all"))
                        [type]
                        ["std" "min"])]

    ;; generate Dockerfiles
    (doseq [os      param-os
            type    param-type
            version param-version]
      (when-let [it (some #(when (= (:id %) (join "-" [os type version])) %) data)]
        (gen-dockerfiles it)))

    ;; generate readme
    (spit "../README.org"
          (render-resource "README.org.mustache" {:data data}))
    (println (format "Wrote README.org" os version type))

    ;; generate .travis.yml
    (spit "../.travis.yml"
          (render-resource ".travis.yml.mustache" {:data data}))
    (println (format "Wrote .travis.yml" os version type))

    ;; generate Makefile
    (spit "../Makefile"
          (render-resource "Makefile.mustache" {:data data}))
    (println (format "Wrote Makefile" os version type))))

(defn action-build [{:keys [version os type], :as option}]
  (let [data          (edn/read-string (slurp "resources/data.edn"))
        param-os      (if (not (= os "all"))
                        #{os}
                        #{"alpine" "ubuntu"})
        param-version (if (not (= version "all"))
                        #{version}
                        #{"26.1" "26.2"
                          "25.1" "25.2" "25.3"
                          "24.1" "24.2" "24.3" "24.4" "24.5"
                          "23.3" "23.4"})
        param-type    (if (not (= type "all"))
                        #{type}
                        #{"min"})]

    (println (format "Start build %s" "conao3/emacs:alpine-23.4-min"))
    (println
     (:out (sh "docker" "image" "build"
               "-t" "conao3/emacs:alpine-23.4-min"
               "-f" "Dockerfiles/Dockerfile-alpine-23.4-min"
               ".")))
    (println (format "Complete build %s" "conao3/emacs:alpine-23.4-min"))))

(defn action-push [{:keys [version os type], :as option}]
  (let [data          (edn/read-string (slurp "resources/data.edn"))
        param-os      (if (not (= os "all"))
                        #{os}
                        #{"alpine" "ubuntu"})
        param-version (if (not (= version "all"))
                        #{version}
                        #{"26.1" "26.2"
                          "25.1" "25.2" "25.3"
                          "24.1" "24.2" "24.3" "24.4" "24.5"
                          "23.3" "23.4"})
        param-type    (if (not (= type "all"))
                        #{type}
                        #{"min"})]

    (println (format "Start push %s" "conao3/emacs:alpine-23.4-min"))
    (println
     (:out (sh "docker" "push" "conao3/emacs:alpine-26.1-min")))
    (println (format "Complete build %s" "conao3/emacs:alpine-23.4-min"))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [{:keys [action options exit-message ok?]} (validate-args args)]
    (if exit-message
      (exit (if ok? 0 1) exit-message)
      (case action
        "gen"     (action-gen options)
        "build"   (action-build options)
        "push"    (action-push options)))))
