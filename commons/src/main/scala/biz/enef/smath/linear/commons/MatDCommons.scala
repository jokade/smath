// '   Project: smath
//      Module: commons / linear
// Description: Implementation of MatD using Apache math-commons
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
package biz.enef.smath.linear.commons

import biz.enef.smath.linear.{Vec, Mat, MatD}
import biz.enef.smath.linear.MatD
import org.apache.commons.math3.linear.{Array2DRowRealMatrix, RealMatrix}

class MatDCommons(protected[commons] val mat: RealMatrix) extends MatD {

  def this(rows: Int, cols: Int) = this(new Array2DRowRealMatrix(rows,cols))

  override def copy(): MatD = new MatDCommons( mat.copy() )

  @inline
  override def rows: Int = mat.getRowDimension

  @inline
  override def cols: Int = mat.getColumnDimension

  @inline
  override def size: Int = rows*cols

  @inline
  override def apply(row: Int, col: Int): Double = mat.getEntry(row,col)

  @inline
  override def update(row: Int, col: Int, v: Double): Unit = mat.setEntry(row,col,v)

  override def operate(v: Vec[Double]): Vec[Double] = v match {
    case v: VecDCommons => operate(v)
    case _ => ???
  }

  @inline
  def operate(v: VecDCommons) : VecDCommons = new VecDCommons(mat.operate(v.vec))

  override def multiply(m: Mat[Double]): Mat[Double] = m match {
    case m: MatDCommons => multiply(m)
    case _ => ???
  }

  @inline
  def multiply(m: MatDCommons) : MatDCommons = new MatDCommons(mat.multiply(m.mat))

  //override def analyzeEigenvalues() : EigenvalueAnalysisCommons = new EigenvalueAnalysisCommons(this)

  override def toString() = mat.toString
}
