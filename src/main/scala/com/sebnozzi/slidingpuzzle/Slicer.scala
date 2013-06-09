package com.sebnozzi.slidingpuzzle

import javafx.scene.image.Image
import javafx.scene.canvas.Canvas

class Slicer(val img: Image, val xAmount: Int, val yAmount: Int) {

  val sliceWidth = img.getWidth() / xAmount
  val sliceHeight = img.getHeight() / yAmount

  def sliceAt(x: Int, y: Int): Canvas = {
    val canvas = new Canvas(sliceWidth, sliceHeight)
    val grContext = canvas.getGraphicsContext2D()

    val (sourceX, sourceY) = coordinatesOfSliceAt(x, y)
    val (destX, destY) = (0, 0)

    grContext.drawImage(img,
      sourceX, sourceY, sliceWidth, sliceHeight,
      destX, destY, sliceWidth, sliceHeight)

    canvas
  }

  def slicePositions: List[(Int, Int)] = {
    (for (
      yPos <- 1 to yAmount;
      xPos <- 1 to xAmount
    ) yield (xPos, yPos)).toList
  }

  def coordinatesOfSliceAt(x: Int, y: Int): (Int, Int) = {
    val coordX = ((x - 1) * sliceWidth).toInt
    val coordY = ((y - 1) * sliceHeight).toInt
    (coordX, coordY)
  }

  def allSlices: Seq[Canvas] = {
    slicePositions.map{ case (xPos, yPos) => sliceAt(xPos, yPos) }
  }
  
}