package com.anies.bricks

import com.anies.bricks.FileState.*

/**
 * Created by anies on 6/13/17.
 */

fun State.file(init: FileGroup.() -> Unit) = initBrick(FileGroup(), init)

class FileGroup : NamedGroup<FileBrick>() {
    override fun createBrick(): FileBrick {
        return FileBrick()
    }

    /** Declare using the "path" copyOf "source" syntax. */
    infix fun String.copyOf(source: String) {
        val fileBrick = FileBrick()
        fileBrick.name = this
        fileBrick.copyOf(source)
        children.add(fileBrick)
    }
}

class FileBrick : NamedBrick() {
    var state = ANY
    var source = ""
    var mode = 0
    var owner = ""
    var group = ""

    fun copyOf(path: String) {
        state = COPIED
        source = path
    }

    fun templatedFrom(path: String) {
        state = TEMPLATED
        source = path
    }
}

enum class FileState {
    COPIED,
    TEMPLATED,
    ABSENT,
    PRESENT,
    ANY
}
