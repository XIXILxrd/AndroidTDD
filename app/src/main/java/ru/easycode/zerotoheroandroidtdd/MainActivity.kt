package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val count: Count = Count.Base(step = 2, max = 4)
    private lateinit var state: UiState

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            incrementButton.setOnClickListener {
                state = count.increment(countTextView.text.toString())

                state.apply(countTextView, incrementButton)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putSerializable(BUNDLE_KEY, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            savedInstanceState.getSerializable(BUNDLE_KEY, UiState::class.java) as UiState
        } else {
            savedInstanceState.getSerializable(BUNDLE_KEY) as UiState
        }

        state.apply(binding.countTextView, binding.incrementButton)
    }

    companion object {
        private const val BUNDLE_KEY = "bundle_key"
    }
}