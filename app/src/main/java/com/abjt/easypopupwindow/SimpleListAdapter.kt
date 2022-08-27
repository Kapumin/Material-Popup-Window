package com.abjt.easypopupwindow

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.abjt.easypopupwindow.databinding.ListItemViewDemoBinding

class SimpleListAdapter : RecyclerView.Adapter<SimpleListAdapter.ItemViewHolder>() {

    private val itemList: List<ItemDemo> = getData()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(
            ListItemViewDemoBinding.inflate(
                lazy { LayoutInflater.from(parent.context) }.value,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) = holder.bind(itemList[position])

    override fun getItemCount(): Int = itemList.size

    inner class ItemViewHolder(private val binding: ListItemViewDemoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.mtvItemLabel.setTextColor(
                ContextCompat.getColor(
                    itemView.context,
                    R.color.white
                )
            )
            binding.aivItemIcon.imageTintList =
                ColorStateList.valueOf(
                    ContextCompat.getColor(
                        itemView.context,
                        android.R.color.darker_gray
                    )
                )
        }

        fun bind(item: ItemDemo) {
            binding.apply {
                mtvItemLabel.text = item.label
                aivItemIcon.setImageResource(item.iconRes)
            }
        }
    }

    data class ItemDemo(var label: String, @DrawableRes var iconRes: Int)

    private fun getData(): List<ItemDemo> = mutableListOf<ItemDemo>().apply {
        add(ItemDemo("Bookmark Page", R.drawable.ic_round_bookmark_border_24))
        add(ItemDemo("Start Duo Meet", R.drawable.ic_round_duo_24))
    }
}