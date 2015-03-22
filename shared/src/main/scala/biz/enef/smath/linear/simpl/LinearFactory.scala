// '   Project: smath
//      Module: simpl / linear
// Description: Provides the factory for the simple Scala implementation of smath.linear
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
//               Distributed under the MIT License (see included file LICENSE)
package biz.enef.smath.linear.simpl

import biz.enef.smath
import biz.enef.smath.ArrayX
import biz.enef.smath.linear.{MatD, MatDFactory, VecD, VecDFactory}

object LinearFactory extends VecDFactory with MatDFactory {

  override def createVecD(size: Int): VecD = new VecDSimpl(size)

  override def createVecD(data: ArrayX[Double], copyArray: Boolean): VecD =
    if(copyArray) {
      val c = smath.createArrayD(data.size)
      smath.copyArrayX(data,c)
      new VecDSimpl(c)
    }
    else
      new VecDSimpl(data)

  override def createMatD(rows: Int, cols: Int): MatD = new MatDSimpl(rows,cols)
}
