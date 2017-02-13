Change Log
==========

## changes in 0.3-SNAPSHOT
* added cross building and publishing for scala 2.11.8 and 2.12.1
* added merge to BoundingBox
* added getSize(), getAnchor() and getOctagonAnchor() to Symbol
* added a Size object (supporting Scala element) used in Symbol.getSize()
* added getVersion(), addSIDCicons, addLabelOverrides, addSymbolPart, addLetterLabelOverrides,
BBox, ColorMode, Symbol and ms to MS Object
* removed translate, rotate and scale from MS object
* added colorMode(mode: String) to creates a new color mode from a string representing a registered color mode 
* added colorMode(mode: ColorMode) as above for convenience


## changes in 0.2
compatible with milsymbol.js-0.6

* changed asImage to toDataURL
* changed asCanvas(ratio: Double = 1) to take a "window" ratio value, default=1.
* changed all strokeWidth to be Double
* added Outline 
* added addIconParts(function: js.Function)
* added addLetterSIDCicons(function: js.Function), addNumberSIDCicons(function: js.Function)

* updated to Scala.js-0.6.14
* replaced SymbolOptionsBuilder with Scala.js-0.6.14 configuration object
* removed dependency on org.querki.jsext 