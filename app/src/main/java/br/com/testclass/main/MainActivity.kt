package br.com.testclass.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.testclass.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupListeners()

        viewModel.fetchColor()
    }

    private fun setupListeners() {
        viewModel.state.observe(this, ::handleState)
    }

    fun handleState(state: MainState) {
        when (state) {
            is MainState.Success -> {
                findViewById<ConstraintLayout>(R.id.root_main).setBackgroundColor(state.model.color)
            }
            is MainState.Error -> {
                Toast.makeText(this, state.error, Toast.LENGTH_LONG).show()
            }
        }
    }
}