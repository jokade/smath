// '   Project: smath
//      Module: simpl / linear
// Description: Contains the simple Scala implementation of MatD
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
//               Distributed under the MIT License (see included file LICENSE)
package biz.enef.smath.linear.simpl

import biz.enef.smath
import biz.enef.smath.ArrayX
import biz.enef.smath.linear.{Vec, Mat, MatD}

class MatDSimpl(protected[simpl] val data: ArrayX[ArrayX[Double]],
                 override val rows: Int,
                 override val cols: Int) extends MatD {

  def this(rows: Int, cols: Int) = this(smath.createArrayArrayD(rows,cols),rows,cols)

  @inline
  override def apply(row: Int, col: Int): Double = data(row)(col)
  @inline
  override def update(row: Int, col: Int, v: Double): Unit = data(row)(col) = v

  override val size: Int = rows*cols

  // TODO: optimize!
  override def multiply(m: Mat[Double]) : Mat[Double] = {
    assert(this.cols == m.rows)
    val tr = this.rows - 1
    val tc = m.cols - 1
    val nk = this.cols - 1
    val tgt = new MatDSimpl(this.rows,m.cols)
    for(i<-0 to tr;
        j<-0 to tc) {
      var sum = 0.0
      for(k<-0 to nk)
        sum += this(i,k) * m(k,j)
      tgt(i,j) = sum
    }
    tgt
  }

  override def operate(v: Vec[Double]): Vec[Double] = {
    val tgt = new VecDSimpl(this.rows)
    operate(v,tgt)
    tgt
  }

  override def copy(): MatD = {
    val tgt = new MatDSimpl(rows,cols)
    for(i<-0 to rows-1) {
      smath.copyArrayX(data(i),tgt.data(i))
    }
    tgt
  }

  override def toString() = data.map( row => row.mkString("[ "," "," ]")).mkString("[","\n","]")
}
