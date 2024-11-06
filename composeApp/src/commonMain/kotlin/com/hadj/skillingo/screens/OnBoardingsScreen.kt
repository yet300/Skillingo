package com.hadj.skillingo.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.hadj.skillingo.onboarding.OnBoardingComponent
import ru.hadj.skillingo.uikit.component.button.SButton

@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    component: OnBoardingComponent,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("OnBoardingScreen")

        SButton(
            text = "Next",
            onClick = component::onClick,
        )
    }

}