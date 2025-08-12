package com.pogreb.shifttesttask.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.pogreb.shifttesttask.database.entity.UserEntity
import com.pogreb.shifttesttask.userlist.data.entity.UserItemModel

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: List<UserEntity>)

    @Query("SELECT id, name, picture, location, phone FROM users")
    fun getAllUsers(): List<UserItemModel>

    @Query("SELECT * FROM users WHERE id = :id")
    fun getUserById(id: String): UserEntity

    @Delete
    suspend fun delete(user: UserEntity)
}