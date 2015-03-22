// '   Project: smath
//      Module: API / linear
// Description: Defines traits for matrix types.
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
//               Distributed under the MIT License (see included file LICENSE)
package biz.enef.smath.linear

import biz.enef.smath.ArrayX

/**
 * Common base trait for matrices.
 *
 * @tparam T
 */
trait Mat[T] {
  /**
   * Returns the number of rows in this matrix.
   */
  def rows: Int

  /**
   * Returns the number of columns in this matrix
   */
  def cols: Int

  /**
   * Returns the number of entries in this matrix (ie `rows*cols`)
   */
  def size: Int

  /**
   * Returns the value at the specified row and column (each starting at 0).
   *
   * @param row
   * @param col
   */
  def apply(row: Int, col: Int): T

  /**
   * Updates the value at the specified row and column.
   *
   * @param row
   * @param col
   * @param v
   */
  def update(row: Int, col: Int, v: T): Unit

  /**
   * Returns the result of multiplying this by the vector v.
   *
   * @param v the vector to operate on
   * @return this * v
   */
  def operate(v: Vec[T]): Vec[T]

  /**
   * Multiplies this by the specified vector and stores the result in the provided output vector.
   * @param v vector to be multiplied
   * @param out output vector
   */
  def operate(v: Vec[T], out: Vec[T]) : Unit

  /**
   * Multiplies this by the specified array and stores the result in the provided output array.
   * @param v array to be multiplied
   * @param out output array
   */
  def operate(v: ArrayX[T], out: ArrayX[T]) : Unit

  /**
   * Returns the result of multiplying `this` by `m`.
   *
   * @param m matrix to postmultiply by
   * @return `this * m`
   */
  def multiply(m: Mat[T]) : Mat[T]

  /**
   * Returns a clone of the current matrix.
   */
  def copy() : Mat[T]
}

/**
 * Matrix of doubles.
 */
trait MatD extends Mat[Double] {
  override def copy() : MatD

  override def operate(v: Vec[Double], out: Vec[Double]) : Unit = {
    assert(v.size == cols && out.size == rows)
    // TODO: optimize!
    for(i<-0 to rows-1) {
      var sum = 0.0
      for(j<-0 to cols-1) sum += this(i,j)*v(j)
      out(i) = sum
    }
  }

  override def operate(v: ArrayX[Double], out: ArrayX[Double]) : Unit = {
    assert(v.size == cols && out.size == rows)
    // TODO: optimize!
    for(i<-0 to rows-1) {
      var sum = 0.0
      for(j<-0 to cols-1) sum += this(i,j)*v(j)
      out(i) = sum
    }
  }


  //def analyzeEigenvalues() : EigenvalueAnalysis[Double]
}

object MatD {
  def apply(rows: Int, cols: Int)(implicit f: MatDFactory) : MatD = f.createMatD(rows,cols)
}

trait MatDFactory {
  def createMatD(rows: Int, cols: Int) : MatD
}
