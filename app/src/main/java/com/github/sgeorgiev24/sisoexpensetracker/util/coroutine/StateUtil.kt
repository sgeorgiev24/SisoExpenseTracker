package com.github.sgeorgiev24.sisoexpensetracker.util.coroutine

import kotlinx.coroutines.flow.MutableStateFlow

inline fun <T> MutableStateFlow<T>.update(function: (T) -> T) {
    while (true) {
        val prevValue = value
        val nextValue = function(prevValue)
        if (compareAndSet(prevValue, nextValue)) {
            return
        }
    }
}