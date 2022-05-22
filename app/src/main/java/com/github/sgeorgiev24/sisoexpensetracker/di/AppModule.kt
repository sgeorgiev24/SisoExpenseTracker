package com.github.sgeorgiev24.sisoexpensetracker.di

import com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation.NavigationManager
import com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation.NavigationManagerImpl
import com.github.sgeorgiev24.sisoexpensetracker.util.coroutine.DefaultDispatcherProvider
import com.github.sgeorgiev24.sisoexpensetracker.util.coroutine.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideNavigationManager(): NavigationManager {
        return NavigationManagerImpl()
    }

    @Singleton
    @Provides
    fun provideDispatcher(): DispatcherProvider {
        return DefaultDispatcherProvider()
    }
}