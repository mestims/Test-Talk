package br.com.testclass.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.testclass.R
import br.com.testclass.main.rule.MainCoroutineRule
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MainViewModelTest {

    @get:Rule
    var executorRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutineRule = MainCoroutineRule()


    private lateinit var viewModel: MainViewModel
    private val repoMock: MainRepository = mockk()
    private val mapperMock: ColorMapper = mockk()
    private val observer: Observer<MainState> = mockk(relaxed = true)

    @Before
    fun setup() {
        viewModel = MainViewModel(repoMock, mapperMock)
        viewModel.state.observeForever(observer)
    }

    @Test
    fun `when fetchColor is called and the api returns success, it should send the correct state`() {
        coEvery { repoMock.getColorName() } returns successResponse
        every { mapperMock.getColor(any()) } returns R.color.teal_200

        viewModel.fetchColor()

        verify {
            observer.onChanged(MainState.Success(MainModel(R.color.teal_200)))
        }
    }

    @Test
    fun `when fetchColor is called and the api returns error, it should send the correct state`() {
        coEvery { repoMock.getColorName() } returns errorResponse
        every { mapperMock.getColor(any()) } returns R.color.teal_200

        viewModel.fetchColor()

        verify {
            observer.onChanged(MainState.Error("api error"))
        }
    }
}