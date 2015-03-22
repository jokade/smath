// '   Project: smath
//      Module: ode
// Description: Common interface for first-order ODE solvers
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
//               Distributed under the MIT License (see included file LICENSE)
package biz.enef.smath.ode

import biz.enef.smath.ArrayX

/**
 * Represents a first-order integrator for differential equations.
 */
trait FirstOrderIntegrator[T] {

  /**
   * Integrate the ODEs up to the given time.
   *
   * @param odes differential equations to integrate
   * @param t0 initial time
   * @param y0 initial value of the state vector at `t0`
   * @param t target time for the integration
   * @param y output array that will contain the solution on return
   */
  def integrate(odes: FirstOrderSystem[T],
                t0: T,
                y0: ArrayX[T],
                t: T,
                y: ArrayX[T]) : T

  /**
   * Integrates the ODEs up to the given time and returns a continuous solution object.
   *
   * @param odes
   * @param t0
   * @param y0
   * @param t
   * @return continuous solution
   *
   * @throws RuntimeException if continuous solution integration is not supported
   */
  def integrate(odes: FirstOrderSystem[T],
                t0: T,
                y0: ArrayX[T],
                t: T) : ContinuousSolution[T]
}

trait FirstOrderIntegratorD extends FirstOrderIntegrator[Double]
