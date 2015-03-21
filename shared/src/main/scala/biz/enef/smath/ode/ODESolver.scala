// '   Project: smath
//      Module: API / ode
// Description: Factory object for ODE solvers
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
//               Distributed under the MIT License (see included file LICENSE)
package biz.enef.smath.ode

import biz.enef.smath.ode.factory.FirstOrderIntegratorDFactory

/**
 * Factory object for first-order ODE solvers with constant step size.
 */
object ODESolver {
  /**
   * Creates solvers for double-precision first-order ODE systems with constant step size.
   *
   * @param solver name of the solver to be used
   * @param stepsize integration step size
   * @param config additional solver configuration
   * @param f solver factory to be used
   */
  def apply(solver: String,
            stepsize: Double,
            config: Map[String,Any] = Map.empty[String,Any])
           (implicit f: FirstOrderIntegratorDFactory): FirstOrderIntegratorD = f.create(solver,stepsize,config)

}

