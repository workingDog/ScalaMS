# Scala3dTiles a Cesium 3DTiles library in scala 

This library **Scala3dTiles** reads and writes [Cesium 3DTiles](http://cesiumjs.org/2015/08/10/Introducing-3D-Tiles/) 
and presents them as [Scala](http://www.scala-lang.org/) objects.

[Cesium](http://cesiumjs.org/) is a JavaScript library for creating 3D globes and 2D maps in a web browser without a plugin. 
It uses WebGL for hardware-accelerated graphics, and is cross-platform, cross-browser, 
and tuned for dynamic-data visualization. 

[Cesium 3DTiles](http://cesiumjs.org/2015/08/10/Introducing-3D-Tiles/) are an open specification for streaming 
massive heterogeneous 3D geospatial datasets. 

Typically **Scala3dTiles** is for server side application development.


## References
 
1) [Cesium](http://cesiumjs.org/)
 
2) [Cesium 3DTiles](https://github.com/AnalyticalGraphicsInc/3d-tiles)


## Dependencies

Using [Scala 2.11](http://www.scala-lang.org/) and the Play-JSON component 
of the [Play Framework](https://www.playframework.com/)

See also the build.sbt file.

## Installation and packaging

To compile and generate a jar file from the source:

    sbt package

The jar file (scala3dtiles_2.11-0.1-SNAPSHOT.jar) will be in the "./target/scala-2.11/" directory.


## Status

just starting, not functional yet

