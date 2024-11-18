package com.hadj.skillingo.screens.onboarding.composable

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hadj.skillingo.onboarding.OnBoardingComponent
import com.hadj.uikit.mokoResource.Res
import dev.icerock.moko.resources.compose.stringResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ru.hadj.skillingo.uikit.component.button.SBottomBar
import ru.hadj.skillingo.uikit.component.button.SButton

@Composable
internal fun BottomNavigation(
    pagerState: PagerState,
    scope: CoroutineScope,
    component: OnBoardingComponent,
) {
    SBottomBar(
        content = {
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.BottomCenter
            ) {
                val maxWidth = minOf(maxWidth, 600.dp)
                SButton(
                    onClick = {
                        scope.launch {
                            component.nextPage()
                            pagerState.scrollToPage(component.model.value.currentPage)
                        }
                    },
                    modifier = Modifier.widthIn(max = maxWidth).fillMaxWidth(),
                    text = if (pagerState.currentPage == 5) stringResource(Res.strings.start) else
                        stringResource(Res.strings.continues),
                )
            }
        }
    )
}
