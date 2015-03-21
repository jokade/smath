// '   Project: smath
//      Module: commons / linear
// Description: Implementation of EigenvalueAnalysis using the Apache math-commons library
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
package biz.enef.smath.linear.commons

import biz.enef.smath.linear.{VecD, EigenvalueAnalysis}
import biz.enef.smath.linear.EigenvalueAnalysis
import org.apache.commons.math3.linear.EigenDecomposition

class EigenvalueAnalysisCommons(protected[commons] val decomp: EigenDecomposition) extends EigenvalueAnalysis[Double] {

  def this(mat: MatDCommons) = this(new EigenDecomposition(mat.mat))

  override def realEigenvalues: Seq[Double] = decomp.getRealEigenvalues

  override def getEigenvector(ind: Int): VecD = new VecDCommons(decomp.getEigenvector(ind))
}
