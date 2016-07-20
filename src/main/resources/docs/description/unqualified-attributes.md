Unqualified attribute selectors, such as the one bellow, match all the page before check their attributes.
So, like the universal selector they evaluate selectors from right to left.

Ex:

     .ex-class [type=text] {
       font-size: 16px;
     }

[Source](https://github.com/CSSLint/csslint/wiki/Disallow-unqualified-attribute-selectors)
      