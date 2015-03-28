// '   Project: smath
//      Module: smath
// Description: Factory object for double-precision arrays
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
//               Distributed under the MIT License (see included file LICENSE)
package biz.enef.smath

object ArrayD {
  def apply(n: Int) : ArrayX[Double] = ArrayXUtils.createArrayD(n)

  def apply(n: Int, initValue: Double) : ArrayX[Double] = ArrayXUtils.createArrayD(n,initValue)
}
