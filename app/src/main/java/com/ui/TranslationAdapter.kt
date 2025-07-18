// app/src/main/java/com/bwctrans/ui/TranslationAdapter.kt
package com.bwctrans.ui

import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bwctrans.databinding.ItemTranslationBinding

// Use ListAdapter for better performance with DiffUtil
class TranslationAdapter : ListAdapter<Pair<String, Boolean>, TranslationAdapter.TranslationViewHolder>(TranslationDiffCallback()) {

    class TranslationViewHolder(val binding: ItemTranslationBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TranslationViewHolder {
        val binding = ItemTranslationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TranslationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TranslationViewHolder, position: Int) {
        // Because the layout is reversed, we still want to get items in the natural order from the list.
        val (text, isUser) = getItem(position)
        holder.binding.translationText.text = text
        holder.binding.speakerLabel.text = if (isUser) "You said:" else "Translation:"
        if (isUser) {
            holder.binding.messageContainer.gravity = Gravity.END
            holder.binding.translationText.gravity = Gravity.END
            holder.binding.speakerLabel.gravity = Gravity.END
        } else {
            holder.binding.messageContainer.gravity = Gravity.START
            holder.binding.translationText.gravity = Gravity.START
            holder.binding.speakerLabel.gravity = Gravity.START
        }
    }
}

class TranslationDiffCallback : DiffUtil.ItemCallback<Pair<String, Boolean>>() {
    override fun areItemsTheSame(oldItem: Pair<String, Boolean>, newItem: Pair<String, Boolean>): Boolean {
        // In this case, items don't have a unique ID, so we rely on content comparison.
        // For a more robust list, each item would have a unique ID.
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Pair<String, Boolean>, newItem: Pair<String, Boolean>): Boolean {
        return oldItem == newItem
    }
}