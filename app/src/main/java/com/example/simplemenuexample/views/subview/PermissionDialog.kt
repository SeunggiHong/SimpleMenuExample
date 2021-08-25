package com.example.simplemenuexample.views.subview

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.DialogFragment
import com.example.simplemenuexample.BuildConfig
import com.example.simplemenuexample.R
import java.lang.IllegalStateException

class PermissionDialog: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            builder.setView(inflater.inflate(R.layout.dialog_permission, null))
                .setNegativeButton(R.string.btn_cancel,
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()!!.cancel()
                    })
                .setPositiveButton(R.string.btn_go_settings,
                    DialogInterface.OnClickListener { dialog, id ->
                        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                            Uri.parse("package:" + BuildConfig.APPLICATION_ID))
                        this.startActivity(intent)
                        dismiss()
                    })

            builder.create()
        } ?: throw IllegalStateException("PermissionDialog cannot be null")
    }

}