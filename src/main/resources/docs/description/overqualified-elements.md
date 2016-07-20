Using selector like the one bellow is almost every time unnecessary, unless the element name causes the class to behave differently
you can omit it. With this you will shrink the file size and speedup your page load time.

Bad practice:

     li.foo {
       color: #ddd;
     }

Acceptable:

     li.foo {
       color: #ddd;
     }

     li.bar {
       color: #ccc;
     }

[Source](https://github.com/CSSLint/csslint/wiki/Disallow-overqualified-elements)
      