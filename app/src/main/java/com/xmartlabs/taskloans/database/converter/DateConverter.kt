package com.xmartlabs.taskloans.database.converter

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {
  @TypeConverter
  fun fromDate(date: Date?): Long? = date?.time

  @TypeConverter
  fun toDate(millisSinceEpoch: Long?): Date? = millisSinceEpoch?.let {
    Date(it)
  }
}
