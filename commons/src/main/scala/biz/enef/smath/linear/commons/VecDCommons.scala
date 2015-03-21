// '   Project: smath
//      Module: commons / linear
// Description: Implementation of VecD using Apache math-commons
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
package biz.enef.smath.linear.commons

import biz.enef.smath.linear.VecD
import org.apache.commons.math3.analysis.UnivariateFunction
import org.apache.commons.math3.linear.{ArrayRealVector, RealVector}

class VecDCommons(protected[commons] val vec: RealVector) extends VecD {

  def this(size: Int) = this(new ArrayRealVector(size))

  def this(data: Array[Double], copyArray: Boolean) = this(new ArrayRealVector(data,copyArray))

  @inline
  override def size: Int = vec.getDimension

  @inline
  override def apply(i: Int): Double = vec.getEntry(i)

  @inline
  override def update(i: Int, v: Double): Unit = vec.setEntry(i,v)

  @inline
  override def copy() = new VecDCommons(vec.copy())

  override def mapUpdate(f: (Double) => Double) = {
    vec.mapToSelf(f)
    this
  }

  override def map(f: (Double) => Double) = new VecDCommons(vec.map(f))

  /*override def axpy(a: Double, x: Vec[Double]) : VecD = x match {
    case x: ApacheVecD =>
      vec.combineToSelf(1.0,a,x.vec)
      this
    case _ => super.axpy(a,x)
  }*/

  override def toString() = vec.toString

  implicit private class Func(f: Double=>Double) extends UnivariateFunction {
    override def value(p1: Double): Double = f(p1)
  }
}
