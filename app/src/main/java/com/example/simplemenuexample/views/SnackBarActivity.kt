package com.example.simplemenuexample.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simplemenuexample.R

class SnackBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snack_bar)
        title = resources.getString(R.string.title_snackbar_view)
    }
}