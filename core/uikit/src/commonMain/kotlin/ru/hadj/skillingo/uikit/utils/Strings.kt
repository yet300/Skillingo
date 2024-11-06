package ru.hadj.skillingo.uikit.utils

import dev.icerock.moko.resources.StringResource

expect class Strings {
    fun get(id: StringResource, args: List<Any>): String

}