// '   Project: smath
//      Module: commons / ode
// Description:
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
package biz.enef.smath.ode.commons

import biz.enef.smath.ode.ContinuousSolution
import org.apache.commons.math3.ode.ContinuousOutputModel

class FirstOrderContinuousSolution(wrapped: ContinuousOutputModel, val dimension: Int) extends ContinuousSolution[Double] {

  override def tend: Double = wrapped.getFinalTime

  override def tstart: Double = wrapped.getInitialTime

  override def apply(t: Double): Array[Double] = {
    wrapped.setInterpolatedTime(t)
    wrapped.getInterpolatedState
  }
}
