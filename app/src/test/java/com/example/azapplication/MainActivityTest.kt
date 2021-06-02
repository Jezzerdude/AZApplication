package com.example.azapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    lateinit var classUnderTest: MainViewModel

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        classUnderTest = MainViewModel()
    }

    @Test
    fun `when firstChar is uppercase and valid when uppercase is selected, result will be true`() {
        // Given
        val firstChar = 'A'
        val radioState = RadioState.FIRST_IS_UPPER_CASE

        // When
        classUnderTest.runCheck(firstChar, radioState)

        // Then
        assertTrue((classUnderTest.viewModelState.value as MainViewModel.State.Content).result)
    }

    @Test
    fun `when firstChar is lowercase and valid when uppercase is selected, result will be false`() {
        // Given
        val firstChar = 'a'
        val radioState = RadioState.FIRST_IS_UPPER_CASE

        // When
        classUnderTest.runCheck(firstChar, radioState)

        // Then
        assertFalse((classUnderTest.viewModelState.value as MainViewModel.State.Content).result)
    }

    @Test
    fun `when firstChar is invalid when uppercase is selected, result will be false`() {
        // Given
        val firstChar = '!'
        val radioState = RadioState.FIRST_IS_UPPER_CASE

        // When
        classUnderTest.runCheck(firstChar, radioState)

        // Then
        assertFalse((classUnderTest.viewModelState.value as MainViewModel.State.Content).result)
    }

    @Test
    fun `when firstChar is uppercase and valid when lowercase is selected, result will be false`() {
        // Given
        val firstChar = 'A'
        val radioState = RadioState.FIRST_IS_LOWER_CASE

        // When
        classUnderTest.runCheck(firstChar, radioState)

        // Then
        assertFalse((classUnderTest.viewModelState.value as MainViewModel.State.Content).result)
    }

    @Test
    fun `when firstChar is lowercase and valid when lowercase is selected, result will be true`() {
        // Given
        val firstChar = 'a'
        val radioState = RadioState.FIRST_IS_LOWER_CASE

        // When
        classUnderTest.runCheck(firstChar, radioState)

        // Then
        assertTrue((classUnderTest.viewModelState.value as MainViewModel.State.Content).result)
    }

    @Test
    fun `when firstChar is invalid when lowercase is selected, result will be false`() {
        // Given
        val firstChar = '!'
        val radioState = RadioState.FIRST_IS_LOWER_CASE

        // When
        classUnderTest.runCheck(firstChar, radioState)

        // Then
        assertFalse((classUnderTest.viewModelState.value as MainViewModel.State.Content).result)
    }

    @Test
    fun `when firstChar is uppercase and valid when both cases are selected, result will be true`() {
        // Given
        val firstChar = 'A'
        val radioState = RadioState.FIRST_IS_BOTH

        // When
        classUnderTest.runCheck(firstChar, radioState)

        // Then
        assertTrue((classUnderTest.viewModelState.value as MainViewModel.State.Content).result)
    }

    @Test
    fun `when firstChar is lowercase and valid when both cases are selected, result will be true`() {
        // Given
        val firstChar = 'a'
        val radioState = RadioState.FIRST_IS_BOTH

        // When
        classUnderTest.runCheck(firstChar, radioState)

        // Then
        assertTrue((classUnderTest.viewModelState.value as MainViewModel.State.Content).result)
    }

    @Test
    fun `when firstChar is invalid when both cases are selected, result will be false`() {
        // Given
        val firstChar = '!'
        val radioState = RadioState.FIRST_IS_BOTH

        // When
        classUnderTest.runCheck(firstChar, radioState)

        // Then
        assertFalse((classUnderTest.viewModelState.value as MainViewModel.State.Content).result)
    }
}