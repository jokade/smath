// '   Project: smath
//      Module: commons
// Description: Provides implicit smath factories for the Apache math-commons implementation
//
// Copyright (c) 2015 Johannes Kastner <jokade@karchedon.de>
package biz.enef.smath

import biz.enef.smath.linear.commons.LinearFactory
import biz.enef.smath.ode.commons.ODEFactory

/**
 * Implicit smath factories using the Apache math-commons library
 */
object MathCommons {

  implicit val MathCommmonsLinearFactory = LinearFactory

  implicit val MathCommonsODEFactory = ODEFactory
}
