package com.kodekutters.ms

/**
  * Scala.js façade to SPATIAL ILLUSIONS milsymbol.js
  *
  * from ref: [[http://spatialillusions.com/milsymbol/]]
  * milsymbol is a library in pure javascript that creates SVG symbols according to MIL-STD-2525C,
  * MIL-STD-2525D and NATO STANAG APP6(b).
  *
  * Note milsymbol.js MIT license.
  */

import scala.scalajs.js
import scala.scalajs.js.annotation._
import scala.scalajs.js.|
import org.scalajs.dom
import org.scalajs.dom.html
import scala.language.implicitConversions

/**
  * An anchor point
  */
@ScalaJSDefined
trait Anchor extends js.Object {
  var x: Double
  var y: Double
}

/**
  * A size object
  */
@ScalaJSDefined
trait Size extends js.Object {
  var width: Double
  var height: Double
}

/**
  * a generic JSON geometry
  */
@js.native
trait JSONGeometry extends js.Object {
  /** one of: svg, path, circle, text, translate, rotate, scale */
  var `type`: String = js.native
  var bbox: BoundingBox = js.native
}

/**
  * a svg geometry
  */
@js.native
trait SVGGeom extends JSONGeometry {
  var svg: String = js.native
}

/**
  * a path geometry
  */
@js.native
trait PathGeom extends JSONGeometry {
  var d: String = js.native
  var fill: String = js.native
  var fillopacity: Double = js.native
  var stroke: String = js.native
  var strokewidth: Double = js.native
  var strokedasharray: DashArrays = js.native
}

/**
  * a circle geometry
  */
@js.native
trait CircleGeom extends JSONGeometry {
  var cx: String = js.native
  var cy: String = js.native
  var r: String = js.native
  var fill: String = js.native
  var fillopacity: Double = js.native
  var stroke: String = js.native
  var strokewidth: Double = js.native
  var strokedasharray: DashArrays = js.native
}

/**
  * a text geometry
  */
@js.native
trait TextGeom extends JSONGeometry {
  var x: Int = js.native
  var y: Int = js.native
  var textanchor: String = js.native
  var fontsize: Int = js.native
  var fontfamily: String = js.native
  var fontweight: String = js.native
  var fill: String = js.native
  var fillopacity: Double = js.native
  var stroke: String = js.native
  var strokewidth: Double = js.native
  var strokedasharray: DashArrays = js.native
}

/**
  * a translate geometry
  */
@js.native
trait TranslateGeom extends JSONGeometry {
  var x: Int = js.native
  var y: Int = js.native
}

/**
  * a rotate geometry
  */
@js.native
trait RotateGeom extends JSONGeometry {
  var degree: Double = js.native
  var x: Int = js.native
  var y: Int = js.native
}

/**
  * a scale geometry
  */
@js.native
trait ScaleGeom extends JSONGeometry {
  var factor: Double = js.native
}

/**
  * The bounding box object tells you the dimensions for a marker or a building block object.
  * This helps you calculate where to place different symbol modifiers or the dimensions of
  * a building block that you want to add to the marker.
  */
@ScalaJSDefined
trait BoundingBox extends js.Object {
  /** The x value of the top left corner of the bounding box. */
  var x1: Double
  /** The y value of the top left corner of the bounding box. */
  var y1: Double
  /** The x value of the bottom right corner of the bounding box. */
  var x2: Double
  /** The y value of the bottom right corner of the bounding box. */
  var y2: Double

  /** The height of the bounding box. */
  def height(): Double

  /** The width of the bounding box. */
  def width(): Double

  /** use this instead of MS.bboxMax for merging bounding boxes. */
  def merge(box: BoundingBox): BoundingBox
}

/**
  * A building block object describes a part that should be added to the marker.
  * It consists of two JSON geometries, and a bounding box for the geometries.
  */
