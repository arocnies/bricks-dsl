package com.anies.bricks

/**
 * Created by anies on 6/13/17.
 */

@DslMarker
annotation class BrickMarker

fun state(init: State.() -> Unit): State {
    val state = State()
    state.init()
    return state
}

@BrickMarker
abstract class Brick {
    val children = arrayListOf<Brick>()

    fun <T : Brick> initBrick(brick: T, init: T.() -> Unit): T {
        brick.init()
        children.add(brick)
        return brick
    }
}

class State : Brick()

abstract class NamedGroup<T : NamedBrick> : Brick() {
    abstract fun createBrick(): T

    /** Declare a brick using the "name" {...} syntax. */
    operator fun String.invoke(init: T.() -> Unit) {
        val brick = createBrick()
        brick.name = this
        initBrick(brick, init)
    }
}

abstract class NamedBrick constructor() : Brick() {
    var name: String = ""
}