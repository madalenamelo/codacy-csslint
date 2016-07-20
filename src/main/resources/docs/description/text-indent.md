Negative text indents are typically used to hide text off-screen for accessibility purposes. Often used as part of
an image replacement technique, using a negative text indent ensures that screen readers will read the text even though
it appears offscreen. Using visibility: hidden or display: none causes the text to be skipped by screen readers,
so a negative text indent has been deemed as better for accessibility.

The technique usually involves a very large negative number such as -999px or -9999px, such as:

     .mybox {
       background: url(bg.png) no-repeat;
       text-indent: -9999px;
     }

The intent of this technique is to allow the background image to show through for sighted users while screen readers
receive the inline text instead.

Negative text indents are also problematic when used in a right-to-left language page, as the effect may cause
a long horizontal scrollbar to appear. This problem can be fixed by adding direction: ltr to the rule, such as:

     .mybox {
       background: url(bg.png) no-repeat;
       direction: ltr;
       text-indent: -9999px;
     }

[Source](https://github.com/CSSLint/csslint/wiki/Disallow-negative-text-indent)
      