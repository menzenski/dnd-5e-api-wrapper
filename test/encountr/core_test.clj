(ns encountr.core-test
  (:require [clojure.test :refer :all]
            [vcr-clj.core :refer [with-cassette]]
            [encountr.core :as encountr]))

(def default-cassette-options [{:var #'clj-http.client/get
                                :return-transformer (fn [r] (when r (dissoc r :http-client)))}])

(deftest get-resource-list-test
  (testing "get-resource-list-ability-scores"
    (with-cassette :dnd-5e-api/resource-list-ability-scores default-cassette-options
                   (let [response (encountr/get :ability-scores)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-classes"
    (with-cassette :dnd-5e-api/resource-list-classes default-cassette-options
                   (let [response (encountr/get :classes)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-conditions"
    (with-cassette :dnd-5e-api/resource-list-conditions default-cassette-options
                   (let [response (encountr/get :conditions)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-damage-types"
    (with-cassette :dnd-5e-api/resource-list-damage-types default-cassette-options
                   (let [response (encountr/get :damage-types)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-equipment-categories"
    (with-cassette :dnd-5e-api/resource-list-equipment-categories default-cassette-options
                   (let [response (encountr/get :equipment-categories)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-equipment"
    (with-cassette :dnd-5e-api/resource-list-equipment default-cassette-options
                   (let [response (encountr/get :equipment)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-features"
    (with-cassette :dnd-5e-api/resource-list-features default-cassette-options
                   (let [response (encountr/get :features)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-languages"
    (with-cassette :dnd-5e-api/resource-list-languages default-cassette-options
                   (let [response (encountr/get :languages)]
                     (is (= (:count response) (-> response :results count))))))
  #_(testing "get-resource-lists-levels"
      (with-cassette :dnd-5e-api/resource-list-levels default-cassette-options
                     (let [response (encountr/get :levels)]
                       (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-magic-schools"
    (with-cassette :dnd-5e-api/resource-list-magic-schools default-cassette-options
                   (let [response (encountr/get :magic-schools)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-monsters"
    (with-cassette :dnd-5e-api/resource-list-monsters default-cassette-options
                   (let [response (encountr/get :monsters)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-proficiencies"
    (with-cassette :dnd-5e-api/resource-list-proficiencies default-cassette-options
                   (let [response (encountr/get :proficiencies)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-races"
    (with-cassette :dnd-5e-api/resource-list-races default-cassette-options
                   (let [response (encountr/get :races)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-skills"
    (with-cassette :dnd-5e-api/resource-list-skills default-cassette-options
                   (let [response (encountr/get :skills)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-spellcasting"
    (with-cassette :dnd-5e-api/resource-list-spellcasting default-cassette-options
                   (let [response (encountr/get :spellcasting)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-spells"
    (with-cassette :dnd-5e-api/resource-list-spells default-cassette-options
                   (let [response (encountr/get :spells)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-startingequipment"
    (with-cassette :dnd-5e-api/resource-list-startingequipment default-cassette-options
                   (let [response (encountr/get :startingequipment)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-subclasses"
    (with-cassette :dnd-5e-api/resource-list-subclasses default-cassette-options
                   (let [response (encountr/get :subclasses)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-subraces"
    (with-cassette :dnd-5e-api/resource-list-subraces default-cassette-options
                   (let [response (encountr/get :subraces)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-traits"
    (with-cassette :dnd-5e-api/resource-list-traits default-cassette-options
                   (let [response (encountr/get :traits)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-weapon-properties"
    (with-cassette :dnd-5e-api/resource-list-weapon-properties default-cassette-options
                   (let [response (encountr/get :weapon-properties)]
                     (is (= (:count response) (-> response :results count)))))))