package com.jct.renthabesha.core.di

import android.app.Application
import androidx.room.Room
import com.jct.renthabesha.core.data.local.ClothingDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideClothingDatabase(app: Application): ClothingDatabase {
        return Room.databaseBuilder(
            app,
            ClothingDatabase::class.java,
            "clothing_db"
        ).build()
    }
}
