Adjoining classes, sometimes also called class chaining, look like `.foo.bar`.
While technically allowed in CSS, these aren't handled properly by Internet Explorer 6 and earlier.
IE will match the selector as if it were simply `.bar` which means your selector will match more frequently
than you intend it to and create cross-browser bugs.

Ex:

     .foo.bar {
       color: red;
     }

Should be:

     .baz {
       color: red;
     }

[Source](https://github.com/CSSLint/csslint/wiki/Disallow-adjoining-classes)
      