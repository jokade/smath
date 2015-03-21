// '   Project: smath
//      Module: API / ode
// Description: Traits for ODE solver factories
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
//               Distributed under the MIT License (see included file LICENSE)
package biz.enef.smath.ode.factory

import biz.enef.smath.ode.FirstOrderIntegratorD
import biz.enef.smath.ode.FirstOrderSystemD

/**
 * Interface to be implemented by all factories for first-order ODE system solvers.
 */
trait FirstOrderIntegratorDFactory {
  /**
   *
   * @param solver all implementations must provide a solver named "default"
   * @param stepsize
   * @param config
   * @return
   */
  def create(solver: String, stepsize: Double, config: Map[String,Any]) : FirstOrderIntegratorD
}
