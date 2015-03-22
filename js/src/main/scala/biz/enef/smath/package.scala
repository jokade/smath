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

  def createArrayArrayD(rows: Int, cols: Int) : ArrayX[ArrayX[Double]] = js.Array[js.Array[Double]]()

  // TODO: optimize?
  @inline
  def copyArrayX[T](src: ArrayX[T], tgt: ArrayX[T]) : Unit =
    for(i<-0 to src.length-1)
      tgt(i) = src(i)
}
