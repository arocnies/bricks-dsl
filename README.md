# Buildable - A Kotlin 'Groovy-style' builder Utility
An utility and examples for creating Kotlin DSLs and Groovy-style builders in Kotlin.

## The `Buildable` Class
The `Buildable` class is a single scope of your builder.
It is responsible for keeping track of it's children `Buildables`.

By extending the `Buildable` class you can add functions to create your own DSL and populate 
the `Buildable` tree with your own classes.

## Example Use Cases

Example from `src/test/kotlin/.../GroupExample.kt`
```kotlin
packages {
    "freeradius" {
        state = PackageState.LATEST
    }
    "nano" {
        state = PackageState.PRESENT
    }
}
```

Example from `src/test/kotlin/.../ClassExample.kt`
```kotlin
 services {
    provide(ServiceA::class) {
        options += "foo" to "bar"
    }
    provide(ServiceB::class) {
        options += "biz" to "baz"
    }
}
```

Example using multi item descriptor:
```kotlin
apt {
    "redis-server" { state=INSTALLED }
    "nmap" { state=LATEST }
}
```