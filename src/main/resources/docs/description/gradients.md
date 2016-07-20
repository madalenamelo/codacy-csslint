CSS gradients in a cross-browser way requires using many different vendor-prefixed versions.
There are currently five different vendor-prefixed versions of CSS gradient:

+ -ms-linear-gradient and -ms-radial-gradient for Internet Explorer 10+
+ -moz-linear-gradient and -moz-radial-gradient for Firefox 3.6+
+ -o-linear-gradient and -o-radial-gradient for Opera 11.10+
+ -webkit-linear-gradient and -webkit-radial-gradient for Safari 5+ and Chrome
+ -webkit-gradient for Safari 4+ and Chrome (aka "Old WebKit")

Meaning a simple two-color gradient that works across all browsers must look like this:

     background: -moz-linear-gradient(...); /* FF3.6+ */
     background: -webkit-gradient(...); /* Chrome,Safari4+ */
     background: -webkit-linear-gradient(...); /* Chrome10+,Safari5.1+ */
     background: -o-linear-gradient(...); /* Opera 11.10+ */
     background: -ms-linear-gradient(...); /* IE10+ */

It's easy to forget one or more gradient definitions with all of the various vendor prefix gradients available.

[Source](https://github.com/CSSLint/csslint/wiki/Require-all-gradient-definitions)
      