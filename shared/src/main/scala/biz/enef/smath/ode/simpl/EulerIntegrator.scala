// '   Project: smath
//      Module: simpl / ode
// Description: Implementation of the Euler forward method for first-order ODE systems
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
//               Distributed under the MIT License (see included file LICENSE)
package biz.enef.smath.ode.simpl

import biz.enef.smath.linear.MatD
import biz.enef.smath.{ArrayX,ArrayXUtils}
import biz.enef.smath.ode._

/**
 * Implementation of a simple Euler integrator for first-order ODEs.
 */
class EulerIntegratorD(stepsize: Double) extends FirstOrderIntegratorD {

  override def integrate(odes: FirstOrderSystem[Double], t0: Double, y0: ArrayX[Double], t: Double, y: ArrayX[Double]): Double = odes match {
    case lsys: LinearFirstOrderSystemD => integrateLinearSystem(lsys,t0,y0,t,y)
    case _ => ???
  }

  private def integrateLinearSystem(odes: LinearFirstOrderSystemD, t0: Double, y0: ArrayX[Double], t: Double, y: ArrayX[Double]): Double = {
    import odes.M
    import ArrayXUtils.{createArrayD,axpy}
    assert( odes.dimension == y0.length && y0.length == y.length )

    // number of intermediate steps
    val nIntermediate = ((t-t0) / stepsize).floor.toInt

    val ytmp = createArrayD(odes.dimension)

    if(nIntermediate>=1) {
      M.operate(y0,ytmp)
      for(i<-0 to y.length-1)
        y(i) = y0(i) + stepsize*ytmp(i)

      for(i<-nIntermediate-1 to 1 by -1) {
        M.operate(y,ytmp)
        axpy(stepsize,ytmp,y)
      }
    }

    val trest = t - t0 - nIntermediate*stepsize
    if(trest > 0) {
      M.operate(y,ytmp)
      axpy(trest,ytmp,y)
    }

    t
  }

  override def integrate(odes: FirstOrderSystem[Double], t0: Double, y0: ArrayX[Double], t: Double) = odes match {
    case lsys: LinearFirstOrderSystemD => integrateLinearSystem(lsys,t0,y0,t)
    case _ => ???
  }

  private def integrateLinearSystem(odes: LinearFirstOrderSystemD, t0: Double,
                                    y0: ArrayX[Double], t: Double) = {
    import odes.M
    import ArrayXUtils.{createArrayD, combine}

    val sol = new ContinuousSolutionDImpl(odes.dimension)
    sol(t0) = y0

    // number of intermediate steps
    val nIntermediate = ((t-t0) / stepsize).floor.toInt

    val ytmp = createArrayD(odes.dimension)
    var yp = y0
    var tact = t0

    if(nIntermediate>=1) {
      for(i<-nIntermediate-1 to 1 by -1) {
        tact += stepsize
        var yn = createArrayD(odes.dimension)
        M.operate(yp,yn)
        combine(1,yp,stepsize,yn)
        sol(tact) = yn
        yp = yn
      }
    }

    val trest = t - t0 - nIntermediate*stepsize
    if(trest > 0) {
      var yn = createArrayD(odes.dimension)
      M.operate(yp,yn)
      combine(1,yp,trest,yn)
      sol(t) = yn
    }

    sol
  }
}
