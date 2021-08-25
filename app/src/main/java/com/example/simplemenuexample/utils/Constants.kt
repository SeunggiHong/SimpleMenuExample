package com.example.simplemenuexample.utils

object Constants {
    const val TAG: String = "logMsg"

    const val REQUEST_CODE: Int = 101
    const val SNACK_REQUEST: Int = 301
    const val SNACK_RETRY: Int = 302
}

object Menu {
    const val MENU_RECYCLER_VIEW = 0
    const val MENU_SNACKBAR_VIEW = 1
    const val MENU_POPUP_DIALOG_VIEW = 2
    const val MENU_BOTTOM_SHEET_DIALOG = 3
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}