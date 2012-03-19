(ns tm1.todomvc
       (:require [clojure.browser.repl :as repl]
                 [domina :as dom]
                 [goog.dom :as gdom])
       (:use [domina.css :only [sel]]
             [domina.xpath :only [xpath]]
             [domina.events :only [listen!]]
             [cljs.reader :only [read-string]]))

(repl/connect "http://localhost:9000/repl")

(defn toggle-display [node]
  #(if (not= "block" (dom/style node :display))
    (dom/set-style! node :display "block")
    (dom/set-style! node :display "none")))

;; some examples of what we can do with events
(listen! (sel "#instructions") :click (fn [] (js/alert "hi")))
(listen! (sel "#credits") :click (toggle-display (sel "#main")))
(listen! (sel "#todoapp h1") :click #(dom/append! (sel "body") "<p>hi, there!</p>"))
(listen! (sel "#new-todo") :focus #(dom/set-style! (sel "#todoapp footer") :display "block"))
(listen! (sel "#new-todo") :blur #(dom/set-style! (sel "#todoapp footer") :display "none"))

(dom/set-text! (dom/by-id "todo-count") "3 todo items")

(defn get-todos []
  (read-string (.getItem (.-localStorage js/window) "todo-clojurescript")))

(defn save-todos [todos]
  (let [todos-string (pr-str todos)]
    (.setItem (.-localStorage js/window) "todo-clojurescript" todos-string)))

(defn add-todo [text]
  (let [todos (get-todos)]
    (save-todos (conj todos text))))

(doseq [t (get-todos)]
  (dom/append! (sel "body") (str "<p>" t "</p>")))

;(save-todos ["task 1" "task 2"])

(listen! (sel "#new-todo-form") :submit #(add-todo (dom/value (sel "#new-todo"))))
