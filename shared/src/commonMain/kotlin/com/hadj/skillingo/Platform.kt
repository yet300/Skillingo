package com.hadj.skillingo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect abstract class PlatformContext