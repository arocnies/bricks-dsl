package com.anies.buildable

@DslMarker
annotation class BuildableMarker

@BuildableMarker
open class Buildable {
    val children: MutableList<Buildable> = mutableListOf()

    fun <T : Buildable> initBuildable(buildable: T, build: T.() -> Unit) : T {
        buildable.build()
        children.add(buildable)
        return buildable
    }
}