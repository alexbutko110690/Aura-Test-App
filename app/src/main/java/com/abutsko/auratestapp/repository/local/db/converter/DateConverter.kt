package com.abutsko.auratestapp.repository.local.db.converter

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {
    @TypeConverter
    fun fromTimestamp(time: Long?): Date? = time?.let(::Date)

    @TypeConverter
    fun toTimestamp(date: Date?): Long? = date?.time
}