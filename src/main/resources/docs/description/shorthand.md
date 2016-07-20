When using a rule like the one bellow you should check if it has a shorthand property and if possible use it, it will shrink your file
and speedup your page load time and it will even make your CSS more readable and simple.

Ex:

     .foo {
       margin-top: 10px;
       margin-right: 20px;
       margin-bottom: 10px;
       margin-left: 20px;
     }

Should be:

     .foo {
       margin: 10px 20px;
     }

[Source](https://github.com/CSSLint/csslint/wiki/Require-shorthand-properties)
      