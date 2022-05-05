package br.com.testclass.main.ui.main

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import br.com.testclass.R
import br.com.testclass.main.MainActivity
import br.com.testclass.main.ui.withBackgroundColor

class MainRobot {

    fun launch(block: MainActivity.() -> Unit) {
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.onActivity {
            block(it)
        }
    }

    fun checkBackgroundColor() {
        onView(withId(R.id.root_main)).check(matches(withBackgroundColor(R.color.teal_200)))
    }
}