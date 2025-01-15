package com.example.noteapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(Note: Note)
    @Delete
    suspend fun deleteItem(Note: Note)
    @Query("SELECT * FROM name_table")
    fun getAllItems(): Flow<List<Note>>
}