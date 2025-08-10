package com.pogreb.shifttesttask.userlist.di

import android.content.Context
import com.pogreb.shifttesttask.userlist.data.UserListApi
import com.pogreb.shifttesttask.userlist.data.converter.UserItemConverter
import com.pogreb.shifttesttask.userlist.data.repository.UserListRepositoryImpl
import com.pogreb.shifttesttask.userlist.domain.repository.UserListRepository
import com.pogreb.shifttesttask.userlist.presentation.converter.UserItemViewStateConverter
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
interface UserListModule {
    companion object {
        @Provides
        fun provideUserListApi(retrofit: Retrofit): UserListApi {
            return retrofit.create(UserListApi::class.java)
        }

        @Provides
        fun provideUserItemConverter(): UserItemConverter {
            return UserItemConverter()
        }

        @Provides
        fun provideUserItemViewStateConverter(@ApplicationContext context: Context): UserItemViewStateConverter {
            return UserItemViewStateConverter(context)
        }
    }

    @Binds
    fun bindUserListRepository(impl: UserListRepositoryImpl): UserListRepository
}