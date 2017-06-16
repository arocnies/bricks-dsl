package com.anies.bricks

/**
 * Created by anies on 6/13/17.
 */

fun State.file(init: FileGroup.() -> Unit) = initBrick(FileGroup(), init)

class FileGroup : NamedGroup<FileBrick>() {
    override fun createBrick(): FileBrick {
        return FileBrick()
    }

    /** Declare using the "path" copyOf "source" syntax. */
    infix fun String.copyOf(path: String) {
        val fileBrick = FileBrick()
        fileBrick.name = this
        fileBrick.state = fileBrick.copyOf(path)
        children.add(fileBrick)
    }
}

class FileBrick : NamedBrick() {
    var state: FileState = any()
    var mode = 0
    var owner = ""
    var group = ""

    fun copyOf(path: String): FileState = FileState.CopyOf(path)
    fun templatedFrom(path: String): FileState = FileState.TemplatedFrom(path)
    fun present(): FileState = FileState.Present
    fun absent(): FileState = FileState.Absent
    fun any(): FileState = FileState.Any
}

sealed class FileState {
    data class CopyOf(val path: String) : FileState()
    data class TemplatedFrom(val path: String) : FileState()
    object Present : FileState()
    object Absent : FileState()
    object Any : FileState()
}
