package com.xmartlabs.template.database.converter

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {
  @TypeConverter
  fun fromDate(date: Date?): Long? {
    return date?.time
  }

  @TypeConverter
  fun toDate(millisSinceEpoch: Long?): Date? = millisSinceEpoch?.let {
    Date(it)
  }
}
