package com.jct.renthabesha.core.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.jct.renthabesha.core.di.AppModule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import org.junit.Assert.assertTrue

@HiltAndroidTest
@SmallTest
@UninstallModules(AppModule::class)
class ClothingDaoTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    lateinit var clothingDatabase: ClothingDatabase
    private lateinit var dao: ClothingDao

    @Before
    fun setUp() {
        hiltRule.inject()
        dao = clothingDatabase.clothingDao
    }

    @After
    fun tearDown() {
        clothingDatabase.close()
    }

    @Test
    fun getAllClothingFromEmptyDatabase_clothingListIsEmpty() = runTest {
        assertTrue(dao.getAllClothingEntities().first().isEmpty())
    }
}