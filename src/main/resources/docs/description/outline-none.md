The CSS outline property is used to define a border around elements. Unlike the border property, the outline property
does not alter the size or layout of the element. Because of this, browsers frequently use outline as the specification
for an active state. In Internet Explorer and Firefox, the outline of a selected element is a single pixel dotted line
when focus has moved to that element.

The focus outline is important for accessibility because it gives a visual indication as to where the focus is on the page.
For keyboard-only users, tracking the focus on a web page is impossible without the visual indication given by the focus outline.
Unfortunately, some consider the focus outline to be "ugly" or unappealing, and remove it using code such as :

     a {
       outline: none;
     }

Or:

     a {
       outline: 0;
     }

Both of these will remove the outline from an element, so it won't appear even when focus has moved to that element.
This is very bad for accessibility.

Of course, there are times when you may want to provide a custom focus decoration for users instead of the default dotted border.
In those instances, it's appropriate to remove the outline and add another treatment. The best way to do this is to use
:focus and provide the alternate treatment along with resetting outline, such as:

     a:focus {
       border: 1px solid red;
       outline: none;
     }

[Source](https://github.com/CSSLint/csslint/wiki/Disallow-outline%3Anone)
      