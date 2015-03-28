// '   Project: smath
//      Module: simpl / ode
// Description: Simple array-based implementation of trait ContinuousSolution
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
//               Distributed under the MIT License (see included file LICENSE)
package biz.enef.smath.ode.simpl

import biz.enef.smath.ArrayX
import biz.enef.smath.ArrayXUtils
import biz.enef.smath.ode.DatasetContinuousSolution

import scala.collection.mutable.ArrayBuffer

class ContinuousSolutionDImpl(val dimension: Int) extends DatasetContinuousSolution[Double] {

  private val _data = ArrayBuffer.empty[ArrayX[Double]]
  private val _steps = ArrayBuffer.empty[Double]

  override def tend = _steps.last
  override def tstart = _steps.head

  def update(t: Double, data: ArrayX[Double]) : Unit = {
    assert(t>tend && data.length==dimension)
  }

  override def datasets = _steps.zip(_data)

  override def apply(t: Double) = {
   ???
  }
}
