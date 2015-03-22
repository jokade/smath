// '   Project: smath
//      Module: smath (JS)
// Description: Defines Scala/JS specific types utility functions
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
//               Distributed under the MIT License (see included file LICENSE)
package biz.enef

import scala.scalajs.js

package object smath {

  type ArrayX[T] = js.Array[T]
  type ArrayD = js.Array[Double]

  def createArrayD(size: Int) : ArrayD = new ArrayD(size)

  def createArrayD(size: Int, initValue: Double) : ArrayD = {
    val v = js.Array[Double]()
    for(i<-0 to size-1)
      v(i) = initValue
    v
  }

  def createArrayArrayD(rows: Int, cols: Int) : ArrayX[ArrayX[Double]] = {
    val m = new js.Array[js.Array[Double]](rows)
    for(i<-0 to rows-1)
      m(i) = new ArrayD(cols)
    m
  }

  def createArrayArrayD(rows: Int, cols: Int, initValue: Double) : ArrayX[ArrayX[Double]] = {
    val m = js.Array[js.Array[Double]]()
    for(i<-0 to rows-1) {
      val v = js.Array[Double]()
      for(j<-0 to cols-1)
        v(j) = initValue
      m(i) = v
    }
    m
  }

  // TODO: optimize?
  @inline
  def copyArrayX[T](src: ArrayX[T], tgt: ArrayX[T]) : Unit =
    for(i<-0 to src.length-1)
      tgt(i) = src(i)
}
