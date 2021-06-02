package com.example.azapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.azapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpClickListener()
        with(viewModel) {
            viewModelState.observe(this@MainActivity, ::onViewStateChanged)
        }
    }

    private fun onViewStateChanged(state: MainViewModel.State?) {
        when (state) {
            is MainViewModel.State.Content -> onContentChanged(state)
        }
    }

    private fun onContentChanged(content: MainViewModel.State.Content) {
        if (content.result) {
            binding.outputText.text = resources.getText(R.string.first_letter_in_range)
        } else {
            binding.outputText.text = resources.getText(R.string.first_letter_not_in_range)
        }
    }

    private fun setUpClickListener() {
        binding.runButton.setOnClickListener {
            viewModel.runCheck(getFirstChar(), getCapitalProtocol())
        }
    }

    private fun getFirstChar(): Char {
        return try {
            binding.textInput.text?.first() ?: ' '
        } catch (e: NoSuchElementException) {
            ' '
        }
    }

    private fun getCapitalProtocol(): RadioState {
        return when {
            binding.allCapsRadio.isChecked -> {
                RadioState.FIRST_IS_UPPER_CASE
            }
            binding.allLowerRadio.isChecked -> {
                RadioState.FIRST_IS_LOWER_CASE
            }
            else -> {
                RadioState.FIRST_IS_BOTH
            }
        }
    }
}