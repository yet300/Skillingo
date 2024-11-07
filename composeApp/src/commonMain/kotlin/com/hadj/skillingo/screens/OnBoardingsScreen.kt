package com.hadj.skillingo.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hadj.skillingo.onboarding.OnBoardingComponent
import com.hadj.uikit.mokoResource.Res
import dev.icerock.moko.resources.compose.stringResource
import ru.hadj.skillingo.uikit.component.button.SButton
import ru.hadj.skillingo.uikit.component.text.SEmojiText

@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    component: OnBoardingComponent,
) {
    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(18.dp)
        ) {
            Text(
                stringResource(Res.strings.welcome),
                style = MaterialTheme.typography.displayLarge
            )
            Text(
                stringResource(Res.strings.welcome_text),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
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
        }
        SButton(
            text = stringResource(Res.strings.continues),
            onClick = component::onClick,
            modifier = Modifier.fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(18.dp)
                .heightIn(min = 64.dp)
        )
    }
}