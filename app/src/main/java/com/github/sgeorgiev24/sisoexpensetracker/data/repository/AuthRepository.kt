package com.github.sgeorgiev24.sisoexpensetracker.data.repository

interface AuthRepository {
    suspend fun isAuthenticated(): Boolean
}