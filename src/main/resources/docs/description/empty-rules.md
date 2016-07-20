An empty rule is one that doesn't contain any properties, such as:

     .foo {
     }

A lot of times, empty rules appear as a result of refactoring without further cleanup.
Eliminating empty rules results in smaller file sizes and less style information for the browser to deal with.

[Source](https://github.com/CSSLint/csslint/wiki/Disallow-empty-rules)
      