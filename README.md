
Map Spec
----

Copied code from https://twitter.com/thheller/status/1140950125638017024

### Usage

[![Clojars Project](https://img.shields.io/clojars/v/mvc-works/map-spec.svg)](https://clojars.org/mvc-works/map-spec)

```edn
[mvc-works/map-spec "0.1.0-a1"]
```

```clojure
(ns map-spec.main
  (:require [map-spec.core :refer [map-spec]]
            [cljs.spec.alpha :as s]))

(s/def ::example (map-spec :req {:foo string?, "bar" number?} :closed? true))

(defn task! []
  (println (s/valid? ::example {}))
  (println (s/valid? ::example {:foo "foo", "bar" 1}))
  (println (s/explain ::example {}))
  (println (s/explain ::example {:foo "foo", "bar" 1, :extra 1})))
```

Outputs:

```text
false
true
{} - failed: (contains? % :foo) spec: :map-spec.main/example
{} - failed: (contains? % "bar") spec: :map-spec.main/example

nil
{:foo "foo", "bar" 1, :extra 1} - failed: (not (contains? % :extra)) spec: :map-spec.main/example

nil
```

Notices: this function does not work with [expound](https://github.com/bhb/expound).

### License

MIT
