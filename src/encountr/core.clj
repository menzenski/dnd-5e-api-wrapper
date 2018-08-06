(ns encountr.core
  (:require [encountr.client :as client])
  (:refer-clojure :exclude [get]))

(defn get
  [resource & {:keys [id params]}]
   (client/api-call :path [(name resource) id] :params params))