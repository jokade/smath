// '   Project: smath
//      Module: test / linear
// Description: Common tests cases for vector implementations
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
//               Distributed under the MIT License (see included file LICENSE)
package biz.enef.smath.linear.test

import biz.enef.smath.linear.VecD
import biz.enef.smath.linear.factory.VecDFactory
import utest._

trait VecDBehaviour extends TestSuite {
  implicit def factory: VecDFactory

  val tests = TestSuite {
    'sizeApplyUpdate-{
      val v = VecD(3)
      assert( v.size == 3 )

      v(0) = 0.0
      v(2) = 2.0
      v(1) = 1.0

      assert( v(0) == 0.0, v(1) == 1.0, v(2) == 2.0 )
    }

    'initValue-{
      val v = VecD(3,-42.0)
      assert( v(0) == -42.0, v(1) == -42.0, v(2) == -42.0 )
    }
  }
}
