package com.hadj.skillingo.screens.onboarding.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hadj.uikit.mokoResource.Res
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.compose.stringResource
import ru.hadj.skillingo.uikit.component.button.SIconButtonText
import ru.hadj.skillingo.uikit.component.card.SCard

data class CloudProvider(
    val name: String, val iconResId: ImageResource
)

@Composable
fun CloudStorageSections(modifier: Modifier = Modifier) {
    val providers = listOf(
        CloudProvider("Offline", Res.images.offline),
        CloudProvider("GitHub", Res.images.github),
        CloudProvider("Google Drive", Res.images.google_drive),
        CloudProvider("Apple iCloud", Res.images.icloud)
    )

    val selectedProvider = remember { mutableStateOf(providers[0]) }

    SCard(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                text = stringResource(Res.strings.cloud_storage_title),
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = stringResource(Res.strings.cloud_storage_description),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            providers.forEach { provider ->
                val isSelected = selectedProvider.value == provider
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    shape = MaterialTheme.shapes.medium,
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    )
                ) {
                    SIconButtonText(
                        text = provider.name,
                        selected = isSelected,
                        image = provider.iconResId,
                        onClick = {
                            selectedProvider.value = provider
                        }
                    )
                }
            }
        }
    }
}