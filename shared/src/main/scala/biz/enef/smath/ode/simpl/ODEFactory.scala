// '   Project: smath
//      Module:
// Description: Factory object for simple Scala ODE solver implementations
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
//               Distributed under the MIT License (see included file LICENSE)
package biz.enef.smath.ode.simpl

import biz.enef.smath.ode.FirstOrderIntegratorD
import biz.enef.smath.ode.factory.FirstOrderIntegratorDFactory

object ODEFactory extends FirstOrderIntegratorDFactory {

  override def create(solver: String, stepsize: Double, config: Map[String, Any]): FirstOrderIntegratorD = solver match {
    case "euler" => createEulerIntegrator(stepsize)
    case "default" => createEulerIntegrator(stepsize)
    case _ => ???
  }

  private def createEulerIntegrator(stepsize: Double) = new EulerIntegratorD(stepsize)
}
