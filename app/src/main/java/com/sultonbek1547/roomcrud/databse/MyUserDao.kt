package com.sultonbek1547.roomcrud.databse

import androidx.room.*

@Dao
interface MyUserDao {

    @Query("select * from myUser")
    fun getAllUser(): List<MyUser>

    @Insert
    fun addUser(user: MyUser)

    @Delete
    fun deleteUser(user: MyUser)

    @Update
    fun editUser(user: MyUser)

    @Query("select * from myUser where name=:name and phoneNumber=:number")
    fun getUserById(name: String, number: String): Int
}