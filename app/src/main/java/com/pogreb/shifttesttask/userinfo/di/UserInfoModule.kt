package com.pogreb.shifttesttask.userinfo.di

import android.content.Context
import com.pogreb.shifttesttask.userinfo.data.converter.UserInfoConverter
import com.pogreb.shifttesttask.userinfo.data.repository.UserInfoRepositoryImpl
import com.pogreb.shifttesttask.userinfo.domain.repository.UserInfoRepository
import com.pogreb.shifttesttask.userinfo.presentation.converter.UserInfoViewStateConverter
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UserInfoModule {
    companion object {
        @Provides
        fun provideUserInfoConverter(): UserInfoConverter {
            return UserInfoConverter()
        }
        
        @Provides
        fun provideUserInfoViewStateConverter(@ApplicationContext context: Context): UserInfoViewStateConverter {
            return UserInfoViewStateConverter(context)
        }

    }

    @Binds
    fun bindUserInfoRepository(impl: UserInfoRepositoryImpl): UserInfoRepository
}