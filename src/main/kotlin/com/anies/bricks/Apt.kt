package com.anies.bricks

import com.anies.bricks.PackageState.ANY

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
    var state = ANY
}

enum class PackageState {
    LATEST,
    ABSENT,
    PRESENT,
    BUILD_DEP,
    ANY
}
