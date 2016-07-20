The !important annotation is used to artificially increase the specificity of a given property value in a rule.
This is usually an indication that the specificity of the entire CSS has gotten a bit out of control and needs to be refactored.
The more frequently !important is found in CSS, the more likely it is that developers are having trouble styling parts of a page effectively.


This rule is aimed at keeping your specificity levels in check. As such, it warns whenever !important is used.

The following patterns are considered warnings:

     .mybox {
       color: red !important;
     }

[Source](https://github.com/CSSLint/csslint/wiki/Disallow-%21important)
      