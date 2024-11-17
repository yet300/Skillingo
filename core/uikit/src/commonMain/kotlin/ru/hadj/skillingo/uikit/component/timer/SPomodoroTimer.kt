package ru.hadj.skillingo.uikit.component.timer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Pause
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.SkipNext
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.hadj.skillingo.uikit.component.button.SFilledIconButton
import ru.hadj.skillingo.uikit.component.button.SIconButton
import ru.hadj.skillingo.uikit.component.text.SEmojiText
import ru.hadj.skillingo.uikit.utils.formatTime

@Composable
fun SPomodoroTimer(
    state: TimerState,
    onStart: () -> Unit,
    onPause: () -> Unit,
    onReset: () -> Unit,
    onSkip: () -> Unit,
    modifier: Modifier = Modifier
) {
    val displayTime: String = formatTime(state.timeLeft / 60, state.timeLeft % 60)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SEmojiText(
            emoji = if (state.isWorkPhase) "🎯" else "☕️",
            text = if (state.isWorkPhase) "Focus" else "Break",
            secondText = displayTime
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SIconButton(
                onClick = onReset,
                icon = Icons.Rounded.Refresh,
                contentDescription = "Reset",
                modifier = Modifier.size(48.dp),
            )

            Spacer(modifier = Modifier.width(24.dp))

            SFilledIconButton(
                onClick = if (state.isRunning) onPause else onStart,
                icon = if (state.isRunning) Icons.Rounded.Pause else Icons.Rounded.PlayArrow,
                contentDescription = if (state.isRunning) "Pause" else "Start",
                modifier = Modifier.size(64.dp),
            )

            Spacer(modifier = Modifier.width(24.dp))

            SIconButton(
                onClick = onSkip,
                icon = Icons.Rounded.SkipNext,
                contentDescription = "Skip",
                modifier = Modifier.size(48.dp),
            )
        }
    }
}