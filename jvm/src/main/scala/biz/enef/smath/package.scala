// '   Project: smath
//      Module: smath (JVM)
// Description: Defines Scala/JVM specific types ant utility functions
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
//               Distributed under the MIT License (see included file LICENSE)
package biz.enef

package object smath {

  type ArrayX[T] = Array[T]
  type ArrayD = Array[Double]

  def createArrayD(size: Int) : ArrayD = new ArrayD(size)

  def createArrayArrayD(rows: Int, cols: Int) : ArrayX[ArrayX[Double]] = {
    val m = new Array[Array[Double]](rows)
    for(i<-0 to rows-1)
      m(i) = new Array[Double](cols)
    m
  }

  // TODO: optimize?
  @inline
  def copyArrayX[T](src: ArrayX[T], tgt: ArrayX[T]) : Unit =
    for(i<-0 to src.length-1)
      tgt(i) = src(i)
}
