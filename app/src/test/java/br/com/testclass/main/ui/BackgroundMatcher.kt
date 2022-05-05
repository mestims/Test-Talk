package br.com.testclass.main.ui

import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.annotation.ColorInt
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.internal.util.Checks
import org.hamcrest.Description
import org.hamcrest.Matcher

fun withBackgroundColor(@ColorInt color: Int): Matcher<View> {
    Checks.checkNotNull(color)
    return object : BoundedMatcher<View, View>(View::class.java) {
        override fun describeTo(description: Description?) {
            description?.appendText("View background color to be $color")
        }

        override fun matchesSafely(item: View?): Boolean {
            val backgroundColor = item?.background as ColorDrawable
            return color == backgroundColor.color
        }

    }
}