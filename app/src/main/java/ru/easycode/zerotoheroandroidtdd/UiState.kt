package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {

    fun apply(
        linearLayout: LinearLayout,
        title: TextView,
        removeButton: Button
    )

    object Initial : UiState {

        override fun apply(
            linearLayout: LinearLayout,
            title: TextView,
            removeButton: Button
        ) {
            removeButton.isEnabled = true
        }
    }

    object ButtonClicked: UiState {
        override fun apply(
            linearLayout: LinearLayout,
            title: TextView,
            removeButton: Button
        ) {
            linearLayout.removeView(title)
            removeButton.isEnabled = false
        }
    }
}