In CSS2, there were three ways to specify colors: in hexadecimal format, using either three or six characters,
named colors such as red, and rgb(). CSS3 has since added several new color formats including rgba(), hsl(), and hsla().
While these new color formats bring a remarkable amount of flexibility to how developers define colors
and the relationships between them, it can also leave older browsers looking worse than expected.

The problem is that CSS parsers in browsers will skip a property whose name or value is not understood.
Older browsers such as Internet Explorer 8 and earlier, do not understand rgba(), hsl(), or hsla(), and as a result will drop
any declarations containing them. Consider the following:

     .box {
       background: #000;
       color: rgba(100, 100, 200, 0.5);
     }

Supporting browsers will treat this CSS code as described. Non-supporting browsers will completely drop the color property
because the value isn't understood. That means the actual color used will be inherited from the surrounding context
and might actually end up black (the same as the background).
To prevent this, you should always include a fallback color in either hexadecimal, named, or rgb() format, such as:

     .box {
       background: #000;
       color: blue;
       color: rgba(100, 100, 200, 0.5);
     }

The fallback color should always go before the new color to ensure older browsers see and use it correctly,
and that newer browsers continue on to use the newer color format.

[Source](https://github.com/CSSLint/csslint/wiki/Require-fallback-colors)
      