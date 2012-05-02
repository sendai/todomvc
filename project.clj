(defproject todomvc "0.1.1-SNAPSHOT"
            :description "FIXME: write this!"
            :dependencies [[org.clojure/clojure "1.3.0"]
                           [goog-jar "1.0.0"]
                           [noir "1.2.1"]]
            :plugins [[lein-cljsbuild "0.1.8"]
                      [lein-git-deps "0.0.1-SNAPSHOT"]]
            :git-dependencies [["https://github.com/levand/domina.git"
                               "753c18e4a012164940904b375b3cf29c77771bef"]]
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

