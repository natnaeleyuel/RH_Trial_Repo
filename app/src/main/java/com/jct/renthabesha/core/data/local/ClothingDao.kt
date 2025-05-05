package com.jct.renthabesha.core.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface ClothingDao {

    @Upsert
    suspend fun upsertClothingEntity(clothingEntity: ClothingEntity)

    @Delete
    suspend fun deleteClothingEntity(clothingEntity: ClothingEntity)

    @Query("SELECT * FROM ClothingEntity")
    fun getAllClothingEntities(): Flow<List<ClothingEntity>>
}











