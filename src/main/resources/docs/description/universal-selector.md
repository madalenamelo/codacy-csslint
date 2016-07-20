The universal selector (*) matches all elements.
Although it may seem convenient for selecting a bunch of elements, this selector has bad performance implications in your application.
This happens because browsers evaluate selectors from right to left so in the example below it will start by selecting all the elements
in the documents and only then it will filter for the next criteria.

Ex:

     .ex-class * {
       color: #fff;
     }

[Source](https://github.com/CSSLint/csslint/wiki/Disallow-universal-selector)
      