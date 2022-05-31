package com.example.bottomsheet.Room

import androidx.lifecycle.LiveData

class Userrepositery(val userDao:UserDao) {



    fun  getAlluser(): LiveData<List<UserDetail>> {

        return userDao.getAlluser()

    }


    fun  insertUser(userDetail: UserDetail)
    {
        return userDao.insertUser(userDetail)

    }

    fun Searchuser(name:String):LiveData<List<UserDetail>>
    {

        return userDao.SearchUser(name)
    }







}