@ScalaJSDefined
trait BuildingBlock extends js.Object {
  /** This is the JSON geometry for the geometry we intend to draw. This part is inserted before any previous parts of the marker. */
  var pre: JSONGeometry
  /** This is the JSON geometry for the geometry we intend to draw. This part is inserted after any existing parts of the marker. */
  var post: JSONGeometry
  /** This is the bounding box for the SVG geometry, since javascript can't get the bounds of a SVG geometry until it has been drawn we need to calculate this manually. */
  var bbox: BoundingBox
}

/**
  * The stroke-dasharray attribute controls the pattern of dashes and gaps used to stroke paths on a SVG geometry.
  * Each property on the Dash object represent a stroke-dasharray used in milsymbol.
  */
@ScalaJSDefined
trait DashArrays extends js.Object {
  /** The value for the stroke-dasharray used for markers with a pending status. */
  var pending: String
  /** The value for the stroke-dasharray used for markers with a anticipated status */
  var anticipated: String
  /** The value for the stroke-dasharray used for the feint/dummy modifier. */
  var feintDummy: String
}

/**
  * A color mode represents a set of colors with one color for each affiliation,
  * a registered color object will have a name, this is called a color mode,
  * so that you will be able to get it using MS.getColorMode().
  */
@ScalaJSDefined
trait ColorMode extends js.Object {
  /** A color that is either a keyword or a numerical RGB specification. */
  var Civilian: String
  /** A color that is either a keyword or a numerical RGB specification. */
  var Friend: String
  /** A color that is either a keyword or a numerical RGB specification. */
  var Hostile: String
  /** A color that is either a keyword or a numerical RGB specification. */
  var Neutral: String
  /** A color that is either a keyword or a numerical RGB specification. */
  var Unknown: String
}

/**
  * The symbol colors object represent the Color modes used for different parts of the current marker.
  * All affiliations are still present for each color since some icons use colors form
  * affiliation other than their own.
  */
@ScalaJSDefined
trait SymbolColor extends js.Object {
  /** Marker fill color. */
  var fillColor: ColorMode
  /** Marker frame color. */
  var frameColor: ColorMode
  /** Icon color. */
  var iconColor: ColorMode
  /** Icon fill color. */
  var iconFillColor: ColorMode
  /** Transparent parts of the marker. */
  var none: ColorMode
  /** Black parts of the marker. */
  var black: ColorMode
  /** White parts of the marker. */
  var white: ColorMode
}

/**
  * Symbol outline
  */
@ScalaJSDefined
trait Outline extends js.Object {
  /** the geometry or array of such */
  var geom: JSONGeometry | Array[JSONGeometry]
  /** symbol outline width */
  var outlineWidth: Double
  /** symbol outline stroke */
  var strokeWidth: Double
  /** symbol outline color */
  var outlineColor: String
}

/**
  * The properties object describes a lot of different properties for the current marker.
  * This basically tells you everything you might need to know about your current marker and
  * depends on the SIDC for the symbol and the symbol options that you have set.
  */
@ScalaJSDefined
trait Properties extends js.Object {
  /** Is it an Activity */
  var activity: Boolean
  /** Dimension it is shown as (Air/Ground...) for example Ground Equipment is shown with the same shape as Sea.  */
  var dimension: String
  /** Affiliation it is shown as (Friend/Hostile...) for example a Faker Hostile, will be shown with the shape of Friends. */
  var affiliation: String
  /** Dimension it belongs to (Air/Ground...)  */
  var baseDimension: String
  /** Affiliation it belongs to (Friend/Hostile...) */
  var baseAffilation: String
  /** Is it Civilian  */
  var civilian: Boolean
  /** Is the dimension unknown  */
  var dimensionUnknown: Boolean
  /** Is it a Faker  */
  var faker: Boolean
  /** Is it a feint/dummy */
  var fenintDummy: Boolean
  /** Standard says it should be filled  */
  var fill: Boolean
  /** Standard says it should be framed  */
  var frame: Boolean
  /** Is it a Headquarters  */
  var headquarters: Boolean
  /** Is it an Instalation  */
  var installation: Boolean
  /** Is it a Joker  */
  var joker: Boolean
  /** Is the SIDC number based */
  var numberSIDC: Boolean
  /** Is it in Space  */
  var space: Boolean
  /** Is it a task force */
  var taskForce: Boolean
  /** What condition is it in  */
  var condition: String
  /** Context of the symbol (Reality/Exercise...)  */
  var context: String
  /** What echelon (Platoon/Company...)  */
  var echelon: String
  /** Part of SIDC referring to the icon.  */
  var functionid: String
  /** What mobility (Tracked/Sled...)  */
  var mobility: String
  /** Is it Anticipated or Pending  */
  var notpresent: String
  /** Geometry is a combination of dimension and affiliation (AirFriend/GroundHostile...)  */
  var baseGeometry: JSONGeometry
  /** The bottom of the icon, this is only set for equipment symbols.  */
  var iconBottom: Double
}

