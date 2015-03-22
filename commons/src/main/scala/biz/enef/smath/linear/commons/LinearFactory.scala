// '   Project: smath
//      Module: commons / linear
// Description: Provides the factory for the Apache commons implementation of smath.linear
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
package biz.enef.smath.linear.commons

import biz.enef.smath.linear.factory.{VecDFactory, MatDFactory}
import biz.enef.smath.linear.{VecD, MatD}

object LinearFactory extends VecDFactory with MatDFactory {
  override def createVecD(size: Int): VecD = new VecDCommons(size)

  override def createVecD(data: Array[Double], copyArray: Boolean): VecD = new VecDCommons(data,copyArray)

  override def createVecD(size: Int, initValue: Double): VecD = {
    val v = new VecDCommons(size)
    v.vec.set(initValue)
    v
  }

  override def createMatD(rows: Int, cols: Int): MatD = new MatDCommons(rows,cols)

  // TODO: optimize!
  override def createMatD(rows: Int, cols: Int, initValue: Double): MatD = {
    val m = new MatDCommons(rows,cols)
    for(i<-0 to rows-1;
        j<-0 to cols-1)
      m(i,j) = initValue
    m
  }

}
