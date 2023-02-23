package com.sultonbek1547.roomcrud.databse

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class MyUser {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    @ColumnInfo
    var name: String? = null

    @ColumnInfo(name = "phoneNumber")
    var number: String? = null


}