/**
  * the Symbol options
  */
@ScalaJSDefined
trait SymbolOptions extends js.Object {

  /** Should your symbol be filled with color. */
  val fill: js.UndefOr[Boolean] = js.undefined

  /** Should your symbol have a frame. All symbols support to be unframed, not just the ones specified in 2525B. */
  val frame: js.UndefOr[Boolean] = js.undefined

  /** Should your symbol have an icon. */
  val icon: js.UndefOr[Boolean] = js.undefined

  /** 2525C specifics purple as an optional color for civilian symbols. Of course we like this color so we set it as valault.  */
  val civilianColor: js.UndefOr[Boolean] = js.undefined

  /** If you have set some text fields and direction but don't want them to be displayed you can set infoFields to false. This makes it possible to initiate the object with all information you got but not display it. */
  val infoFields: js.UndefOr[Boolean] = js.undefined

  /** MIL-STD-2525D lets you choose between MEDAL and alternate MEDAL icons for mine warefare symbols, the default in milsymbol is using MEDAL icons, but you can change this using setting this property to true. */
  val alternateMedal: js.UndefOr[Boolean] = js.undefined

  /** The opacity of the symbol fill color. */
  val fillOpacity: js.UndefOr[Double] = js.undefined

  /** The stroke width of the symbol. */
  val strokeWidth: js.UndefOr[Double] = js.undefined

  /** The L value for your symbol, where the L value is the width of the icon octagon.  */
  val size: js.UndefOr[Double] = js.undefined

  /** This is the option for setting what Color object to use for the fill of the symbols. You can use MS.colorMode to create a new color mode, or MS.getColorMode to get an existing color mode. */
  val colorMode: js.UndefOr[ColorMode] = js.undefined

  /** A color that is either a keyword or a numerical RGB specification. If you set this the symbol will be monochrome and unfilled using the color provided. */
  val monoColor: js.UndefOr[String] = js.undefined

  /** The size of the text fields surrounding the symbol. */
  val infoSize: js.UndefOr[Double] = js.undefined

  // information section
  /** FieldID C -
    * A text modifier in an equipment symbol that identifies the number of items present. 9 Characters  */
  val quantity: js.UndefOr[String] = js.undefined

  /** FieldID F -
    * A text modifier in a unit symbol that displays (+) for reinforced, (-) for reduced, (±) reinforced and reduced. 3 Characters */
  val reinforcedReduced: js.UndefOr[String] = js.undefined

  /** FieldID G -
    * A text modifier for units, equipment and installations; content is implementation specific. 20 Characters */
  val staffComments: js.UndefOr[String] = js.undefined

  /** FieldID H -
    * A text modifier for units, equipment, and installations; content is implementation specific. 20 Characters  */
  val additionalInformation: js.UndefOr[String] = js.undefined

  /** FieldID J
    * A text modifier for units, equipment, and installations that consists of a one-letter reliability rating and a one-number credibility rating. 2 Characters */
  val evaluationRating: js.UndefOr[String] = js.undefined

