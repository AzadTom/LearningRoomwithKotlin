package com.example.bottomsheet.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface UserDao {


    @Query("SELECT * FROM user")
    fun getAlluser():LiveData<List<UserDetail>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(userDetail: UserDetail)

    @Query("SELECT * FROM user WHERE username =:name")
    fun SearchUser(name:String) :LiveData<List<UserDetail>>

}