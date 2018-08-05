(ns encountr.client
  (:require [clj-http.client :as client]
            [cheshire.core :as cheshire]))

(def base-url "http://www.dnd5eapi.co/api/")

(defn api-call
  ([path & {:keys [params method] :or {method :GET}}]
   (condp = method
     :GET (-> base-url
              (str path)
              (client/get (when params {:query-params params}))
              :body
              (cheshire/parse-string true)))))
