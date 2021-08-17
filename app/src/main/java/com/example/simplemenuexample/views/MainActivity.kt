package com.example.simplemenuexample.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplemenuexample.R
import com.example.simplemenuexample.adapters.ClickInterface
import com.example.simplemenuexample.adapters.MenuAdapter
import com.example.simplemenuexample.databinding.ActivityMainBinding
import com.example.simplemenuexample.utils.Constants.TAG
import com.example.simplemenuexample.utils.Menu.MENU_POPUP_DIALOG_VIEW
import com.example.simplemenuexample.utils.Menu.MENU_RECYCLER_VIEW
import com.example.simplemenuexample.utils.Menu.MENU_SNACKBAR_VIEW
import com.example.simplemenuexample.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.log

class MainActivity : AppCompatActivity(), ClickInterface {
    private lateinit var binding: ActivityMainBinding
    private lateinit var menuAdapter: MenuAdapter

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = getString(R.string.app_name)
        initView()
        initAdapter()
        initViewModel()
        
        Log.d(TAG, "MainActivity - onCreate() called")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "MainActivity - onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MainActivity - onResume() called")
    }

    private fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
    }

    private fun initAdapter() {
        rc_main_view.layoutManager = LinearLayoutManager(this)
        menuAdapter = MenuAdapter(this)
        rc_main_view.adapter = menuAdapter
    }

    private fun initViewModel() {


    }

    override fun onMenuClicked(pos :Int) {
        when(pos) {
            MENU_RECYCLER_VIEW -> {
                val intent = Intent(this, UserRecyclerViewActivity::class.java)
                startActivity(intent)
            }
            MENU_SNACKBAR_VIEW -> {
                val intent = Intent(this, SnackBarActivity::class.java)
                startActivity(intent)
            }
            MENU_POPUP_DIALOG_VIEW -> {
                showDialog()
            }
        }

    }

    private fun showDialog() {
        val dialog = UserAddDialogFragment()
        dialog.isCancelable = false
        dialog.show(supportFragmentManager, "UserAddDialog")
    }

}