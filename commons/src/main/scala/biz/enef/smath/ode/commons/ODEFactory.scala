// '   Project: smath
//      Module: commons / ode
// Description: Factory object for math-commons ODE solvers
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
//               Distributed under the MIT License (see included file LICENSE)
package biz.enef.smath.ode.commons

import biz.enef.smath.ode.FirstOrderIntegratorD
import biz.enef.smath.ode.factory.FirstOrderIntegratorDFactory
import org.apache.commons.math3.ode.nonstiff.{ClassicalRungeKuttaIntegrator, MidpointIntegrator}

object ODEFactory extends FirstOrderIntegratorDFactory {

  override def create(solver: String, stepsize: Double, config: Map[String, Any]): FirstOrderIntegratorD = solver match {
    case "midpoint" => createMidepointIntegrator(stepsize)
    case "rk4"      => createRK4Integrator(stepsize)
    case "default"  => createRK4Integrator(stepsize)
  }

  private def createMidepointIntegrator(stepsize: Double) : FirstOrderIntegratorWrapper =
    new FirstOrderIntegratorWrapper(new MidpointIntegrator(stepsize))

  private def createRK4Integrator(stepsize: Double) =
    new FirstOrderIntegratorWrapper(new ClassicalRungeKuttaIntegrator(stepsize))
}
