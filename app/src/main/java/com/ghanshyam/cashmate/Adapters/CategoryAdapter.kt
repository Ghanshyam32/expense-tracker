package com.ghanshyam.cashmate.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ghanshyam.cashmate.Models.Category
import com.ghanshyam.cashmate.R

class CategoryAdapter(
    private val context: Context,
    private val categories: ArrayList<Category>,
    private val categoryClickListener: CategoryClickListener
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    interface CategoryClickListener {
        fun onCategoryClicked(category: Category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.sample_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    inner class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Define views and initialize them here

        fun bind(category: Category) {
            // Bind data to views in the ViewHolder here
            itemView.setOnClickListener {
                categoryClickListener.onCategoryClicked(category)
            }
        }
    }
}
