// '   Project: smath
//      Module: API / ode
// Description: Interface for first-order ODE systems
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
//               Distributed under the MIT License (see included file LICENSE)
package biz.enef.smath.ode

import biz.enef.smath.linear.MatD
import biz.enef.smath.linear.MatD

/**
 * Describes a first-order ODE system to be solved numerically.
 */
trait FirstOrderSystem[T] {

  /**
   * Number of equations
   */
  def dimension: Int

  /**
   * Compute the current time derivative of the state vector.
   *
   * @param t current value of the independent time variable
   * @param y array containing the current value of the state vector
   * @param ydot output array that must contain the computed derivative on return
   */
  def computeDerivative(t: T, y: Array[T], ydot: Array[T]) : Unit
}

trait FirstOrderSystemD extends FirstOrderSystem[Double]

/**
 * A linear first-order ODE system:
 * <br/>
 * `ydot = M*y`
 * </br>
 * where `M` is a constant `n*n` matrix.
 *
 * @param M matrix with constant ODE coefficients
 */
case class LinearFirstOrderSystemD(M: MatD) extends FirstOrderSystemD {
  assert(M.rows==M.cols)

  override val dimension: Int = M.rows

  @inline
  override def computeDerivative(t: Double, y: Array[Double], ydot: Array[Double]): Unit = M.operate(y,ydot)
}
