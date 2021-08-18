package com.example.simplemenuexample.views

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplemenuexample.R
import com.example.simplemenuexample.adapters.interfaces.MenuClickInterface
import com.example.simplemenuexample.adapters.MenuAdapter
import com.example.simplemenuexample.databinding.ActivityMainBinding
import com.example.simplemenuexample.utils.Constants
import com.example.simplemenuexample.utils.Constants.TAG
import com.example.simplemenuexample.utils.Menu.MENU_POPUP_DIALOG_VIEW
import com.example.simplemenuexample.utils.Menu.MENU_RECYCLER_VIEW
import com.example.simplemenuexample.utils.Menu.MENU_SNACKBAR_VIEW
import com.example.simplemenuexample.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), MenuClickInterface {
    private lateinit var binding: ActivityMainBinding
    private lateinit var menuAdapter: MenuAdapter

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "MainActivity - onCreate() called")
        setupPermissions()
        title = getString(R.string.app_name)
        initView()
        initAdapter()
        initViewModel()
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

    private fun initViewModel() { }

    override fun onMenuClicked(pos :Int) {
        when(pos) {
            MENU_RECYCLER_VIEW -> {
                val intent = Intent(this, UserActivity::class.java)
                startActivity(intent)
            }
            MENU_SNACKBAR_VIEW -> {
                val intent = Intent(this, SnackBarActivity::class.java)
                startActivity(intent)
            }
            MENU_POPUP_DIALOG_VIEW -> {
                showUserAddDialog()
            }
        }

    }

    private fun showUserAddDialog() {
        val dialog = UserAddDialogFragment()
        dialog.isCancelable = false
        dialog.show(supportFragmentManager, "UserAddDialog")
    }

    private fun showPermissionDialog() {
        val dialog = PermissionDialog()
        dialog.show(supportFragmentManager, "Permission")
    }

    private fun setupPermissions() {
        val cameraPermission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
        val readPermission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)

        if (cameraPermission!= PackageManager.PERMISSION_GRANTED && readPermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                arrayOf(
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                ), Constants.REQUEST_CODE
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            Constants.REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission is granted. Continue the action or workflow
                    // in your app.
                } else {
                    showPermissionDialog()
                }
                return
            }
        }
    }

}