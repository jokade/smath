// '   Project: smath
//      Module: test / linear / simpl
// Description: Test cases for VecDSimpl
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
//               Distributed under the MIT License (see included file LICENSE)
package biz.enef.smath.linear.simpl.test

import biz.enef.smath.linear.simpl.LinearFactory
import biz.enef.smath.linear.test.VecDBehaviour

object VecDSimplTest extends VecDBehaviour {
  implicit def factory = LinearFactory
}
