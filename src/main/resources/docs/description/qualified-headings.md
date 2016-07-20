Heading elements (h1-h6) should be defined as top-level styles and not scoped to particular areas of the page.
The headings are considered to be built-in objects in Object-Oriented CSS, and their appearance should be consistent
across an entire site. This allows those styles to be reused across your site for better visual consistency and performance
and easier maintenance. For example, this is an example of an overqualified heading:

     .foo h1 {
       font-size: 110%;
     }

[Source](https://github.com/CSSLint/csslint/wiki/Disallow-qualified-headings)
      