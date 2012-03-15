(ns todomvc.views.todomvc
  (:require [todomvc.views.common :as common]
            [noir.content.getting-started])
  (:use [noir.core :only [defpage defpartial]]
        [hiccup.core :only [html]]
        hiccup.form-helpers))

(defpage "/todomvc" []
  (slurp "resources/public/todomvc.html"))
