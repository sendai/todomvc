(defproject todomvc "0.1.0-SNAPSHOT"
            :description "FIXME: write this!"
            :dependencies [[org.clojure/clojure "1.3.0"]
                           [goog-jar "1.0.0"]
                           [noir "1.2.1"]]
            :plugins [[lein-cljsbuild "0.1.2"]
                      [lein-git-deps "0.0.1-SNAPSHOT"]]
            :git-dependencies [["https://github.com/levand/domina.git"
                               "1fcbfa2375f360cb1167f9de7d928eb5b8d64514"]]
            :cljsbuild
            {:builds
            [{:source-path "src-cljs",
                           :compiler
                           {:output-to "resources/public/js/cljs.js",
                           :externs ["externs/jquery.js"],
                           :optimizations :simple,
                           :pretty-print true}}]}
            :extra-classpath-dirs [".lein-git-deps/domina/src/cljs"]
            :main todomvc.server)

