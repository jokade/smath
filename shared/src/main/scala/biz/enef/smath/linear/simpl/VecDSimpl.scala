// '   Project: smath
//      Module: simpl / linear
// Description: Contains the simple Scala implementation of VecD
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
//               Distributed under the MIT License (see included file LICENSE)
package biz.enef.smath.linear.simpl

import biz.enef.smath
import biz.enef.smath.linear.VecD

class VecDSimpl(protected[simpl] val data: smath.ArrayX[Double]) extends VecD {

  def this(size: Int) = this(smath.createArrayD(size))

  @inline
  override def size: Int = data.length
  @inline
  override def apply(i: Int): Double = data(i)
  @inline
  override def update(i: Int, v: Double): Unit = data(i) = v

  override def copy(): VecD = {
    val c = smath.createArrayD(data.length)
    smath.copyArrayX(data,c)
    new VecDSimpl(c)
  }

  override def toString() = data.mkString("[ "," "," ]")
}
