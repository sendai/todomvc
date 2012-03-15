(ns todomvc.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css include-js html5]]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "todomvc"]
               (include-css "/css/reset.css")]
              [:body
               [:div#wrapper
                content]
               (include-js "/js/cljs.js")]))
