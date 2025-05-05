package com.jct.renthabesha.core.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ClothingEntity(

    val title: String,
    val description: String,
    val dateAdded: Long,
    val imageUrl: String,

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
)
