package com.abrahamcardenes.core_android.date

import android.os.Build
import java.time.Instant
import java.util.Calendar

class DateProviderImpl() : DateProvider {
    override fun getCurrentTimestamp(): Long {
        //if (Build.VERSION.SDK_INT >= 26) {
        //    println("#### Instant.EPOCH.epochSecond ${Instant.EPOCH.epochSecond}")
        //    return Instant.EPOCH.toEpochMilli()
        //}
        return Calendar.getInstance().timeInMillis
    }
}
