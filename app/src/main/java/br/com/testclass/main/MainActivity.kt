package br.com.testclass.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.testclass.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupListeners()

        viewModel.fetchColor()
    }

    private fun setupListeners() {
        viewModel.state.observe(this) {
            when (it) {
                is MainState.Success -> {
                    findViewById<View>(R.id.root_main).setBackgroundColor(it.model.color)
                }
                is MainState.Error -> {
                    Toast.makeText(this, it.error, Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}