The @import command is used to include CSS files within other CSS files, for example:

     @import url(more.css);
     @import url(andmore.css);

     a {
       color: black;
     }

This code includes two more style sheets at the beginning of a style sheet. When the browser parses this code,
it stops at each @import and starts to download the specified file. The browser doesn't continue downloading
other style sheets until this one has finished, eliminating any possible parallel downloads of CSS.

There are two alternatives to using @import:

Use a build system to concatenate CSS files together before deploying.
Use multiple <link> tags to include the style sheets you want. These will still be downloaded in parallel.

[Source](https://github.com/CSSLint/csslint/wiki/Disallow-%40import)
      