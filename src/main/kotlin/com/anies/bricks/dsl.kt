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

    internal fun <T: Brick> initBrick(brick: T, init: T.() -> Unit): T {
        brick.init()
        children.add(brick)
        return brick
    }
    val children = arrayListOf<Brick>()

}

class State: Brick()

abstract class NamedGroup : Brick() {
    /**
     * Declare a brick using the "name" {...} syntax.
     */
    operator fun String.invoke(init: FileBrick.() -> Unit) {
        initBrick(FileBrick(this), init)
    }
}

abstract class NamedBrick(name: String) : Brick() {
    init {
        TODO("Construct and return some useful node. Use the path param (path).")
    }
}