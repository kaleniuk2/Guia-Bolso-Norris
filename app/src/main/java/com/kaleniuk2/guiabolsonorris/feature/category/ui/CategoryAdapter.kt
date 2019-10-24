package com.kaleniuk2.guiabolsonorris.feature.category.ui

import android.graphics.Color
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.kaleniuk2.guiabolsonorris.R
import com.kaleniuk2.guiabolsonorris.util.ColorHelper

class CategoryAdapter(
    var categories: List<String>,
    private val listener: (category: String) -> Unit
) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CategoryViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.category_item, p0, false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount() = categories.size

    override fun onBindViewHolder(p0: CategoryViewHolder, p1: Int) {
        p0.bind(categories[p1])
    }

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvCategory = itemView.findViewById<TextView>(R.id.category_item_text_view)

        fun bind(category: String) {
            tvCategory.text = category.capitalize()
            itemView.setOnClickListener {
                listener.invoke(category)
            }
        }
    }
}



