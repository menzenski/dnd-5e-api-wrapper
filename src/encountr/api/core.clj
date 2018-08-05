(ns encountr.api.core
  (:require [encountr.client :as client]))

(defn get-resource-list
  [resource]
  (-> resource name client/api-call))
