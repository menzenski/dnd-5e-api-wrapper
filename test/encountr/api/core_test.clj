(ns encountr.api.core-test
  (:require [clojure.test :refer :all]
            [vcr-clj.core :refer [with-cassette]]
            [encountr.api.core :as api]))

(deftest get-resource-list-test
  (testing "get-resource-list-ability-scores"
    (with-cassette :dnd-5e-api/resource-list-ability-scores [{:var #'clj-http.client/get}]
                     (let [response (api/get-resource-list :ability-scores)]
                       (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-classes"
    (with-cassette :dnd-5e-api/resource-list-classes [{:var #'clj-http.client/get}]
                     (let [response (api/get-resource-list :classes)]
                       (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-conditions"
    (with-cassette :dnd-5e-api/resource-list-conditions [{:var #'clj-http.client/get}]
                   (let [response (api/get-resource-list :conditions)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-damage-types"
    (with-cassette :dnd-5e-api/resource-list-damage-types [{:var #'clj-http.client/get}]
                   (let [response (api/get-resource-list :damage-types)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-equipment-categories"
    (with-cassette :dnd-5e-api/resource-list-equipment-categories [{:var #'clj-http.client/get}]
                   (let [response (api/get-resource-list :equipment-categories)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-equipment"
    (with-cassette :dnd-5e-api/resource-list-equipment [{:var #'clj-http.client/get}]
                   (let [response (api/get-resource-list :equipment)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-features"
    (with-cassette :dnd-5e-api/resource-list-features [{:var #'clj-http.client/get}]
                   (let [response (api/get-resource-list :features)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-languages"
    (with-cassette :dnd-5e-api/resource-list-languages [{:var #'clj-http.client/get}]
                   (let [response (api/get-resource-list :languages)]
                     (is (= (:count response) (-> response :results count))))))
  #_(testing "get-resource-lists-levels"
    (with-cassette :dnd-5e-api/resource-list-levels [{:var #'clj-http.client/get}]
                     (let [response (api/get-resource-list :levels)]
                       (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-magic-schools"
    (with-cassette :dnd-5e-api/resource-list-magic-schools [{:var #'clj-http.client/get}]
                   (let [response (api/get-resource-list :magic-schools)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-monsters"
    (with-cassette :dnd-5e-api/resource-list-monsters [{:var #'clj-http.client/get}]
                   (let [response (api/get-resource-list :monsters)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-proficiencies"
    (with-cassette :dnd-5e-api/resource-list-proficiencies [{:var #'clj-http.client/get}]
                   (let [response (api/get-resource-list :proficiencies)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-races"
    (with-cassette :dnd-5e-api/resource-list-races [{:var #'clj-http.client/get}]
                   (let [response (api/get-resource-list :races)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-skills"
    (with-cassette :dnd-5e-api/resource-list-skills [{:var #'clj-http.client/get}]
                   (let [response (api/get-resource-list :skills)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-spellcasting"
    (with-cassette :dnd-5e-api/resource-list-spellcasting [{:var #'clj-http.client/get}]
                   (let [response (api/get-resource-list :spellcasting)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-spells"
    (with-cassette :dnd-5e-api/resource-list-spells [{:var #'clj-http.client/get}]
                   (let [response (api/get-resource-list :spells)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-startingequipment"
    (with-cassette :dnd-5e-api/resource-list-startingequipment [{:var #'clj-http.client/get}]
                   (let [response (api/get-resource-list :startingequipment)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-subclasses"
    (with-cassette :dnd-5e-api/resource-list-subclasses [{:var #'clj-http.client/get}]
                   (let [response (api/get-resource-list :subclasses)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-subraces"
    (with-cassette :dnd-5e-api/resource-list-subraces [{:var #'clj-http.client/get}]
                   (let [response (api/get-resource-list :subraces)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-traits"
    (with-cassette :dnd-5e-api/resource-list-traits [{:var #'clj-http.client/get}]
                   (let [response (api/get-resource-list :traits)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-weapon-properties"
    (with-cassette :dnd-5e-api/resource-list-weapon-properties [{:var #'clj-http.client/get}]
                   (let [response (api/get-resource-list :weapon-properties)]
                     (is (= (:count response) (-> response :results count)))))))