package com.example.lorenzodwishlist

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDAO
{
    @Insert
    fun insertAll(vararg items: ItemEntity)
    @Query("SELECT * FROM item_table")
    fun getAll(): Flow <List<ItemEntity>>
    @Query("DELETE FROM item_table")
    fun deleteAll()
}