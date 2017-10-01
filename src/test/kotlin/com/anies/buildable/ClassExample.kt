package com.anies.buildable

import kotlin.reflect.KClass

fun services(build: ServiceGroup<Service>.() -> Unit) : ServiceGroup<Service> {
    val serviceGroup = ServiceGroup<Service>()
    serviceGroup.build()
    return serviceGroup
}

class ServiceGroup<in T: Service> : Buildable() {
    fun provide(serviceType: KClass<out T>, build: ServiceBuildable.() -> Unit) {
        initBuildable(ServiceBuildable(), build)
    }
}

class ServiceBuildable : Buildable() {
    val options = mutableMapOf<String, String>()
}

/**
 * An example service interface
 */
interface Service {
    fun provideService()
}

class ServiceA : Service {
    override fun provideService() {}
}

class ServiceB : Service {
    override fun provideService() {}
}

fun main(args: Array<String>) {
    services {
        provide(ServiceA::class) {
            options += "foo" to "bar"
        }
        provide(ServiceB::class) {
            options += "biz" to "baz"
        }
    }
}
