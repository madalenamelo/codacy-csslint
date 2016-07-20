The main solutions for performance is to use as few bytes as possible. In the example bellow we are loading the same image two
times what makes your page slow since those are images that can have big sizes.

Ex:

     .icon-a {
       background: url(icons.png) 10px 0 no-repeat;
     }

     .icon-b {
       background: url(icons.png) 20px 0 no-repeat;
     }

Should be:

     .icons {
       background: url(icons.png) no-repeat;
     }

     .icon-a {
       background-position: 10px 0;
     }

     .icon-b {
       background-position: 20px 0;
     }

[Source](https://github.com/CSSLint/csslint/wiki/Disallow-duplicate-background-images)
      