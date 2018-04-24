(ns building-blocks.core
  (:require [phzr.core :as p]
            [phzr.game :as pg]
            [phzr.game-object-factory :as pgof]
            [phzr.loader :as pl]))

(enable-console-print!)

(defn ^:private preload
  [game]
  (let [loader (:load game)]
    (doto loader
      (pl/image "brick" "assets/brick.png")
      (pl/image "grass" "assets/grass.png")
      (pl/image "sky" "assets/sky.png"))))

(defn ^:private create
  [game]
  (let [gof (:add game)
        height (-> game :world :height)
        width (-> game :world :width)]
    (pgof/tile-sprite gof 0 0 width height "sky")
    (pgof/sprite gof 0 (- height 80) "brick")
    (pgof/tile-sprite gof 0 (- height 50) width 50 "grass")))

(pg/->Game 800 600 (p/phaser-constants :auto) "app"
  {"preload" preload
   "create" create})
