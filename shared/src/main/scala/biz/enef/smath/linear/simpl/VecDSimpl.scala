// '   Project: smath
//      Module: simpl / linear
// Description: Contains the simple Scala implementation of VecD
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
//               Distributed under the MIT License (see included file LICENSE)
package biz.enef.smath.linear.simpl

import biz.enef.smath
import smath.ArrayXUtils
import biz.enef.smath.linear.{Vec, VecD}

class VecDSimpl(protected[simpl] val data: smath.ArrayX[Double]) extends VecD {

  def this(size: Int) = this(ArrayXUtils.createArrayD(size))

  @inline
  override def size: Int = data.length
  @inline
  override def apply(i: Int): Double = data(i)
  @inline
  override def update(i: Int, v: Double): Unit = data(i) = v

  override def copy(): VecD = {
    val c = ArrayXUtils.createArrayD(data.length)
    ArrayXUtils.copyArrayX(data,c)
    new VecDSimpl(c)
  }

  override def combine(a: Double, b: Double, y: Vec[Double]): Vec[Double] = y match {
    case y: VecDSimpl => combine(a,b,y)
    case _ => ???
  }

  def combine(a: Double, b: Double, y: VecDSimpl): Vec[Double] = {
    assert( y.size == this.size )
    val tgt = ArrayXUtils.createArrayD(size)
    for(i<-0 to size-1)
      tgt(i) = a*data(i) + y.data(i)
    new VecDSimpl(tgt)
  }

  override def toString() = data.mkString("[ "," "," ]")
}
