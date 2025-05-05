package com.jct.renthabesha.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ClothingEntity::class],
    version = 1
)
abstract class ClothingDatabase: RoomDatabase(){
    abstract val clothingDao: ClothingDao
}