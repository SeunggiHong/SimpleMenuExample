package com.example.simplemenuexample.models.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.simplemenuexample.models.data.UserData

@Dao
interface UserDao {

    @Insert
    fun insert(user: UserData)

    @Delete
    fun delete(user: UserData)

    @Update
    fun update(user: UserData)

    @Query("SELECT * FROM users")
    fun getAllUserList(): LiveData<List<UserData>>

}