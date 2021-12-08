package com.example.inventory.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.NumberFormat
 // @Entity annotation marks a class as a database Entity class.
 // For each Entity class a database table is created to hold the items
@Entity
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val itemName: String,
    @ColumnInfo(name = "price")
    val itemPrice: Double,
    @ColumnInfo(name = "quantity")
    val quantityInStock: Int
)

// this one for Price $
    fun Item.getFormattedPrice(): String =
    NumberFormat.getCurrencyInstance().format(itemPrice)