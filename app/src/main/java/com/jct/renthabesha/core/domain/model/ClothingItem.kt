package com.jct.renthabesha.core.domain.model

data class ClothingItem(
    var title: String,
    var description: String,
    var imageUrl: String,

    val dateAdded: Long,

    val id: Int = 0,
)