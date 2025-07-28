package com.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.data.TranslationItem

@Composable
fun TranslationItemComposable(item: TranslationItem) {
    val horizontalArrangement = if (item.isUser) Arrangement.End else Arrangement.Start

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = horizontalArrangement
    ) {
        val speakerLabel = if (item.isUser) "You said:" else "Translation:"
        val backgroundColor = if (item.isUser) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant
        val alignment = if (item.isUser) Alignment.End else Alignment.Start

        Column(
            modifier = Modifier
                .fillMaxWidth(0.85f) // Don't let items take the full screen width
                .padding(vertical = 4.dp, horizontal = 8.dp)
                .background(color = backgroundColor, shape = MaterialTheme.shapes.medium)
                .padding(12.dp),
            horizontalAlignment = alignment,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = speakerLabel,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = item.text,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Preview(showBackground = true, name = "User Message")
@Composable
fun PreviewTranslationItemUser() {
    MaterialTheme {
        TranslationItemComposable(TranslationItem(text = "Hello, this is a test message to see how it looks.", isUser = true))
    }
}

@Preview(showBackground = true, name = "Model Message")
@Composable
fun PreviewTranslationItemModel() {
    MaterialTheme {
        TranslationItemComposable(TranslationItem(text = "This is the model's response, which should be aligned to the left.", isUser = false))
    }
}