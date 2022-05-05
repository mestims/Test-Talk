package br.com.testclass.main

import br.com.testclass.R

class ColorMapper {

    fun getColor(colorName: String?) =
        when (colorName) {
            "white" -> R.color.white
            "black" -> R.color.black
            "teal_700" -> R.color.teal_700
            "teal_200" -> R.color.teal_200
            "purple_700" -> R.color.purple_700
            "purple_500" -> R.color.purple_500
            "purple_200" -> R.color.purple_200
            else -> throw RuntimeException("color not found!")
        }
}