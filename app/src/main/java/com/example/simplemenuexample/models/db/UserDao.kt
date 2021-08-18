package com.example.simplemenuexample.models.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.simplemenuexample.models.data.UserData

@Dao
interface UserDao {

    @Insert
    suspend fun insert(user: UserData)

    @Delete
    suspend fun delete(user: UserData)

    @Update
    suspend fun update(user: UserData)

    @Query("SELECT * FROM users")
    fun getAllUserList(): LiveData<List<UserData>>

}