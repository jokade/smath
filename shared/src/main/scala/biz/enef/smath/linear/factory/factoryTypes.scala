// '   Project: smath
//      Module: linear
// Description: Factory types for module 'linear'
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
//               Distributed under the MIT License (see included file LICENSE)
package biz.enef.smath.linear.factory

import biz.enef.smath.linear.{Vec, VecD, MatD}
import biz.enef.smath.ArrayX


trait MatDFactory {
  def createMatD(rows: Int, cols: Int) : MatD

  def createMatD(rows: Int, cols: Int, initValue: Double) : MatD
}

trait VecDFactory {
  def createVecD(size: Int) : VecD

  def createVecD(size: Int, initValue: Double) : VecD

  def createVecD(data: ArrayX[Double], copyArray: Boolean) : VecD

}
