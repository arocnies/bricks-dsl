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
    fun apt(init: AptBrick.() -> Unit) = initBrick(AptBrick(), init)

    fun file(init: FileGroup.() -> Unit) = initBrick(FileGroup(), init)
    fun file(name: String, init: FileBrick.() -> Unit) = initBrick(FileBrick(), init)
}

class FileBrick: Brick {
    constructor(): super()
    constructor(path: String): super() {
        TODO("Construct and return some useful node. Use the path param (path).")
    }

    fun copyOf(source: String) {
        TODO("Set this brick to be a copy of the source file")
    }
}

class FileGroup: Brick() {
    /**
     * Declare a FileBrick using the "path" copyOf "source" syntax.
     */
    infix fun String.copyOf(source: String) {
        val fileBrick = FileBrick(this)
        fileBrick.copyOf(source)
        children.add(fileBrick)
    }

    /**
     * Declare a FileBrick using the "path" {...} syntax.
     */
    operator fun String.invoke(init: FileBrick.() -> Unit) {
        initBrick(FileBrick(this), init)
    }
}


class AptBrick: Brick()