  /** FieldID K -
    * A text modifier for units and installations that indicates unit effectiveness or installation capability. 5 Characters */
  val combatEffectiveness: js.UndefOr[String] = js.undefined

  /** FieldID L -
    * A text modifier for hostile equipment; "!" indicates detectable electronic signatures. 1 Characters */
  val signatureEquipment: js.UndefOr[String] = js.undefined

  /** FieldID M -
    * A text modifier for units that indicates number or title of higher echelon command (corps are designated by Roman numerals). 21 Characters */
  val higherFormation: js.UndefOr[String] = js.undefined

  /** FieldID N
    * A text modifier for equipment; letters "ENY" denote hostile symbols. 3 Characters */
  val hostile: js.UndefOr[String] = js.undefined

  /** FieldID P -
    * A text modifier displaying IFF/SIF Identification modes and codes. 5 Characters	 */
  val iffSif: js.UndefOr[String] = js.undefined

  /** FieldID Q -  at the moment all directions should be in degrees and not in mils. Set to an empty string to remove the direction arrow. */
  val direction: js.UndefOr[Double] = js.undefined

  /** FieldID R2 -
    * M = Mobile, S = Static, or U = Uncertain. */
  val sigint: js.UndefOr[String] = js.undefined

  /** FieldID T -
    * A text modifier for units, equipment, and installations that uniquely identifies a particular symbol or track number. Identifies acquisitions number when used with SIGINT symbology. 21 Characters */
  val uniqueDesignation: js.UndefOr[String] = js.undefined

  /** FieldID V -
    * A text modifier for equipment that indicates types of equipment. 24 Characters */
  val `type`: js.UndefOr[String] = js.undefined

  /** FieldID W -
    * A text modifier for units, equipment, and installations that displays DTG format: DDHHMMSSZMONYYYY or "O/O" for on order. 16 Characters */
  val dtg: js.UndefOr[String] = js.undefined

  /** FieldID X -
    * A text modifier for units, equipment, and installations, that displays either altitude flight level, depth for submerged objects; or height of equipment or structures on the ground. 14 Characters	 */
  val altitudeDepth: js.UndefOr[String] = js.undefined

  /** FieldID Y -
    * A text modifier for units, equipment, and installations that displays a symbol's location in degrees, minutes, and seconds (or in UTM or other applicable display format). 19 Characters */
  val location: js.UndefOr[String] = js.undefined

  /** FieldID Z -
    * A text modifier for units and equipment that displays velocity as set forth in MIL-STD-6040. 8 Characters	 */
  val speed: js.UndefOr[String] = js.undefined

  /** FieldID AA -
    * A text modifier for units; indicator is contained inside the frame; contains the name of the special C2 Headquarters. 9 Characters */
  val specialHeadquarters: js.UndefOr[String] = js.undefined

  /** FieldID AD -
    * "ELNOT" or "CENOT" */
  val platformType: js.UndefOr[String] = js.undefined

  /** FieldID AE -
    * Equipment teardown time in minutes. */
  val equipmentTeardownTime: js.UndefOr[String] = js.undefined

  /** FieldID AF -
    * Example: "Hawk" for Hawk SAM system. */
  val commonIdentifier: js.UndefOr[String] = js.undefined

  /** symbol outline width */
  val outlineWidth: js.UndefOr[Double] = js.undefined

  /** symbol outline color */
  val outlineColor: js.UndefOr[String] = js.undefined

}

/**
  * Symbol object with a SIDC, and optional symbol options
  * The SIDC is a complete, letter based or number based, or at least the first 3 chars of a letter based SIDC.
  */
@JSName("ms.symbol")
@js.native
class Symbol protected() extends js.Object {
  /** constructor */
  def this(SIDC: String, options: SymbolOptions = ???) = this()

  /** This will update and return the Properties Object for the current marker. */
  def getProperties(): Properties = js.native

  /** This will return an object with several named properties, where each property is a Color object. This represent all colors that can be used for the current marker. */
  def getColors(): SymbolColor = js.native

