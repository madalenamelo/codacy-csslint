The star hack is a famous (or perhaps infamous) technique for applying CSS properties only to Internet Explorer prior to version 8.
By placing an asterisk immediately before the property name, older versions of Internet Explorer treated as if the asterisk
isn't there while other browsers simply ignore it. For example:

     .mybox {
       border: 1px solid black;
       padding: 5px;
       width: 100px;
       *width: 200px;
     }

In this example, the *width property is treated as if it were width by Internet Explorer 7 and earlier, so it uses the value
of 200px; other browsers skip that property and use the value of 100px.

Star hack relies on an old CSS parser bug in Internet Explorer, and as such, some prefer not to use it.

[Source](https://github.com/CSSLint/csslint/wiki/Disallow-star-hack)
      