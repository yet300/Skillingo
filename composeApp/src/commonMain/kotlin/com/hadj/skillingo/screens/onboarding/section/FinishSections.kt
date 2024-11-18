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


@Composable
fun FinishSections(modifier: Modifier = Modifier) {
    SCard(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                text = stringResource(Res.strings.finish_title),
                style = MaterialTheme.typography.displayLarge,
            )
            Text(
                text = stringResource(Res.strings.finish_description),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}