  /** When the getMarker() method is called, all properties of the Symbol Object
    * is updated (getMarker() calls getProperties() and getColors()) and a marker
    * is composed by all marker parts. When this is done the Symbol Object itself is returned.
    *
    * Note: not needed anymore, symbols are automatically updated when options are updated
    * using setOptions(). */
  def getMarker(): Symbol = js.native

  /** If you want to change the options of an existing symbol at the same time as you want to request it as a new marker,
    * you can use setOptions(<Symbol options> options?) to update the options. */
  def setOptions(options: SymbolOptions): Symbol = js.native

  /** Parses the XML and returns a DOM element. */
  def asDOM(): dom.Element = js.native

  /** Base 64 encodes the XML and returns the output as a SVG image stream that can be set as the source attribute on a image element. */
  def toDataURL(): String = js.native // base 64 string todo

  /** Draws the marker to a canvas element using native draw instructions and returns the canvas element. */
  def asCanvas(ratio: Double = 1): html.Canvas = js.native

  /** This will return the SVG XML string and it will also be stored in the XML property, if autoSVG is set to true the will be called automatically when you call getMarker. */
  def asSVG(): String = js.native

  /** returns an object with the width and height of the symbol. */
  def getSize(): Size = js.native

  /** returns an object with the x and y offset of the symbol. */
  def getAnchor(): Anchor = js.native

  /** returns an object with the x and y offset of the octagon center. */
  def getOctagonAnchor(): Anchor = js.native

  // properties
  /** Contains the bounding box of the current marker */
  var bbox: BoundingBox = js.native
  /** Contains the colors for the current marker */
  var colors: Array[ColorMode] = js.native
  /** Height of the current marker */
  var height: Double = js.native
  /** The anchor point for the current marker, this is usually the center of the octagon, but for headquarters it's the end of the staf. The coordinates are measured from the top left corner of the marker. */
  var markerAnchor: Anchor = js.native
  /** The anchor point for the octagon for the current marker. The coordinates are measured from the top left corner of the marker. */
  var octagonAnchor: Anchor = js.native
  /** Properties of the current marker */
  var properties: Properties = js.native
  /** Width of the current marker */
  var width: Double = js.native
  /** XML-string for the current marker */
  var XML: String = js.native

  // the basic options
  /** Should your symbol be filled with color. */
  var fill: Boolean = js.native
  /** Should your symbol have a frame. All symbols support to be unframed, not just the ones specified in 2525B. */
  var frame: Boolean = js.native
  /** Should your symbol have an icon. */
  var icon: Boolean = js.native
  /** 2525C specifics purple as an optional color for civilian symbols. Of corse we like color so we set this as default.  */
  var civilianColor: Boolean = js.native
  /** If you have set some text fields and direction but don't want them to be displayed you can set infoFields to false. This makes it possible to initiate the object with all information you got but not display it. */
  var infoFields: Boolean = js.native
  /** MIL-STD-2525D lets you choose between MEDAL and alternate MEDAL icons for mine warefare symbols, the default in milsymbol is using MEDAL icons, but you can change this using setting this property to true. */
  var alternateMedal: Boolean = js.native
  /** The opacity of the symbol fill color. */
  var fillOpacity: Double = js.native
  /** The stroke width of the symbol. */
  var strokeWidth: Double = js.native
  /** The L value for your symbol, where the L value is the width of the icon octagon.  */
  var size: Double = js.native
  /** This is the option for setting what Color object to use for the fill of the symbols. You can use MS.colorMode to create a new color mode, or MS.getColorMode to get an existing color mode. */
  var colorMode: ColorMode = js.native
  /** A color that is either a keyword or a numerical RGB specification. If you set this the symbol will be monochrome and unfilled using the color provided. */
  var monoColor: String = js.native
  /** The size of the text fields surrounding the symbol. */
  var infoSize: Double = js.native

