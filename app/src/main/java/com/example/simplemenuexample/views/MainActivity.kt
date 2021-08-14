package com.example.simplemenuexample.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplemenuexample.R
import com.example.simplemenuexample.adapters.ClickInterface
import com.example.simplemenuexample.adapters.MenuAdapter
import com.example.simplemenuexample.databinding.ActivityMainBinding
import com.example.simplemenuexample.utils.Menu.MENU_RECYCLER_VIEW
import com.example.simplemenuexample.utils.Menu.MENU_SNACKBAR_VIEW
import com.example.simplemenuexample.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), ClickInterface {
    private lateinit var binding: ActivityMainBinding
    private lateinit var memberAdapter: MenuAdapter

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = getString(R.string.app_name)
        initView()
        initAdapter()
        initViewModel()
    }

    private fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
    }

    private fun initAdapter() {
        memberAdapter = MenuAdapter(mainViewModel.getAllMenuList(), this)

        rc_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = memberAdapter
        }
    }

    private fun initViewModel() {

    }

    override fun onMenuClicked(pos :Int) {
        when(pos) {
            MENU_RECYCLER_VIEW -> {
                val intent = Intent(this, RecyclerViewActivity::class.java)
                startActivity(intent)
            }
            MENU_SNACKBAR_VIEW -> {
                val intent = Intent(this, SnackBarActivity::class.java)
                startActivity(intent)
            }
        }

    }

}