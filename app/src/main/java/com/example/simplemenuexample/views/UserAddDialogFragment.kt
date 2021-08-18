package com.example.simplemenuexample.views

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Point
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.example.simplemenuexample.R
import com.example.simplemenuexample.databinding.DialogUserAddBinding
import com.example.simplemenuexample.models.data.UserData
import com.example.simplemenuexample.utils.Constants

import com.example.simplemenuexample.utils.Constants.TAG
import com.example.simplemenuexample.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class UserAddDialogFragment : DialogFragment() {
    private var _binding: DialogUserAddBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModel()
    private val userData: UserData? = null
    private var imageUri: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "UserAddDialogFragment - onCreate() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "UserAddDialogFragment - onResume() called")
        setWidthPercent(85)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogUserAddBinding.inflate(inflater, container, false)
        Log.d(TAG, "UserAddDialogFragment - onCreateView() called")

        val view = binding.root
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding.btnClose.setOnClickListener {
            dismiss()
        }

        binding.ivProfile.setOnClickListener {
            openGalleryForImage()
        }

        binding.btnSave.setOnClickListener {
            saveUser()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "UserAddDialogFragment - onDestroyView() called")
        _binding = null
    }

    private fun DialogFragment.setWidthPercent(percentage: Int) {
        val percent = percentage.toFloat() / 100
        val dm = Resources.getSystem().displayMetrics
        val rect = dm.run { Rect(0, 0, widthPixels, heightPixels) }
        val percentWidth = rect.width() * percent
        dialog?.window?.setLayout(percentWidth.toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    private fun saveUser() {
        if(checkEditText()) {
            val id = if(userData != null) userData?.id else null
            val userData = UserData(
                id = id,
                userName    = binding.etName.toString(),
                userEmail   = binding.etEmail.toString().trim(),
                userPhone   = binding.etPhone.toString().trim(),
                userContent = binding.etContent.toString().trim(),
                userImage   = imageUri
            )
            viewModel.insertUser(userData)

        } else {
          Toast.makeText(context, R.string.toast_user_add_no_data, Toast.LENGTH_SHORT).show()
        }
    }

    private fun openGalleryForImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        activityLauncher.launch(intent)
    }

    private val activityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data!!.data
            Log.d(TAG, "UserAddDialogFragment activityLauncher data : {$data}")
            if (data != null) {
                Glide.with(this)
                    .load(data)
                    .placeholder(R.drawable.ic_default_user)
                    .into(binding.ivProfile)
                imageUri = data.toString()
            } else {
                Toast.makeText(context, R.string.toast_user_add_no_pic, Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun checkEditText(): Boolean {
        if(imageUri == null) {
            binding.ivProfile.requestFocus()
            return false
        }

        if(binding.etName.text.isNullOrEmpty()) {
            binding.tlName.error = resources.getString(R.string.hint_user_add_no_data)
            binding.etName.requestFocus()
            return false
        }

        if(binding.etEmail.text.isNullOrEmpty()) {
            binding.tlEmail.error = resources.getString(R.string.hint_user_add_no_data)
            binding.etEmail.requestFocus()
            return false
        }

        if(binding.etPhone.text.isNullOrEmpty()) {
            binding.tlPhone.error = resources.getString(R.string.hint_user_add_no_data)
            binding.etPhone.requestFocus()
            return false
        }

        if(binding.etContent.text.isNullOrEmpty()) {
            binding.tlContent.error = resources.getString(R.string.hint_user_add_no_data)
            binding.etContent.requestFocus()
            return false
        }

        return true
    }

}