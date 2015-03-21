// '   Project: smath
//      Module: commons / ode
// Description: Wraps a math-commons first-order integrator into a smath integrator
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
package biz.enef.smath.ode.commons

import biz.enef.smath.ode.{ContinuousSolution, FirstOrderSystem, FirstOrderIntegratorD}
import biz.enef.smath.ode.ContinuousSolution
import org.apache.commons.math3.ode.{ContinuousOutputModel, FirstOrderIntegrator}

class FirstOrderIntegratorWrapper(wrapped: FirstOrderIntegrator) extends FirstOrderIntegratorD {

  @inline
  override def integrate(odes: FirstOrderSystem[Double],
                         t0: Double,
                         y0: Array[Double],
                         t: Double,
                         y: Array[Double]): Double =
    wrapped.integrate(FirstOrderSystemWrapper(odes),t0,y0,t,y)

  override def integrate(odes: FirstOrderSystem[Double],
                         t0: Double,
                         y0: Array[Double],
                         t: Double): ContinuousSolution[Double] = {
    val stepHandler = new ContinuousOutputModel()
    wrapped.addStepHandler(stepHandler)
    integrate(odes,t0,y0,t,new Array[Double](odes.dimension))
    new FirstOrderContinuousSolution(stepHandler,odes.dimension)
  }
}
