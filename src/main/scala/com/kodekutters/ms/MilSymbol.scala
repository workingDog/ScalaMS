package com.kodekutters.ms

/**
  * Scala.js façade to SPATIAL ILLUSIONS milsymbol.js
  *
  * from ref: [[http://spatialillusions.com/milsymbol/]]
  *   milsymbol is a library in pure javascript that creates SVG symbols according to MIL-STD-2525C,
  *   MIL-STD-2525D and NATO STANAG APP6(b). Since version 0.5.5 native canvas output is supported as well as SVG.
  *
  * Note milsymbol.js BSD license.
  */
package MS {

  import scala.scalajs.js
  import scala.scalajs.js.annotation._
  import scala.scalajs.js.{Promise => _, _}
  import org.scalajs.dom
  import scala.language.implicitConversions
  import org.scalajs.dom.html


  /**
    * helper object representing an anchor point
    */
  @ScalaJSDefined
  trait Anchor extends js.Object {
    var x: Double
    var y: Double
  }

  /**
    * a JSON geometry todo use js.Any for now
    */
//  @ScalaJSDefined
//  trait JSGeometry extends js.Object {
//    /** "path" or "circle" */
//    var `type`: String
//    var d: String
//    var cx: String
//    var cy: String
//    var r: String
//    var fill: Boolean
//    var stroke: Color
//    var strokewidth: Double
//    var strokedasharray: DashArrays
//
//    var bbox: BoundingBox
//  }

  /**
    * The bounding box object tells you the dimensions for a marker or a building block object.
    * This helps you calculate where to place different symbol modifiers or the dimensions of
    * a building block that you want to add to the marker.
    */
  @JSName("MS.bbox")
  @ScalaJSDefined
  trait BoundingBox extends js.Object {
    var x1: Double
    var x2: Double
    var y1: Double
    var y2: Double

    def height(): Double
    def width(): Double
  }

  /**
    * A building block object describes a part that should be added to the marker.
    * It consists of two JSON geometries, and a bounding box for the geometries.
    */
  @JSName("MS.buildingBlock")
  @ScalaJSDefined
  trait BuildingBlock extends js.Object {
    var pre: js.Any
    var post: js.Any
    var bbox: BoundingBox
  }

  /**
    * The stroke-dasharray attribute controls the pattern of dashes and gaps used to stroke paths on a SVG geometry.
    * Each property on the Dash object represent a stroke-dasharray used in milsymbol.
    */
  @JSName("MS.getDashArrays")
  @ScalaJSDefined
  trait DashArrays extends js.Object {
    var pending: String
    var anticipated: String
    var feintDummy: String
  }

  /**
    * A color mode represents a set of colors with one color for each affiliation,
    * a registred color object will have a name, this is called a color mode,
    * so that you will be able to get it using MS.getColorMode().
    */
  @JSName("MS.colorMode")
  @js.native
  class ColorMode protected() extends js.Object {
    def this(civilian: String, friend: String, hostile: String, neutral: String, unknown: String) = this()

    var Civilian: String = js.native  // the color of civilian
    var Friend: String = js.native
    var Hostile: String = js.native
    var Neutral: String = js.native
    var Unknown: String = js.native
  }

  /**
    * The symbol colors object represent the Color modes used for different parts of the current marker.
    * All affiliations are still present for each color since some icons use colors form
    * affiliation other than their own.
    */
  @ScalaJSDefined
  trait SymbolColor extends js.Object {
    var fillColor: ColorMode
    var frameColor: ColorMode
    var iconColor: ColorMode
    var iconFillColor: ColorMode
    var none: ColorMode
    var black: ColorMode
    var white: ColorMode
  }

  /**
    * The properties object describes a lot of different properties for the current marker.
    * This basically tells you everything you might need to know about your current marker and
    * depends on the SIDC for the symbol and the symbol options that you have set.
    */
  @ScalaJSDefined
  trait Properties extends js.Object {
    var activity: Boolean
    var dimension: String
    var affiliation: String
    var baseDimension: String
    var baseAffilation: String
    var civilian: Boolean
    var dimensionUnknown: Boolean
    var faker: Boolean
    var fenintDummy: Boolean
    var fill: Boolean
    var frame: Boolean
    var headquarters: Boolean
    var installation: Boolean
    var joker: Boolean
    var numberSIDC: Boolean
    var space: Boolean
    var taskForce: Boolean
    var condition: String
    var context: String
    var echelon: String
    var functionid: String
    var mobility: String
    var notpresent: String
    var baseGeometry: js.Any
    var iconBottom: Double
  }

  /**
    * Symbol object with a SIDC, and optional symbol options
    */
  @JSName("MS.symbol")
  @js.native
  class Symbol protected() extends js.Object {
    def this(SIDC: String, options: SymbolOptions = ???) = this()

    def getProperties(): Properties = js.native

    def getColors(): SymbolColor = js.native

    def getMarker(): Symbol = js.native

    def setOptions(options: SymbolOptions): Symbol = js.native

    def asDOM(): dom.Element = js.native

    def asImage(): String = js.native // base 64 string todo

    def asCanvas(): html.Canvas = js.native

    def asSVG(): String = js.native

    // properties
    var bbox: BoundingBox = js.native
    var colors: Array[ColorMode] = js.native
    var height: Double = js.native
    var markerAnchor: Anchor = js.native
    var octagonAnchor: Anchor = js.native
    var properties: Properties = js.native
    var width: Double = js.native
    var XML: String = js.native

    // the main options
    var fill: Boolean = js.native
    var frame: Boolean = js.native
    var icon: Boolean = js.native
    var civilianColor: Boolean = js.native
    var infoFields: Boolean = js.native
    var alternateMedal: Boolean = js.native
    var fillOpacity: Double = js.native
    var strokeWidth: Float = js.native
    var size: Double = js.native
    var colorMode: ColorMode = js.native
    var monoColor: String = js.native
    var infoSize: Double = js.native

    // information section
    var quantity: String = js.native
    var reinforcedReduced: String = js.native
    var staffComments: String = js.native
    var additionalInformation: String = js.native
    var evaluationRating: String = js.native
    var combatEffectiveness: String = js.native
    var signatureEquipment: String = js.native
    var higherFormation: String = js.native
    var hostile: String = js.native
    var iffSif: String = js.native
    var direction: String = js.native
    var sigint: String = js.native
    var uniqueDesignation: String = js.native
    var `type`: String = js.native
    var dtg: String = js.native
    var altitudeDepth: String = js.native
    var location: String = js.native
    var speed: String = js.native
    var specialHeadquarters: String = js.native
    var platformType: String = js.native
    var equipmentTeardownTime: String = js.native
    var commonIdentifier: String = js.native
  }

  /**
    * Global milsymbol
    */
  @JSName("MS")
  @js.native
  object MS extends js.Object {

    val version: String = js.native

    var autoSVG: Boolean = js.native

    /** "2525" or "APP6" */
    def setStandard(symbology: String): Unit = js.native

    def symbol(SIDC: String, options: SymbolOptions = ???): Symbol = js.native

    def getDashArrays(): DashArrays = js.native

    def buildingBlock(pre: js.Any, post: js.Any, bbox: BoundingBox): BuildingBlock = js.native

    def bbox(): BoundingBox = js.native

    def colorMode(civilian: String, friend: String, hostile: String, neutral: String, unknown: String): ColorMode = js.native

    def getColorMode(mode: String): ColorMode = js.native

    def setColorMode(mode: String, color: ColorMode): ColorMode = js.native

    def setDashArrays(pending: String, anticipated: String, feintDummy: String): DashArrays = js.native

    def getHqStafLength(): Double = js.native

    def setHqStafLength(number: Double): Double = js.native

    def bboxMax(box1: BoundingBox, box2: BoundingBox): BoundingBox = js.native

    def getMarkerParts(): Array[js.Function] = js.native

    def addMarkerParts(function: js.Function): Array[js.Function] = js.native

    def setMarkerParts(functions: Array[js.Function]): Unit = js.native

    def translate(x: Double, y: Double, instruction: js.Any): js.Any = js.native

    def rotate(angle: Double, instruction: js.Any): js.Any = js.native

    def scale(factor: Double, instruction: js.Any): js.Any = js.native
  }

}