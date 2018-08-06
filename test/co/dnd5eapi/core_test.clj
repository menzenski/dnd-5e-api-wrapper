(ns co.dnd5eapi.core-test
  (:require [clojure.test :refer :all]
            [vcr-clj.core :refer [with-cassette]]
            [co.dnd5eapi.core :as api]))

(def default-cassette-options [{:var #'clj-http.client/get
                                :return-transformer (fn [r] (when r (dissoc r :http-client)))}])

(deftest get-resource-list-test
  (testing "get-resource-list-ability-scores"
    (with-cassette :dnd-5e-api/resource-list-ability-scores default-cassette-options
                   (let [response (api/get :ability-scores)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-classes"
    (with-cassette :dnd-5e-api/resource-list-classes default-cassette-options
                   (let [response (api/get :classes)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-conditions"
    (with-cassette :dnd-5e-api/resource-list-conditions default-cassette-options
                   (let [response (api/get :conditions)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-damage-types"
    (with-cassette :dnd-5e-api/resource-list-damage-types default-cassette-options
                   (let [response (api/get :damage-types)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-equipment-categories"
    (with-cassette :dnd-5e-api/resource-list-equipment-categories default-cassette-options
                   (let [response (api/get :equipment-categories)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-equipment"
    (with-cassette :dnd-5e-api/resource-list-equipment default-cassette-options
                   (let [response (api/get :equipment)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-features"
    (with-cassette :dnd-5e-api/resource-list-features default-cassette-options
                   (let [response (api/get :features)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-languages"
    (with-cassette :dnd-5e-api/resource-list-languages default-cassette-options
                   (let [response (api/get :languages)]
                     (is (= (:count response) (-> response :results count))))))
  #_(testing "get-resource-lists-levels"
      (with-cassette :dnd-5e-api/resource-list-levels default-cassette-options
                     (let [response (api/get :levels)]
                       (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-magic-schools"
    (with-cassette :dnd-5e-api/resource-list-magic-schools default-cassette-options
                   (let [response (api/get :magic-schools)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-monsters"
    (with-cassette :dnd-5e-api/resource-list-monsters default-cassette-options
                   (let [response (api/get :monsters)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-proficiencies"
    (with-cassette :dnd-5e-api/resource-list-proficiencies default-cassette-options
                   (let [response (api/get :proficiencies)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-races"
    (with-cassette :dnd-5e-api/resource-list-races default-cassette-options
                   (let [response (api/get :races)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-skills"
    (with-cassette :dnd-5e-api/resource-list-skills default-cassette-options
                   (let [response (api/get :skills)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-spellcasting"
    (with-cassette :dnd-5e-api/resource-list-spellcasting default-cassette-options
                   (let [response (api/get :spellcasting)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-spells"
    (with-cassette :dnd-5e-api/resource-list-spells default-cassette-options
                   (let [response (api/get :spells)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-startingequipment"
    (with-cassette :dnd-5e-api/resource-list-startingequipment default-cassette-options
                   (let [response (api/get :startingequipment)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-subclasses"
    (with-cassette :dnd-5e-api/resource-list-subclasses default-cassette-options
                   (let [response (api/get :subclasses)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-subraces"
    (with-cassette :dnd-5e-api/resource-list-subraces default-cassette-options
                   (let [response (api/get :subraces)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-traits"
    (with-cassette :dnd-5e-api/resource-list-traits default-cassette-options
                   (let [response (api/get :traits)]
                     (is (= (:count response) (-> response :results count))))))
  (testing "get-resource-list-weapon-properties"
    (with-cassette :dnd-5e-api/resource-list-weapon-properties default-cassette-options
                   (let [response (api/get :weapon-properties)]
                     (is (= (:count response) (-> response :results count)))))))

(deftest query-test
  (testing "find monsters with name = \"Bugbear\""
    (with-cassette :dnd-5e-api/query-test-name-bugbear default-cassette-options
                   (let [search-results (api/get :monsters :params {:name "Bugbear"})]
                     (is (= 1 (:count search-results) (-> search-results :results count)))))))

(deftest path-test
  (testing "get bugbear by id"
    (with-cassette :dnd-5e-api/path-test-bugbear default-cassette-options
                   (let [bugbear (api/get :monsters :id 57)]
                     (is (map? bugbear))
                     (is (= 13 (:constitution bugbear)))))))
