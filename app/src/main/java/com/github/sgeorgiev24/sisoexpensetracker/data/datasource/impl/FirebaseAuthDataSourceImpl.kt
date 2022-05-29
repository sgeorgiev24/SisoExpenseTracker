package com.github.sgeorgiev24.sisoexpensetracker.data.datasource.impl

import com.github.sgeorgiev24.sisoexpensetracker.data.datasource.FirebaseAuthDataSource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GetTokenResult
import kotlinx.coroutines.tasks.await

class FirebaseAuthDataSourceImpl(
    private val firebaseAuth: FirebaseAuth
) : FirebaseAuthDataSource {

    override suspend fun isAuthenticated(): GetTokenResult? =
        firebaseAuth.currentUser?.getIdToken(true)?.await()
}