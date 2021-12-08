package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// RoomDatabase that uses the Entity and DAO that you created in the previous task.
// The database class defines the list of entities and data access objects. It is also the main access point for the underlying connection.
@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class ItemRoomDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var INSTANCE: ItemRoomDatabase? = null
       fun getDatabase(context: Context): ItemRoomDatabase {
           return INSTANCE ?: synchronized(this) {
       val instance = Room.databaseBuilder(
      context.applicationContext,
      ItemRoomDatabase::class.java,
        "item_database")
      .fallbackToDestructiveMigration()
         .build()
         INSTANCE = instance
           return instance
         }
  }
  }
}
