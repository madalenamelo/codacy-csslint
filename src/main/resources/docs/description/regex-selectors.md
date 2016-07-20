CSS3 added a new kind of selector that allows you to use regular expressions.
Although it is a feature it should be avoided since it has bad performance implications in your application.
To replace it you just need create a new class in the target search of your previous regex.

Ex:

     a[class*=ex-name] {
       color: red;
     }

Should be:

     a.new-ex-name {
       color: red;
     }

[Source](https://github.com/CSSLint/csslint/wiki/Disallow-selectors-that-look-like-regular-expressions)
      