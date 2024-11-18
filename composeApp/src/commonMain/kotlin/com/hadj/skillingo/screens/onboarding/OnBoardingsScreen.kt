package com.hadj.skillingo.screens.onboarding

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hadj.skillingo.onboarding.OnBoardingComponent
import com.hadj.skillingo.screens.onboarding.composable.BottomNavigation
import com.hadj.skillingo.screens.onboarding.composable.PageIndicator
import com.hadj.skillingo.screens.onboarding.section.CloudStorageSections
import com.hadj.skillingo.screens.onboarding.section.FinishSections
import com.hadj.skillingo.screens.onboarding.section.PomodoroTimerSections
import com.hadj.skillingo.screens.onboarding.section.TaskGroupSections
import com.hadj.skillingo.screens.onboarding.section.ThemeSections
import com.hadj.skillingo.screens.onboarding.section.WelcomeSection
import ru.hadj.skillingo.uikit.component.scaffold.SScrollableScaffold

@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    component: OnBoardingComponent,
) {
    val pagerState = rememberPagerState(pageCount = { 6 })
    val scope = rememberCoroutineScope()
    SScrollableScaffold(
        modifier = modifier,
        title = {
            PageIndicator(pagerState)
        },
        bottomBar = {
            BottomNavigation(
                pagerState = pagerState,
                scope = scope,
                pageCount = pagerState.pageCount,
                component = component
            )
        },
        content = {
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                val maxWidth = minOf(maxWidth, 600.dp)
                Box(
                    modifier = Modifier
                        .widthIn(max = maxWidth),
                    contentAlignment = Alignment.Center
                ) {
                    HorizontalPager(
                        state = pagerState,
                        pageSpacing = 18.dp,
                        userScrollEnabled = false,
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        when (it) {
                            0 -> WelcomeSection()
                            1 -> ThemeSections(component = component)
                            2 -> PomodoroTimerSections()
                            3 -> TaskGroupSections()
                            4 -> CloudStorageSections()
                            5 -> FinishSections()
                        }
                    }
                }
            }
        }
    )
}

