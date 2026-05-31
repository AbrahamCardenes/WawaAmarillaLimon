package com.abrahamcardenes.core.uuid

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

interface UuidGenerator {

    @OptIn(ExperimentalUuidApi::class)
    fun getRandomUuidV4(): Uuid
}
