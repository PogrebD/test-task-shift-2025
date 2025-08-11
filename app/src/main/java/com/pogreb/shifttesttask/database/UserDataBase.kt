package com.pogreb.shifttesttask.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pogreb.shifttesttask.database.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class UserDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
}