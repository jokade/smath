// '   Project: smath
//      Module: smath (JS)
// Description: Defines Scala/JS specific types
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
//               Distributed under the MIT License (see included file LICENSE)
package biz.enef

import scala.scalajs.js

package object smath {

  type ArrayX[T] = js.Array[T]
  type ArrayD = js.Array[Double]


}
