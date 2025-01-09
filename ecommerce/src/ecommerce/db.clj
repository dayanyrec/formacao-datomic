(ns ecommerce.db
  (:require [datomic.api :as d]))

(def db-uri "datomic:dev://localhost:4334/ecommerce")

(defn create-database
  []
  (d/create-database db-uri))

(defn connect-database
  []
  (d/connect db-uri))

(defn delete-database
  []
  (d/delete-database db-uri))

(def schema
  [{:db/ident :product/name
    :db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc "Product name"}
   {:db/ident :product/slug
    :db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc "Product slug"}
   {:db/ident :product/price
    :db/valueType :db.type/bigdec
    :db/cardinality :db.cardinality/one
    :db/doc "Product price"}])

(defn create-schema
  [conn]
  (d/transact conn schema))
