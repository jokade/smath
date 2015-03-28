// '   Project: smath
//      Module: smath (JVM)
// Description: Defines Scala/JVM specific array utility functions
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
//               Distributed under the MIT License (see included file LICENSE)
package biz.enef.smath

object ArrayXUtils {
  def createArrayB(size: Int) : ArrayX[Boolean] = new Array[Boolean](size)

  def createArrayD(size: Int) : ArrayD = new ArrayD(size)

  def createArrayD(size: Int, initValue: Double) : ArrayD = {
    val v = new ArrayD(size)
    for(i<-0 to size-1)
      v(i) = initValue
    v
  }

  def createArrayArrayD(rows: Int, cols: Int, createCols: Boolean = true) : ArrayX[ArrayX[Double]] = {
    val m = new Array[Array[Double]](rows)
    if(createCols) for(i<-0 to rows-1)
      m(i) = new Array[Double](cols)
    m
  }

  def createArrayArrayD(rows: Int, cols: Int, initValue: Double) : ArrayX[ArrayX[Double]] = {
    val m = new Array[Array[Double]](rows)
    for(i<-0 to rows-1) {
      val v = new Array[Double](cols)
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

  @inline
  def axpy(a: Double, x: ArrayD, y: ArrayD) : Unit =
    for(i<-0 to y.length-1)
      y(i) += a*x(i)

  @inline
  def combine(a: Double, x: ArrayD, b: Double, y: ArrayD) : Unit =
    for(i<-0 to y.length-1)
      y(i) = a*x(i) + b*y(i)

}
