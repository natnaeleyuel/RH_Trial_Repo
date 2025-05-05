package com.jct.renthabesha.core.data.mapper

import com.jct.renthabesha.core.data.local.ClothingEntity
import com.jct.renthabesha.core.domain.model.ClothingItem

fun ClothingEntity.toClothingEntityForInsert(
): ClothingEntity {
    return ClothingEntity(
        title = title,
        description = description,
        imageUrl = imageUrl,
        dateAdded = dateAdded
    )
}

fun ClothingItem.toClothingEntityForDelete(): ClothingEntity {
    return ClothingEntity(
        title = title,
        description = description,
        imageUrl = imageUrl,
        dateAdded = dateAdded,
        id = id
    )
}

fun ClothingEntity.toClothingItem(): ClothingItem {
    return ClothingItem(
        title = title,
        description = description,
        imageUrl = imageUrl,
        dateAdded = dateAdded,
        id = id ?: 0
    )
}













