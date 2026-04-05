package com.abrahamcardenes.lpa_presentation.coroutineRules

import io.kotest.core.listeners.AfterTestListener
import io.kotest.core.listeners.BeforeTestListener
import io.kotest.core.test.TestCase
import io.kotest.engine.test.TestResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain

@ExperimentalCoroutinesApi
class CoroutineTestExtension : BeforeTestListener, AfterTestListener {
    private val dispatcher = UnconfinedTestDispatcher()

    override suspend fun beforeTest(testCase: TestCase) {
        Dispatchers.setMain(dispatcher)
    }

    override suspend fun afterTest(testCase: TestCase, result: TestResult) {
        Dispatchers.resetMain()
    }
}
