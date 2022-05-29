package com.github.sgeorgiev24.sisoexpensetracker.data.repository.impl

import com.github.sgeorgiev24.sisoexpensetracker.data.datasource.FirebaseAuthDataSource
import com.github.sgeorgiev24.sisoexpensetracker.data.repository.AuthRepository
import com.github.sgeorgiev24.sisoexpensetracker.util.Result
import com.github.sgeorgiev24.sisoexpensetracker.util.extension.safeFirebaseCall

class FirebaseAuthRepositoryImpl(
    private val firebaseAuthDataSource: FirebaseAuthDataSource
) : AuthRepository {

    override suspend fun isAuthenticated(): Boolean {
        val result = safeFirebaseCall {
            firebaseAuthDataSource.isAuthenticated()
        }
        return when (result) {
            is Result.Success -> {
                !result.data?.token.isNullOrBlank()
            }
            else -> false
        }
    }
}