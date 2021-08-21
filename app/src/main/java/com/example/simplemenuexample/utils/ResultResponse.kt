package com.example.simplemenuexample.utils

data class ResultResponse<out T>(val status: Status, val data: T?, val message: String?) {

    companion object {
        fun <T> success(data: T?): ResultResponse<T> {
            return ResultResponse(Status.SUCCESS, data, null)
        }

        fun <T> loading(data: T?): ResultResponse<T> {
            return ResultResponse(Status.LOADING, data, null)
        }

        fun <T> error(msg: String, data: T?): ResultResponse<T> {
            return ResultResponse(Status.ERROR, data, msg)
        }
    }

}