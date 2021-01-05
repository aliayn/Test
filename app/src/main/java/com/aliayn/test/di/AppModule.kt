package com.aliayn.test.di

import android.content.Context
import com.aliayn.test.data.local.db.UserDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        UserDataBase.getInstance(appContext)

    @Singleton
    @Provides
    fun provideNoteDao(db: UserDataBase) = db.userDao()
}