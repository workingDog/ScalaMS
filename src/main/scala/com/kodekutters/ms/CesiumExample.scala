//package com.kodekutters.ms
//
//import com.kodekutters.ms.MsOptions.SymbolOptions
//import com.kodekutters.ms.MS.{MS, _}
//
//import scala.language.implicitConversions
//import scala.scalajs.js
//import scala.scalajs.js.JSApp
//
///**
//  * a basic example using CesiumScala.
//  *
//  * to compile and generate CesiumScala, type "sbt fastOptJS".
//  * This will generate "cesiumscala-fastopt.js" in the "./js directory".
//  * Put "CesiumScala.html" and "cesiumscala-fastopt.js" files in the "Cesium/Apps" directory and
//  * launch Cesium (node server.js).
//  * Then point your browser to http://localhost:8080/Apps/CesiumScalaTest.html
//  *
//  */
//object CesiumExample extends JSApp {
//
//  implicit def Cartesian3ToConstPosProp(value: Cartesian3): ConstantPositionProperty = new ConstantPositionProperty(value)
//  implicit def ValueToConstProp(value: Any): ConstantProperty = new ConstantProperty(value.asInstanceOf[js.Any])
//
//
//  def main(): Unit = {
//    Console.println("---> hello from tt MilSymbol")
//
//    // launch the Cesium viewer
//    val viewer = new Viewer("cesiumContainer", ViewerOptions.
//      scene3DOnly(true).
//      animation(false).
//      timeline(false).
//      infoBox(false))
//
//    def addBillboard() = {
//      // create a MIL-2525 symbol
//      val sym = new Symbol("SFG-UCI----D", SymbolOptions.size(35))
//
//      viewer.entities.add(new Entity(EntityOptions.
//        position(Cartesian3.fromDegrees(-75.59777, 40.03883)).
//        billboard(new BillboardGraphics(
//          BillboardGraphicsOptions.
//            image(sym.getMarker().asCanvas()). // <--- the bilboard image is the symbol
//            show(true).
//            scale(2.0).
//            color(Color.LIME).
//            rotation(Math.PI / 4.0).
//            horizontalOrigin(HorizontalOrigin.CENTER).
//            pixelOffset(new Cartesian2(-sym.markerAnchor.x, -sym.markerAnchor.y)).
//            verticalOrigin(VerticalOrigin.BOTTOM).
//            alignedAxis(Cartesian3.ZERO).
//            width(50.0).
//            height(25.0)))))
//    }
//
//    addBillboard()
//  }
//}
