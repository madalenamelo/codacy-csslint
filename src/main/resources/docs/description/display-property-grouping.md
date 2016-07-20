Even though you can define any group of properties together in a CSS rule, some of them will be ignored due to the display of the element.
This leads to extra cruft in your CSS and misunderstandings around how a rule should work.

For display: `inline`, the `width`, `height`, `margin-top`, `margin-bottom`, and `float` properties have no effect
because inline elements don't have a formal box with which to apply the styles.
The `margin-left` and `margin-right` properties still work reliably for indentation purposes but the other margin settings do not.
The `float` property is sometimes used as a fix for the IE6 double-margin bug.

Other general rules based on display are:

+ display: inline-block should not use float.
+ display: block should not use vertical-align.
+ display: table-* should not use margin (and all variants) or float.

Removed the ignored or problematic properties decreases file size thereby improving performance

[Source](https://github.com/CSSLint/csslint/wiki/Require-properties-appropriate-for-display)
      