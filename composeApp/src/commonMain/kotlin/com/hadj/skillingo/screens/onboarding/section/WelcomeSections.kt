package com.hadj.skillingo.screens.onboarding.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hadj.uikit.mokoResource.Res
import dev.icerock.moko.resources.compose.stringResource
import ru.hadj.skillingo.uikit.component.card.SCard
import ru.hadj.skillingo.uikit.component.text.SEmojiText

@Composable
fun WelcomeSection(modifier: Modifier = Modifier) {
    SCard(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                stringResource(Res.strings.welcome),
                style = MaterialTheme.typography.displayLarge,
            )
            Text(
                stringResource(Res.strings.welcome_text),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            SEmojiText(
                emoji = "\uD83D\uDD25",
                text = stringResource(Res.strings.shock_mode_title),
                secondText = stringResource(Res.strings.shock_mode_description)
            )
            SEmojiText(
                emoji = "\uD83D\uDE80",
                text = stringResource(Res.strings.endless_tasks_title),
                secondText = stringResource(Res.strings.endless_tasks_description)
            )
            SEmojiText(
                emoji = "\uD83C\uDF45",
                text = stringResource(Res.strings.pomadoro_timer_title),
                secondText = stringResource(Res.strings.pomadoro_timer_description),
            )
            SEmojiText(
                emoji = "\uD83C\uDF0F",
                text = stringResource(Res.strings.etc),
                secondText = stringResource(Res.strings.etc_description),
            )
        }
    }
}