package ru.hadj.skillingo.uikit.component.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun SIconButtonText(
    modifier: Modifier = Modifier,
    text: String,
    selected: Boolean,
    image: ImageResource,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(image),
            contentDescription = image.toString(),
            modifier = Modifier.size(48.dp).padding(start = 8.dp),
            tint = MaterialTheme.colorScheme.onSurface
        )
        STextButton(
            text = text,
            selected = selected,
            onClick = onClick
        )
    }
}