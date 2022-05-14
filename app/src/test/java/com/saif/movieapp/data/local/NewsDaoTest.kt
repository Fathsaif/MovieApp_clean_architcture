package com.saif.movieapp.data.local
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class NewsDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: MoviesDatabase
    private lateinit var dao: MoviesDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            MoviesDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.moviesDao
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertShoppingItem() = runBlockingTest {
        val newsInfoEntity = MoviesInfoEntity(1,"description","title","image url","date")
        dao.insertNewsListings(listOf(newsInfoEntity))

        val allShoppingItems = dao.getMoviesListings()

        assertThat(allShoppingItems).contains(newsInfoEntity)
    }

    @Test
    fun deleteNews() = runBlockingTest {

        val newsInfoEntity = MoviesInfoEntity(1,"description","title","image url","date")
        dao.insertNewsListings(listOf(newsInfoEntity))

        dao.clearNewsListings()

        val allShoppingItems = dao.getMoviesListings()

        assertThat(allShoppingItems.size).isEqualTo(0)
    }
}