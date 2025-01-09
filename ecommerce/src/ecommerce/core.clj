(ns ecommerce.core
  (:require
   [clojure.pprint :as pprint]
   [datomic.api :as d]
   [ecommerce.db :as db]
   [ecommerce.model :as model]))

(pprint/pprint "Start Ecommerce")

(db/create-database)
(def conn (db/connect-database))
(db/create-schema conn)

(let [computer (model/product "Computador Novo" "/computador" 2999.9M)]
  (pprint/pprint (d/transact conn [computer])))

(let [celular (model/product "Celular Caro" "/celular" 88888.1M)]
  (pprint/pprint (d/transact conn [celular])))

(def db (d/db conn))

(d/q '[:find ?p
       :where [?p :product/name]] db)
