package com.abrahamcardenes.lpa_presentation.fakes

import com.abrahamcardenes.core.dispatchers.DispatchersProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher

@OptIn(ExperimentalCoroutinesApi::class)
object TestsDispatchers : DispatchersProvider {
    override val IO: CoroutineDispatcher
        get() = UnconfinedTestDispatcher()
    override val Main: CoroutineDispatcher
        get() = UnconfinedTestDispatcher()
    override val Default: CoroutineDispatcher
        get() = UnconfinedTestDispatcher()
}
