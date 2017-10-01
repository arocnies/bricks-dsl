package com.anies.buildable

/**
 * The function that starts the builder.
 * @param build An extension function with the top level Builder as the receiver.
 * This function constructs the outer AptGroup class and calls the build function.
 */
fun packages(build: AptGroup.() -> Unit) : AptGroup {
    val aptGroup = AptGroup()
    aptGroup.build()
    return aptGroup
}

/**
 * A Buildable which provides a String.invoke method to construct AptBuildable classes.
 * Put any functions that are provided at this scope inside the Buildable class.
 */
class AptGroup : Buildable() {
    operator fun String.invoke(build: AptBuildable.() -> Unit) {
        initBuildable(AptBuildable(this), build)
    }
}

/**
 * A class representing a package.
 * NOTE: This class inherits from Buildable so as to be marked with the @DslMarker annotation for the Buildable class.
 */
class AptBuildable(val name: String) : Buildable() {
    var state: PackageState = PackageState.ANY
}

enum class PackageState {
    LATEST,
    PRESENT,
    ABSENT,
    BUILD_DEP,
    ANY
}

fun main(args: Array<String>) {
    packages {
        "freeradius" {
            state = PackageState.LATEST
        }
        "nano" {
            state = PackageState.PRESENT
        }
    }
}