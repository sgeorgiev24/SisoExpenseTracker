package com.github.sgeorgiev24.sisoexpensetracker.di

import com.github.sgeorgiev24.sisoexpensetracker.data.datasource.FirebaseAuthDataSource
import com.github.sgeorgiev24.sisoexpensetracker.data.datasource.impl.FirebaseAuthDataSourceImpl
import com.github.sgeorgiev24.sisoexpensetracker.data.repository.AuthRepository
import com.github.sgeorgiev24.sisoexpensetracker.data.repository.impl.FirebaseAuthRepositoryImpl
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Singleton
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Singleton
    @Provides
    fun provideFirebaseAuthDataSource(
        firebaseAuth: FirebaseAuth
    ): FirebaseAuthDataSource {
        return FirebaseAuthDataSourceImpl(firebaseAuth)
    }

    @Singleton
    @Provides
    fun provideAuthRepository(
        firebaseAuthDataSource: FirebaseAuthDataSource
    ): AuthRepository {
        return FirebaseAuthRepositoryImpl(firebaseAuthDataSource)
    }
}
