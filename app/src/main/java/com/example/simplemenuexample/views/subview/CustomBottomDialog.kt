package com.example.simplemenuexample.views.subview

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.DrawableContainer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.simplemenuexample.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CustomBottomDialog: BottomSheetDialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return inflater.inflate(R.layout.item_bottom_sheet, container)
    }


}