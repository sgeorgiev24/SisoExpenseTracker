package com.github.sgeorgiev24.sisoexpensetracker.data.datasource

import com.google.firebase.auth.GetTokenResult

interface FirebaseAuthDataSource {
    suspend fun isAuthenticated(): GetTokenResult?
}