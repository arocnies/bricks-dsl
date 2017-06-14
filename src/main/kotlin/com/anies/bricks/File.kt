package com.anies.bricks

/**
 * Created by anies on 6/13/17.
 */

fun State.file(init: FileGroup.() -> Unit) = initBrick(FileGroup(), init)
fun State.file(path: String, init: FileBrick.() -> Unit) = initBrick(FileBrick(path), init)

class FileGroup: NamedGroup() {
    /**
     * Declare using the "path" copyOf "source" syntax.
     */
    infix fun String.copyOf(source: String) {
        val fileBrick = FileBrick(this)
        fileBrick.copyOf(source)
        children.add(fileBrick)
    }
}

class FileBrick(path: String) : NamedBrick(path) {
    fun copyOf(source: String) {
        TODO("Set this brick to be a copy of the source file")
    }
}
