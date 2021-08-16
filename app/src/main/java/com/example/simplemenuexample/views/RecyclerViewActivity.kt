package com.example.simplemenuexample.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simplemenuexample.R

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        title = resources.getString(R.string.title_recycler_view)

    }

}