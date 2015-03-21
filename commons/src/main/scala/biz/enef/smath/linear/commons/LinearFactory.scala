// '   Project: smath
//      Module: commons / linear
// Description: Provides the factory for the Apache commons implementation of smath.linear
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
package biz.enef.smath.linear.commons

import biz.enef.smath.linear.{VecDFactory, VecD, MatD, MatDFactory}
import biz.enef.smath.linear.MatDFactory

object LinearFactory extends VecDFactory with MatDFactory {
  override def createVecD(size: Int): VecD = new VecDCommons(size)

  override def createVecD(data: Array[Double], copyArray: Boolean): VecD = new VecDCommons(data,copyArray)

  override def createMatD(rows: Int, cols: Int): MatD = new MatDCommons(rows,cols)
}
