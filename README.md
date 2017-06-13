# Bricks-DSL
A DSL for describing configurations.

Descriptions are similar to Ansible. The state of a file, package, service, ... , etc is described instead of the statements.

Example:
```kotlin
apt("redis-server") {
    state=INSTALLED
}

file {
    "/etc/foo.conf" copyOf "../foo.conf"
    "/etc/bar.sh" copyOf "../bar.sh"
}
```

Example using single param descriptor:

```kotlin
apt("redis-server") {
    state=INSTALLED
}
```

Example using multi item descriptor:
```kotlin
apt {
    "redis-server" { state=INSTALLED }
    "nmap" { state=LATEST }
}
```

Descriptors:
- apt
- file
- service
- 