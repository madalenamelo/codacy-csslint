Even if CSS allows you to put units in the value 0 you should not.
The value is always the same, with or without units, and without those units your will shrink the file size
and speedup your page load time.

Ex:

     .foo {
       width: 0px;
     }

Should be:

     .foo {
       width: 0;
     }

[Source](https://github.com/CSSLint/csslint/wiki/Disallow-units-for-zero-values)
      