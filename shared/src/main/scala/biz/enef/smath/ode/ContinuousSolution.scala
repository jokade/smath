// '   Project: smath
//      Module: API / ode
// Description: Interface for continuous output solution of an ODE system
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
//               Distributed under the MIT License (see included file LICENSE)
package biz.enef.smath.ode

import biz.enef.smath.ArrayX

trait ContinuousSolution[T] {

  /**
   * The size of the solution vectors
   */
  def dimension: Int

  /**
   * Lower boundary of the solution domain
   */
  def tstart: T

  /**
   * Upper boundary of the solution domain
   */
  def tend: T

  /**
   * Computes the (interpolated) value of the solution at the specified point.
   *
   * @param t
   */
  def apply(t: T) : ArrayX[T]
}

trait DatasetContinuousSolution[T] extends ContinuousSolution[T] {

  def datasets: Seq[(T,ArrayX[T])]
}
