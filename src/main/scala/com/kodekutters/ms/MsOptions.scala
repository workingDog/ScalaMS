package com.kodekutters.ms

import com.kodekutters.ms.MS.ColorMode
import org.querki.jsext.{JSOptionBuilder, OptMap, noOpts}

import scala.scalajs.js
import scala.scalajs.js.annotation._
import scala.scalajs.js.{Promise => _, _}

@JSName("MS.Options")
@js.native
trait SymbolOptions extends js.Object

object SymbolOptions extends SymbolOptionsBuilder(noOpts)

class SymbolOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[SymbolOptions, SymbolOptionsBuilder](new SymbolOptionsBuilder(_)) {
  def fill(v: Boolean) = jsOpt("fill", v)

  def frame(v: Boolean) = jsOpt("frame", v)

  def icon(v: Boolean) = jsOpt("icon", v)

  def civilianColor(v: Boolean) = jsOpt("civilianColor", v)

  def infoFields(v: Boolean) = jsOpt("infoFields", v)

  def alternateMedal(v: Boolean) = jsOpt("alternateMedal", v)

  def fillOpacity(v: Double) = jsOpt("fillOpacity", v)

  def strokeWidth(v: Float) = jsOpt("strokeWidth", v)

  def size(v: Double) = jsOpt("size", v)

  def colorMode(v: ColorMode) = jsOpt("colorMode", v)

  def monoColor(v: String) = jsOpt("monoColor", v)

  def infoSize(v: Double) = jsOpt("infoSize", v)

  // information section
  def quantity(v: String) = jsOpt("quantity", v)

  def reinforcedReduced(v: String) = jsOpt("reinforcedReduced", v)

  def staffComments(v: String) = jsOpt("staffComments", v)

  def additionalInformation(v: String) = jsOpt("additionalInformation", v)

  def evaluationRating(v: String) = jsOpt("evaluationRating", v)

  def combatEffectiveness(v: String) = jsOpt("combatEffectiveness", v)

  def signatureEquipment(v: String) = jsOpt("signatureEquipment", v)

  def higherFormation(v: String) = jsOpt("higherFormation", v)

  def hostile(v: String) = jsOpt("hostile", v)

  def iffSif(v: String) = jsOpt("iffSif", v)

  def direction(v: String) = jsOpt("direction", v)

  def sigint(v: String) = jsOpt("sigint", v)

  def uniqueDesignation(v: String) = jsOpt("uniqueDesignation", v)

  def `type`(v: String) = jsOpt("type", v)

  def dtg(v: String) = jsOpt("dtg", v)

  def altitudeDepth(v: String) = jsOpt("altitudeDepth", v)

  def location(v: String) = jsOpt("location", v)

  def speed(v: String) = jsOpt("speed", v)

  def specialHeadquarters(v: String) = jsOpt("specialHeadquarters", v)

  def platformType(v: String) = jsOpt("platformType", v)

  def equipmentTeardownTime(v: String) = jsOpt("equipmentTeardownTime", v)

  def commonIdentifier(v: String) = jsOpt("commonIdentifier", v)
}
