package com.example.simplemenuexample.models.db

import android.content.Context
import android.service.autofill.UserData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserData::class], version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var instance: UserDatabase?= null

        fun getInstance(context: Context): UserDatabase? {
            if(instance == null) {
                synchronized(UserDatabase::class) {
                    instance = Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "user_db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return instance
        }
    }

}