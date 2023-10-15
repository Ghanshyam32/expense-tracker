package com.ghanshyam.cashmate.Models

class Category {

    private val categoryName: String = ""
    private val categoryImage: Int = 0


    class Category(name: String, image: Int) {
        private var categoryName: String = name
        private var categoryImage: Int = image

        // Getter methods
        fun getCategoryName(): String {
            return categoryName
        }

        fun getCategoryImage(): Int {
            return categoryImage
        }

        // Setter methods
        fun setCategoryName(name: String) {
            categoryName = name
        }

        fun setCategoryImage(image: Int) {
            categoryImage = image
        }
    }

}