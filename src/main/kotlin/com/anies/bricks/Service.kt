package com.anies.bricks

/**
 * Created by anies on 6/16/17.
 */

fun State.service(init: ServiceGroup.() -> Unit) = initBrick(ServiceGroup(), init)

class ServiceGroup : NamedGroup<ServiceBrick>() {
    override fun createBrick(): ServiceBrick = ServiceBrick()
}

class ServiceBrick : NamedBrick() {
    var state = any()
    var sleep = 0
    var enabled: Boolean? = null

    fun started() = ServiceState.STARTED
    fun stopped() = ServiceState.STOPPED
    fun restarted() = ServiceState.RESTARTED
    fun reloaded() = ServiceState.RELOADED
    fun any() = ServiceState.ANY
}

enum class ServiceState {
    STARTED,
    STOPPED,
    RESTARTED,
    RELOADED,
    ANY
}