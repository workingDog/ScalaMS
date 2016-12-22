# Scala.js façade to milsymbol.js 

This library **ScalaMS** is a Scala interface to the SPATIAL ILLUSIONS [Military Unit Symbols in JavaScript](http://www.spatialillusions.com/milsymbol), milsymbol.js.

[milsymbol.js](https://github.com/spatialillusions/milsymbol) is a library in pure JavaScript that creates SVG symbols according to MIL-STD-2525C,
MIL-STD-2525D and NATO STANAG APP6(b). 

## References
 
1) [milsymbol.js](https://github.com/spatialillusions/milsymbol)

## Dependencies

See the build.sbt file.

## Usage

To use the last release add the following dependency to your build.sbt:

    libraryDependencies += "com.github.workingDog" %%% "scalams" % "0.1"

To create a new symbol:

    val sym = new Symbol("sfgpewrh--mt", SymbolOptions.
      size(80).
      quantity("200").
      staffComments("for reinforcements".toUpperCase).
      direction(750 * 360 / 6400).
      `type`("machine gun").
      dtg("30140000ZSEP97").
      location("0900000.0E570306.0N"))

See also [CesiumMil](https://github.com/workingDog/CesiumMil) for a basic example of using 
[ScalaMS](https://github.com/workingDog/ScalaMS) and [CesiumScala](https://github.com/workingDog/CesiumScala)

## Compiling and installation 

scalams version "0.2-SNAPSHOT" now requires Scala.js-0.6.14.

To compile and generate a javascript file from the source code:

    sbt fullOptJS 

The javascript file (scalams-opt.js) will be in the "./target/scala-2.11" directory.


To publish **ScalaMS** to your local (Ivy) repository, simply type:

    sbt publishLocal
    
Then put this in your build.sbt file

    libraryDependencies += "com.github.workingDog" %%% "scalams" % "0.2-SNAPSHOT"

To create a new symbol using "0.2-SNAPSHOT":

    val sym = new Symbol("sfgpewrh--mt", new SymbolOptions {
      override val size: js.UndefOr[Double] = 80
      override val quantity: js.UndefOr[String] = "200"
      override val staffComments: js.UndefOr[String] = "for reinforcements".toUpperCase
      override val direction: js.UndefOr[Double] = 750 * 360 / 6400
      override val `type`: js.UndefOr[String] = "machine gun"
      override val dtg: js.UndefOr[String] = "30140000ZSEP97"
      override val fill: js.UndefOr[Boolean] = true
      override val location: js.UndefOr[String] = "0900000.0E570306.0N"
    })

## Documentations

Refer to the original [overview](http://spatialillusions.com/milsymbol/index.html) documentation and 
the [milsymbol API](http://www.spatialillusions.com/milsymbol/docs/index.html) documentation.

To generate the Scala doc:
    
    sbt doc

The Scala API doc will be in the "./target/scala-2.11/api" directory.

## Status

usable

