package com.example.azapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {
    private val alphabetLower = "abcdefghijklmnopqrstuvwxyz".toCharArray()
    private val alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()
    private val state = MutableLiveData<State>()
    val viewModelState: LiveData<State> = state


    fun runCheck(firstChar: Char, capitalProtocol: RadioState) {
        when (capitalProtocol) {
            RadioState.FIRST_IS_UPPER_CASE -> {
                state.postValue(State.Content(alphabetUpper.contains(firstChar)))
            }
            RadioState.FIRST_IS_LOWER_CASE -> {
                state.postValue(State.Content(alphabetLower.contains(firstChar)))
            }
            else -> {
                state.postValue(
                    State.Content(
                        alphabetLower.contains(firstChar)
                                || alphabetUpper.contains(firstChar)
                    )
                )
            }
        }
    }

    sealed class State {
        data class Content(
            val result: Boolean
        ) : State()
    }
}