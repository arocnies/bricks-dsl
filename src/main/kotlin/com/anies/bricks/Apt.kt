package com.anies.bricks

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

    fun latest(): PackageState = PackageState.LATEST
    fun present(): PackageState = PackageState.PRESENT
    fun absent(): PackageState = PackageState.ABSENT
    fun buildDep(): PackageState = PackageState.BUILD_DEP
    fun any(): PackageState = PackageState.ANY

}

enum class PackageState {
    LATEST,
    PRESENT,
    ABSENT,
    BUILD_DEP,
    ANY
}