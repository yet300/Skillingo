package com.hadj.skillingo.screens.onboarding.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hadj.uikit.mokoResource.Res
import dev.icerock.moko.resources.compose.stringResource
import ru.hadj.skillingo.uikit.component.card.SCard
import ru.hadj.skillingo.uikit.component.timer.SPomodoroTimer
import ru.hadj.skillingo.uikit.component.timer.TimerState
import ru.hadj.skillingo.uikit.component.timer.rememberTimerController

@Composable
fun PomodoroTimerSections(modifier: Modifier = Modifier) {
    SCard(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                text = stringResource(Res.strings.pomadoro_timer_title),
                style = MaterialTheme.typography.displayLarge,
            )
            Text(
                text = stringResource(Res.strings.pomadoro_timer_description),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            DemoTimer()
        }
    }
}

@Composable
private fun DemoTimer() {
    val timerController = rememberTimerController()
    val timeLeft by timerController.timeLeft.collectAsState()
    val isRunning by timerController.isRunning.collectAsState()
    val isWorkPhase by timerController.isWorkPhase.collectAsState()

    val timerState = TimerState(
        isWorkPhase = isWorkPhase,
        isRunning = isRunning,
        timeLeft = timeLeft
    )

    SPomodoroTimer(
        state = timerState,
        onStart = { timerController.startTimer() },
        onPause = { timerController.pauseTimer() },
        onReset = { timerController.resetTimer() },
        onSkip = { timerController.switchPhase() },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(
                if (!isWorkPhase) MaterialTheme.colorScheme.tertiaryContainer else MaterialTheme.colorScheme.surface,
                MaterialTheme.shapes.large
            )
    )
}


