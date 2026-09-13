package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            removeButton.setOnClickListener {
                rootLayout.removeView(binding.titleTextView)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putBoolean(BUNDLE_KEY, binding.rootLayout.childCount == 1)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val isTitleRemoved = savedInstanceState.getBoolean(BUNDLE_KEY)

        if (isTitleRemoved) {
            binding.rootLayout.removeView(binding.titleTextView)
        }
    }

    companion object {
        private const val BUNDLE_KEY = "BUNDLE_KEY"
    }
}