(ns building-blocks.core
  (:require [phzr.core :as p]
            [phzr.game :as pg]))

(enable-console-print!)

(pg/->Game 800 600 (p/phaser-constants :auto) "app")
