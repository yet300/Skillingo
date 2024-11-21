package com.hadj.skillingo.screens.onboarding.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.hadj.skillingo.onboarding.OnBoardingComponent
import com.hadj.uikit.mokoResource.Res
import dev.icerock.moko.resources.compose.stringResource
import ru.hadj.skillingo.uikit.component.card.SCard
import ru.hadj.skillingo.uikit.component.timer.SPomodoroTimer

@Composable
fun PomodoroTimerSections(
    modifier: Modifier = Modifier,
    component: OnBoardingComponent
) {
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
            DemoTimer(component = component)
        }
    }
}

@Composable
private fun DemoTimer(component: OnBoardingComponent) {
    val model by component.model.subscribeAsState()

    SPomodoroTimer(
        timeLeft = model.timeLeft,
        isRunning = model.isRunning,
        isWorkPhase = model.isWorkPhase,
        onStart = { component.startTimer() },
        onPause = { component.pauseTimer() },
        onReset = { component.resetTimer() },
        onSkip = { component.switchPhase() },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(
                if (!model.isWorkPhase) MaterialTheme.colorScheme.tertiaryContainer else MaterialTheme.colorScheme.surface,
                MaterialTheme.shapes.large
            )
    )
}

