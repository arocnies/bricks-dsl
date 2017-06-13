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

    protected fun <T: Brick> initBrick(brick: T, init: T.() -> Unit): T {
        brick.init()
        children.add(brick)
        return brick
    }
    val children = arrayListOf<Brick>()

}

class State: Brick() {
    fun file(init: FileBrick.() -> Unit) = initBrick(FileBrick(), init)

    fun apt(init: AptBrick.() -> Unit) = initBrick(AptBrick(), init)
}

class FileBrick: Brick()

class AptBrick: Brick()
