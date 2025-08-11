package com.pogreb.shifttesttask.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): UserDataBase = Room.databaseBuilder(
        context,
        UserDataBase::class.java,
        "user_database"
    ).build()

    @Provides
    fun provideNoteDao(database: UserDataBase): UserDao = database.userDao()
}