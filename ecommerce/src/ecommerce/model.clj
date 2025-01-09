(ns ecommerce.model)

(defn product
  [name slug price]
  {:product/name name
   :product/slug slug
   :product/price price})
