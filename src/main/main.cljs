(ns main
  (:require
    ["@chakra-ui/react" :refer [CodeBlock parseDate]]))

(defn start!
  []
  (js/console.log "parseDate" parseDate)
  (js/console.log "Ignoring the import" CodeBlock.Root)
  #_(js/console.log "Uncomment to have the import" CodeBlock))
