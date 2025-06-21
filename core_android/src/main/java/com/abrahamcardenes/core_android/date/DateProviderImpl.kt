package com.abrahamcardenes.core_android.date

import java.util.Calendar

class DateProviderImpl() : DateProvider {
    override fun getCurrentTimestamp(): Long = Calendar.getInstance().timeInMillis
}
