package br.com.testclass.main

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class MainRepositoryTest {

    private lateinit var repository: MainRepository
    private val apiMock: Api = mockk()

    @Before
    fun setup() {
        repository = MainRepository(apiMock)
    }

    @Test
    fun `when getColorName is called, it should call the api`() {
        coEvery { apiMock.getColorNameFromApi() } returns successResponse

        runBlocking {
            repository.getColorName()
        }

        coVerify { apiMock.getColorNameFromApi() }

    }

}