(defproject dnd5eapi "0.1.0"
  :description "A wrapper for the D&D 5E API ( http://www.dnd5eapi.co/ )"
  :url "https://github.com/menzenski/dnd-5e-api-wrapper"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-http "3.9.1"]
                 [com.cemerick/url "0.1.1"]
                 [cheshire "5.8.0"]
                 [com.gfredericks/vcr-clj "0.4.16"]])
