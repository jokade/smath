// '   Project: smath
//      Module: simpl
// Description: Provides implicit smath factories for the simple Scala implementation
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
//               Distributed under the MIT License (see included file LICENSE)
package biz.enef.smath

/**
 * Implicit smath factories using the simple Scala implementations
 */
object Simpl {

  implicit val SimplLinearFactory = linear.simpl.LinearFactory
}
