package com.abrahamcardenes.core_android.dataStore

typealias Etag = String

interface WawaSettings {
    suspend fun saveEtag(etag: Etag)
    suspend fun getEtag(): Etag?
}
