package com.example.bottomsheet.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [UserDetail::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class UserDatabase:RoomDatabase() {

    abstract  fun  userDao():UserDao


    companion object{

        @Volatile
        var INSTANCE :UserDatabase?=null

        fun getDataBaseuser(context: Context):UserDatabase{

            val tempInstance = INSTANCE
            if(tempInstance!=null)
            {
                return  tempInstance
            }

            synchronized(this){

                val roomdatabaseInstance= Room.databaseBuilder(context,UserDatabase::class.java,"User").allowMainThreadQueries().build()
                INSTANCE=roomdatabaseInstance

                return  roomdatabaseInstance
            }



        }







    }
}