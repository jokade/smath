// '   Project: smath
//      Module: API / linear
// Description: Defines the trait for the result object of an eigenvalue analysis
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
//               Distributed under the MIT License (see included file LICENSE)
package biz.enef.smath.linear

/**
 * Interface for the result of an eigenvalue analysis of a matrix.
 *
 * @see [[MatrixOps]]
 */
trait EigenvalueAnalysis[T] {

  def realEigenvalues : Seq[T]

  def getEigenvector(ind: Int) : Vec[T]
}
