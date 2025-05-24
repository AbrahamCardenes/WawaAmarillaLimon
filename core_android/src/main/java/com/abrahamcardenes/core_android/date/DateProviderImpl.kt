package com.abrahamcardenes.core_android.date

import android.os.Build
import java.time.Instant
import java.util.Calendar

class DateProviderImpl() : DateProvider {
    override fun getCurrentTimestamp(): Long {
        if (Build.VERSION.SDK_INT >= 26) {
            return Instant.EPOCH.epochSecond
        }
        return Calendar.getInstance().timeInMillis
    }
}
