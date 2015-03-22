// '   Project: smath
//      Module: API / linear
// Description: Defines traits for vector types
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
//               Distributed under the MIT License (see included file LICENSE)
package biz.enef.smath.linear

import biz.enef.smath.ArrayX

/**
 * Common base trait for vectors.
 *
 * @tparam T
 */
trait Vec[T] {

  /**
   * Returns the element at position i (starting at index 0)
   */
  def apply(i: Int) : T

  /**
   * Updates the value at position i
   *
   * @param i index
   * @param v new value
   */
  def update(i: Int, v: T) : Unit

  /**
   * Returns the number of elements in this vector
   */
  def size : Int

  /**
   * Applies the specified operation to every element and updates the element with the result
   *
   * @param f
   * @return this
   */
  def mapUpdate(f: T=>T) : Vec[T]

  /**
   * Returns a new vector with the specified operation applied to every element
   *
   * @param f
   * @return a new vector
   */
  def map(f: T=>T) : Vec[T]

  /**
   * Returns a clone of the current vector.
   */
  def copy() : Vec[T]
}

/**
 * Vector of doubles.
 */
trait VecD extends Vec[Double] {

  override def copy() : VecD

  override def mapUpdate(f: (Double) => Double): VecD = {
    for(i <- 0 to size-1)
      this(i) = f(this(i))
    this
  }

  override def map(f: (Double) => Double): VecD = this.copy().mapUpdate(f)

}

object VecD {
  /**
   * Creates a new vector with the specified size.
   *
   * @param size
   * @param f
   * @return
   */
  def apply(size: Int)(implicit f: VecDFactory) : VecD = f.createVecD(size)

  /**
   * Creates a new vector from the specified data array. If `copyArray` is `true`, the
   * data array will be copied, otherwise the data array will be referenced.
   *
   * @param data data for the new vector
   * @param copyArray if true, the input array will be copied, otherwise it will be referenced
   * @param f
   */
  def apply(data: ArrayX[Double], copyArray: Boolean = false)(implicit f: VecDFactory) : VecD = f.createVecD(data,copyArray)
}

trait VecDFactory {
  def createVecD(size: Int) : VecD

  def createVecD(data: ArrayX[Double], copyArray: Boolean) : VecD
}
