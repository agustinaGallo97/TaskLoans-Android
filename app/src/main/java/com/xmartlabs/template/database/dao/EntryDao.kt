package com.xmartlabs.template.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xmartlabs.template.model.Entry
import com.xmartlabs.template.model.relationshipModels.EntryWithUsers

@Dao
interface EntryDao {
  @Query("SELECT * FROM entry")
  fun getEntrys(): LiveData<List<EntryWithUsers>>

  @Query("SELECT * FROM entry WHERE entryId=(:id)")
  fun getEntry(id: Int): LiveData<EntryWithUsers?>

  @Update
  fun updateEntry(entry: Entry)

  @Insert
  fun addEntry(entry: Entry)
}
