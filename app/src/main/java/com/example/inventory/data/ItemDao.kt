package com.example.inventory.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/*The Data Access Object (DAO) is a pattern used to separate the persistence layer with the rest of the application by providing an abstract interface.
 This isolation follows the single responsibility principle,
 which you have seen in the previous codelabs. */

// inside the Dao Take Insert Update Delete Query



/*
Now the Room will generate all the necessary code to insert the item into the database. When you call insert() from your Kotlin code,
 Room executes a SQL query to insert the entity into the database.
 (Note: The function can be named anything you want;
 it doesn't have to be called insert().)
 */

@Dao
interface ItemDao {

    @Query("SELECT * from item ORDER BY name ASC")
    fun getItems(): Flow<List<Item>>

    @Query("SELECT * from item WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    // Specify the conflict strategy as IGNORE, when the user tries to add an
    // existing Item into the database Room ignores the conflict.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)
}