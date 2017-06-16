package com.anies.bricks.apt

import com.anies.bricks.NamedBrick
import com.anies.bricks.NamedGroup
import com.anies.bricks.State

/**
 * Created by anies on 6/13/17.
 */

fun State.apt(init: AptGroup.() -> Unit) = initBrick(AptGroup(), init)

class AptGroup : NamedGroup<AptBrick>() {
    override fun createBrick(): AptBrick {
        return AptBrick()
    }
}

class AptBrick : NamedBrick() {
    var state: PackageState = any()

    fun latest(): PackageState = PackageState.Latest
    fun present(): PackageState = PackageState.Present
    fun absent(): PackageState = PackageState.Absent
    fun buildDep(): PackageState = PackageState.BuildDep
    fun any(): PackageState = PackageState.Any

}

sealed class PackageState {
    object Latest : PackageState()
    object Absent : PackageState()
    object Present : PackageState()
    object BuildDep : PackageState()
    object Any : PackageState()
}
