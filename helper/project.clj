(defproject helper "0.1.0-SNAPSHOT"
  :description "docker-emacs helper"
  :url "http://github.com/conao3/docer-emacs"
  :license {:name "AGPLv3"
            :url "https://www.gnu.org/licenses/agpl-3.0.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [de.ubercode.clostache/clostache "1.4.0"]]
  :main ^:skip-aot helper.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
