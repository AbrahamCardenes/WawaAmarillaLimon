package com.abrahamcardenes.core.uuid

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
class UuidGeneratorImpl : UuidGenerator {
    override fun getRandomUuidV4(): Uuid = Uuid.random()
}
