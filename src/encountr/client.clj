(ns encountr.client
  (:require [clj-http.client :as client]
            [cemerick.url :as url]
            [cheshire.core :as cheshire]))

(def ^:private base-url "http://www.dnd5eapi.co/api/")

(defn- build-url
  [path]
  (apply (partial url/url base-url) path))

(defn api-call
  [& {:keys [path params method] :or {method :GET}}]
  (condp = method
    :GET (-> path
             build-url
             str
             (client/get (when params {:query-params params}))
             :body
             (cheshire/parse-string true))))