  // information fields options
  /** FieldID C -
    * A text modifier in an equipment symbol that identifies the number of items present. 9 Characters  */
  var quantity: String = js.native
  /** FieldID F -
    * A text modifier in a unit symbol that displays (+) for reinforced, (-) for reduced, (±) reinforced and reduced. 3 Characters */
  var reinforcedReduced: String = js.native
  /** FieldID G -
    * A text modifier for units, equipment and installations; content is implementation specific. 20 Characters */
  var staffComments: String = js.native
  /** FieldID H -
    * A text modifier for units, equipment, and installations; content is implementation specific. 20 Characters  */
  var additionalInformation: String = js.native
  /** FieldID J -
    * A text modifier for units, equipment, and installations that consists of a one-letter reliability rating and a one-number credibility rating. 2 Characters */
  var evaluationRating: String = js.native
  /** FieldID K -
    * A text modifier for units and installations that indicates unit effectiveness or installation capability. 5 Characters */
  var combatEffectiveness: String = js.native
  /** FieldID L -
    * A text modifier for hostile equipment; "!" indicates detectable electronic signatures. 1 Characters */
  var signatureEquipment: String = js.native
  /** FieldID M -
    * A text modifier for units that indicates number or title of higher echelon command (corps are designated by Roman numerals). 21 Characters */
  var higherFormation: String = js.native
  /** FieldID N -
    * A text modifier for equipment; letters "ENY" denote hostile symbols. 3 Characters */
  var hostile: String = js.native
  /** FieldID P -
    * A text modifier displaying IFF/SIF Identification modes and codes. 5 Characters	 */
  var iffSif: String = js.native
  /** FieldID Q -  at the moment all directions should be in degrees and not in mils. Set to an empty string to remove the direction arrow. */
  var direction: Double = js.native
  /** FieldID R2 -
    * M = Mobile, S = Static, or U = Uncertain. */
  var sigint: String = js.native
  /** FieldID T -
    * A text modifier for units, equipment, and installations that uniquely identifies a particular symbol or track number. Identifies acquisitions number when used with SIGINT symbology. 21 Characters */
  var uniqueDesignation: String = js.native
  /** FieldID V -
    * A text modifier for equipment that indicates types of equipment. 24 Characters */
  var `type`: String = js.native
  /** FieldID W -
    * A text modifier for units, equipment, and installations that displays DTG format: DDHHMMSSZMONYYYY or "O/O" for on order. 16 Characters */
  var dtg: String = js.native
  /** FieldID X -
    * A text modifier for units, equipment, and installations, that displays either altitude flight level, depth for submerged objects; or height of equipment or structures on the ground. 14 Characters	 */
  var altitudeDepth: String = js.native
  /** FieldID Y -
    * A text modifier for units, equipment, and installations that displays a symbol's location in degrees, minutes, and seconds (or in UTM or other applicable display format). 19 Characters */
  var location: String = js.native
  /** FieldID Z -
    * A text modifier for units and equipment that displays velocity as set forth in MIL-STD-6040. 8 Characters	 */
  var speed: String = js.native
  /** FieldID AA -
    * A text modifier for units; indicator is contained inside the frame; contains the name of the special C2 Headquarters. 9 Characters */
  var specialHeadquarters: String = js.native
  /** FieldID AD -
    * "ELNOT" or "CENOT" */
  var platformType: String = js.native
  /** FieldID AE -
    * Equipment teardown time in minutes. */
  var equipmentTeardownTime: String = js.native
  /** FieldID AF -
    * Example: "Hawk" for Hawk SAM system. */
  var commonIdentifier: String = js.native
}

/**
  * Global milsymbol
  */
@JSName("ms")
@js.native
object MS extends js.Object {

  /** Get the current version of milsymbol */
  val version: String = js.native

  /** Gets or sets if milsymbol should generate SVG output by default, if you only plan on using Canvas you can set this to false. */
  var autoSVG: Boolean = js.native

