package com.sebnozzi.slidingpuzzle

import javafx.scene.image.Image

class Slicer(val img: Image) {

  def cut(xAmount: Int, yAmount: Int): Seq[Image] = {
    val sliceWidth = img.getWidth() / xAmount
    val sliceHeight = img.getHeight() / yAmount
    ???
  }
}