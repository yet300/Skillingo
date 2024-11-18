package com.hadj.skillingo.screens.onboarding.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.hadj.skillingo.onboarding.OnBoardingComponent
import com.hadj.uikit.mokoResource.Res
import dev.icerock.moko.resources.compose.stringResource
import kotlinx.coroutines.launch
import ru.hadj.skillingo.domain.model.ThemeMode
import ru.hadj.skillingo.uikit.component.button.STextButton
import ru.hadj.skillingo.uikit.component.card.SCard

@Composable
fun ThemeSections(
    modifier: Modifier = Modifier,
    component: OnBoardingComponent
) {
    val model by component.model.subscribeAsState()
    val scope = rememberCoroutineScope()
    SCard(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                stringResource(Res.strings.change_theme),
                style = MaterialTheme.typography.displayLarge,
            )
            Text(
                stringResource(Res.strings.theme_text),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                STextButton(
                    text = stringResource(Res.strings.light_theme),
                    selected = model.currentThemeMode == ThemeMode.LIGHT
                ) {
                    scope.launch {
                        component.changeThemeMode(ThemeMode.LIGHT)
                    }
                }
                STextButton(
                    text = stringResource(Res.strings.dark_theme),
                    selected = model.currentThemeMode == ThemeMode.DARK
                ) {
                    scope.launch {
                        component.changeThemeMode(ThemeMode.DARK)
                    }
                }
                STextButton(
                    text = stringResource(Res.strings.system_theme),
                    selected = model.currentThemeMode == ThemeMode.SYSTEM
                ) {
                    scope.launch {
                        component.changeThemeMode(ThemeMode.SYSTEM)
                    }
                }
            }
        }
    }
}