  /** "2525" or "APP6" */
  def setStandard(symbology: String): Unit = js.native

  /** Creates a new symbol object using the SIDC provided. */
  def symbol(SIDC: String, options: SymbolOptions = ???): Symbol = js.native

  /** Gets the dash-arrays used in dashed symbols. */
  def getDashArrays(): DashArrays = js.native

  /** Creates an object with two SVG geometry that creates a part of a milsymbol marker, and the bounding box for that geometry.
    * The first SVG geometry is inserted before existing code and the second after.
    */
  def buildingBlock(pre: JSONGeometry, post: JSONGeometry, bbox: BoundingBox): BuildingBlock = js.native

  /** Initiates a basic bounding box for a geometry covering the symbol octagon. */
  def bbox(): BoundingBox = js.native

  /** Creates a new color mode from an array of colors. */
  def colorMode(civilian: String, friend: String, hostile: String, neutral: String, unknown: String): ColorMode = js.native

  /** Gets an color mode that has been registred with a name. */
  def getColorMode(mode: String): ColorMode = js.native

  /** Register a color mode with a name. */
  def setColorMode(mode: String, color: ColorMode): ColorMode = js.native

  /** Sets the dash-arrays used in dashed symbols. */
  def setDashArrays(pending: String, anticipated: String, feintDummy: String): DashArrays = js.native

  /** This method gets the setting for how long the HQ staf should be, default it is one octagon (100) long. */
  def getHqStafLength(): Double = js.native

  /** This method gets the setting for how long the HQ staf should be, you can set it to any number, but would recommend to keep it between 50 - 150. */
  def setHqStafLength(number: Double): Double = js.native

  /** The max bounds of two bounding boxes. */
  def bboxMax(box1: BoundingBox, box2: BoundingBox): BoundingBox = js.native

  /** Returns an array of functions where each function returns a building block for a marker. */
  def getMarkerParts(): Array[js.Function] = js.native

  /** Adds a new function that returns a building block for a marker. This function will be added at the end of the marker parts array and therefor rendered on top of all other parts of the marker. This is an easy way to extend milsymbol. */
  def addMarkerParts(function: js.Function): Array[js.Function] = js.native

  /** adds icon parts */
  def addIconParts(function: js.Function): Array[js.Function] = js.native

  /** adds letter sidc SIDC  */
  def addLetterSIDCicons(function: js.Function): Array[js.Function] = js.native

  /** adds number sidc SIDC */
  def addNumberSIDCicons(function: js.Function): Array[js.Function] = js.native

  /** Sets a new array of function where each function returns a building block for a marker. You can use this if you want to add custom code between existing marker parts when you are extending milsymbol. */
  def setMarkerParts(functions: Array[js.Function]): Unit = js.native

  /** symbol outline   */
  def outline(outline: Outline): Unit = js.native

  /** symbol outline   */
  def outline(geom: JSONGeometry | Array[JSONGeometry], outlineWidth: Double, strokeWidth: Double, outlineColor: String): Unit = js.native

  /** Creates a new color mode from a string representing a registered color mode */
  def colorMode(mode: String): ColorMode = js.native

  def colorMode(mode: ColorMode): ColorMode = js.native

  def getVersion(): String = js.native

  /** the "internal" milsymbol object */
  val ms: this.type = js.native

  def addSIDCicons(function: js.Function, `type`: String): this.type = js.native

  def addLabelOverrides(function: js.Function, `type`: String): this.type = js.native

  def addSymbolPart(function: js.Function): this.type = js.native

  def addLetterLabelOverrides(function: js.Function, `type`: String): this.type = js.native

  def BBox(): BoundingBox = js.native

  def ColorMode(): ColorMode = js.native

  def Symbol(): Symbol = js.native

  //  def addNumberLabelOverrides(function: js.Function): Array[js.Function] = js.native

  //  def setSymbolParts(function: js.Function): Array[js.Function] = js.native

  //  def addIconPart(function: js.Function): Array[js.Function] = js.native

}
