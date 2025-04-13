package com.abrahamcardenes.core.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

object DefaultDispatchersProvider : DispatchersProvider {
    override val IO: CoroutineDispatcher
        get() = Dispatchers.IO
    override val Main: CoroutineDispatcher
        get() = Dispatchers.Main
    override val Default: CoroutineDispatcher
        get() = Dispatchers.Default
}
