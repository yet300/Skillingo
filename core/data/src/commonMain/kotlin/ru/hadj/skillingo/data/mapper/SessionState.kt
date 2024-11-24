package ru.hadj.skillingo.data.mapper

import ru.hadj.database.model.SessionStateDBO
import ru.hadj.skillingo.domain.model.SessionState

fun SessionState.toDBO() = when (this) {
    SessionState.FOCUS -> SessionStateDBO.FOCUS
    SessionState.BREAK -> SessionStateDBO.SHORT_BREAK
    SessionState.LONG_BREAK -> SessionStateDBO.LONG_BREAK
}

fun SessionStateDBO.toDomain() = when (this) {
    SessionStateDBO.FOCUS -> SessionState.FOCUS
    SessionStateDBO.SHORT_BREAK -> SessionState.BREAK
    SessionStateDBO.LONG_BREAK -> SessionState.LONG_BREAK
}