package com.pogreb.shifttesttask.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.pogreb.shifttesttask.database.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: List<UserEntity>)

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<UserEntity>

    @Delete
    suspend fun delete(user: UserEntity)
}