package com.github.sgeorgiev24.sisoexpensetracker.util.extension

import com.google.firebase.auth.FirebaseAuthInvalidUserException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import com.google.firebase.auth.FirebaseAuthException
import timber.log.Timber
import com.github.sgeorgiev24.sisoexpensetracker.util.Result
import kotlinx.coroutines.Dispatchers

// TODO this can be extracted in the feature (depending how the project evolve)
private const val UNKNOWN_ERROR = "Unknown error."

suspend fun <T> safeFirebaseCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    call: suspend () -> T
): Result<T> = withContext(dispatcher) {
    try {
        Result.Success(call.invoke())
    } catch (throwable: Throwable) {
        Timber.d("Firebase Error: ${throwable.message}")
        when (throwable) {
            is FirebaseAuthInvalidUserException -> {
                Result.Error.InvalidUser(message = throwable.message ?: "")
            }
            is FirebaseAuthException -> {
                Result.Error.InvalidCredentials(message = throwable.message ?: "")
            }
            else -> {
                Result.Error.Generic(message = throwable.message ?: UNKNOWN_ERROR)
            }
        }
    }
}