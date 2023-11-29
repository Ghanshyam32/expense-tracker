package com.ghanshyam.cashmate.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ghanshyam.cashmate.Models.Category
import com.ghanshyam.cashmate.databinding.SampleCategoryBinding


interface CategoryClickListener {
    fun onCategoryClicked(category: Category)
}

class CategoryAdapter(
    private val context: Context,
    private val categories: ArrayList<Category>,
    private val categoryClickListener: CategoryClickListener
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(val binding: SampleCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val clickedCategory = categories[position]
                    categoryClickListener.onCategoryClicked(clickedCategory)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = SampleCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CategoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category: Category = categories[position]
        holder.binding.categoryText.text = category.getCategoryName()
        holder.binding.categoryIcon.setImageResource(category.getCategoryImage())
        holder.itemView.setOnClickListener {
            categoryClickListener.onCategoryClicked(category)
        }
    }


}