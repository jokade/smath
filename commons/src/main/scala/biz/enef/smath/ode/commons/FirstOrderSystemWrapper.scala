// '   Project: smath
//      Module: commons / ode
// Description: Adapter between FirstOrderSystem and math-commons FirstOrderDifferentialEquations
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
//               Distributed under the MIT License (see included file LICENSE)
package biz.enef.smath.ode.commons

import biz.enef.smath.ode.FirstOrderSystem
import biz.enef.smath.ode.FirstOrderSystemD
import org.apache.commons.math3.ode.FirstOrderDifferentialEquations

case class FirstOrderSystemWrapper(wrapped: FirstOrderSystem[Double]) extends FirstOrderDifferentialEquations {
  @inline
  override def getDimension: Int = wrapped.dimension
  @inline
  override def computeDerivatives(t: Double, y: Array[Double], ydot: Array[Double]): Unit =
    wrapped.computeDerivative(t,y,ydot)
}
