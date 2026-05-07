(ns main
  (:require
   ["@chakra-ui/react" :refer [Progress ChakraProvider CodeBlock createShikiAdapter
                               createSystem defaultConfig defineConfig]]
   [reagent.core :as r]
   [reagent.dom.client :as rdomc]))

(def ^:private chakra-theme
  (-> {:globalCss
       {:html
        {:colorPalette "red"}}}
      clj->js
      defineConfig))

(def ^:private chakra-system
  (createSystem
   defaultConfig
   chakra-theme
   #js {}))

(defn simple-component
  []
  [:> ChakraProvider
   {:value chakra-system}
   [:> Progress.Root
    {:value 45
     :size "sm"
     :borderRadius "full"}
    [:> Progress.Track
     {:borderRadius "full"}
     [:> Progress.Range
      {:borderRadius "full"}]]]])

(defonce root (delay (rdomc/create-root (.getElementById js/document "root"))))

(defn start!
  []
  (js/console.log "This value is not nil" Progress.Root)
  (rdomc/render @root [simple-component])
  #_(js/console.log "Uncomment to have the import" CodeBlock))
