(ns encountr.api.core-test
  (:require [clojure.test :refer :all]
            [vcr-clj.core :refer [with-cassette]]
            [encountr.api.core :as api]))

(deftest get-resource-list-test
  (testing "get-resource-list"
    (with-cassette :dnd-5e-api/resource-list-spells [{:var #'clj-http.client/get}]
                   (let [response (api/get-resource-list :spells)]
                     ; (println (with-out-str (clojure.pprint/pprint response)))
                     (is (= (:count response) (-> response :results count)))))))