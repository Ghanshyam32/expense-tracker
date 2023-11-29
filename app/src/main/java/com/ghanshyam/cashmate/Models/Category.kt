package com.ghanshyam.cashmate.Models

class Category(
    private var categoryName: String,
    private var categoryImage: Int,
) {

    // Getter methods
    fun getCategoryName(): String {
        return categoryName
    }


    fun getCategoryImage(): Int {
        return categoryImage
    }

    fun setCategoryName(name: String) {
        categoryName = name
    }

    fun setCategoryImage(image: Int) {
        categoryImage = image
    }
}
