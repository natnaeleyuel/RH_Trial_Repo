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
object TestAppModule {
    @Provides
    @Singleton
    fun provideClothingDatabase(app: Application): ClothingDatabase {
        return Room.inMemoryDatabaseBuilder(     // for test purpose
            app,
            ClothingDatabase::class.java
        ).build()
    }
}
