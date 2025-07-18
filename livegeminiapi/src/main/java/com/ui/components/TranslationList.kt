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