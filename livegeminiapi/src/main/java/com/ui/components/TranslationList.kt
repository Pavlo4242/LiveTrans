import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

package com.livegemini.ui.components

@Composable
fun TranslationList(
    translations: List<Pair<String, Boolean>>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        reverseLayout = true
    ) {
        items(translations) { (text, isUser) ->
            TranslationItem(text, isUser)
        }
    }
}

@Composable
private fun TranslationItem(text: String, isUser: Boolean) {
    Card {
        Text(
            text = text,
            color = if (isUser) Color.Blue else Color.Green
        )
    }
}