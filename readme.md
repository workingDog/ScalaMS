# Scala.js façade to milsymbol.js 

This library **ScalaMS** is a Scala interface to the SPATIAL ILLUSIONS [Military Unit Symbols in JavaScript](http://www.spatialillusions.com/milsymbol), milsymbol.js.

[milsymbol.js](https://github.com/spatialillusions/milsymbol) is a library in pure JavaScript that creates SVG symbols according to MIL-STD-2525C,
MIL-STD-2525D and NATO STANAG APP6(b). 

## References
 
1) [milsymbol.js](https://github.com/spatialillusions/milsymbol)

## Dependencies

See the build.sbt file.

## Installation and packaging

To compile and generate a jar file from the source code:

    sbt package

The jar file (scalams_sjs0.6_2.11-0.1-SNAPSHOT.jar) will be in the "./target/scala-2.11" directory.

To publish **ScalaMS** to your local (Ivy) repository, simply type:

    sbt publishLocal
    
Then put this in your build.sbt file

    libraryDependencies += "com.github.workingDog" %%% "scalams" % "0.1-SNAPSHOT"

See also [CesiumMil](https://github.com/workingDog/CesiumMil) for a basic example of using 
[ScalaMS](https://github.com/workingDog/ScalaMS) and [CesiumScala](https://github.com/workingDog/CesiumScala)

## Status

work in progress

