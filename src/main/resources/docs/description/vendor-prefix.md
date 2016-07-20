Vendor-prefixed properties are created by browser vendors to experiment with new CSS features before the standard has been completed.
This allows both developers and browser vendors to find bugs and cross-browser compatibility issues without being locked in to a
certain behavior in the future. The standard version of the property usually (but not always) has the same name and syntax
as the vendor-prefixed version, providing that there are two or more vendor-prefixed versions with the same syntax.

When using vendor-prefixed properties such as -moz-border-radius, you should also include the standard property for future-compatibility.
The standard property should come after the vendor-prefixed one to ensure the standard property is used by the browser, such as:

     .mybox {
       -moz-border-radius: 5px;
       border-radius: 5px;
     }

Putting the standard property after the vendor-prefixed property is the best way to ensure your CSS code will continue
to work once the standard property is fully adopted (then you can take your time going back and removing the vendor-prefixed properties).

[Source](https://github.com/CSSLint/csslint/wiki/Require-standard-property-with-vendor-prefix)
      