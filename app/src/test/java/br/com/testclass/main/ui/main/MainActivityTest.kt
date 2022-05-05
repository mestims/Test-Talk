package br.com.testclass.main.ui.main

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import br.com.testclass.main.MainViewModel
import br.com.testclass.main.successState
import br.com.testclass.main.ui.TestApplication
import io.mockk.every
import io.mockk.mockk
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(application = TestApplication::class)
class MainActivityTest {

    private fun robot(block: MainRobot.() -> Unit) = MainRobot().apply(block)

    private val viewModelMock: MainViewModel = mockk(relaxed = true)

    @Before
    fun setup() {
        startKoin {
            androidContext(InstrumentationRegistry.getInstrumentation().targetContext.applicationContext)
            loadKoinModules(
                module { viewModel { viewModelMock } }
            )
        }
    }

    @Test
    fun test1() {
        every { viewModelMock.fetchColor() } returns Unit

        robot {
            launch {
                handleState(successState)
                checkBackgroundColor()
            }
        }
    }

    @After
    fun tearDown() {
        stopKoin()
    }
}