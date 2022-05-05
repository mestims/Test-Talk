package br.com.testclass.main

import br.com.testclass.R
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ColorMapperTest(
    private val colorName: String,
    private val expected: Int
) {

    private lateinit var colorMapper: ColorMapper

    companion object {
        @Parameterized.Parameters
        @JvmStatic
        fun data() =
            arrayListOf(
                arrayOf("white", R.color.white),
                arrayOf("black", R.color.black),
                arrayOf("teal_700", R.color.teal_700),
                arrayOf("teal_200", R.color.teal_200),
                arrayOf("purple_700", R.color.purple_700),
                arrayOf("purple_500", R.color.purple_500),
                arrayOf("purple_200", R.color.purple_200)
            ).toList()
    }

    @Before
    fun setup() {
        colorMapper = ColorMapper()
    }

    @Test
    fun `given a colorName, it should responde the correct color res`() {
        val result = colorMapper.getColor(colorName)

        assertEquals(expected, result)
    }
}