(ns tm1.todomvc
       (:require [clojure.browser.repl :as repl]
                 [domina :as dom])
       (:use [domina.css :only [sel]]
             [domina.xpath :only [xpath]]
             [domina.events :only [listen!]]))

(repl/connect "http://localhost:9000/repl")

(defn toggle-display [node]
  #(if (not= "block" (dom/style node :display))
    (dom/set-style! node :display "block")
    (dom/set-style! node :display "none")))

(listen! (sel "#instructions") :click (fn [] (js/alert "hi")))
(listen! (sel "#credits") :click (toggle-display (sel "#main")))
