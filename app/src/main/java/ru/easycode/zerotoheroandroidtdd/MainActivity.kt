package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            changeButton.setOnClickListener {
                titleTextView.text = "I am an Android Developer!"
            }
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("TAG", "onRestoreInstanceState")
        binding.titleTextView.text = savedInstanceState.getString(TITLE_TV_KEY, DEFAULT_STRING)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        Log.d("TAG", "onSavedInstanceState")
        outState.putString(TITLE_TV_KEY, binding.titleTextView.text.toString())
    }

    companion object {
        private const val TITLE_TV_KEY= "titleTextViewKey"
        private const val DEFAULT_STRING = "Hello World!"
    }
}




