package com.anies.bricks

/**
 * Created by anies on 6/13/17.
 */

fun State.apt(init: AptGroup.() -> Unit) = initBrick(AptGroup(), init)
fun State.apt(name: String, init: AptBrick.() -> Unit) = initBrick(AptBrick(name), init)

class AptGroup: NamedGroup()

class AptBrick(name: String): NamedBrick(name)