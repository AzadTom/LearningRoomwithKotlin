package com.example.bottomsheet.Room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class UserViewmodal(application: Application):AndroidViewModel(application) {


    val repositorty :Userrepositery




    init {

        val dao =UserDatabase.getDataBaseuser(application).userDao()
        repositorty = Userrepositery(dao)
    }





    fun  getAlluser(): LiveData<List<UserDetail>> =repositorty.getAlluser()
    fun Searchuser(name:String):LiveData<List<UserDetail>> = repositorty.Searchuser(name)




    fun  insertUser(userDetail: UserDetail)
    {
        repositorty.insertUser(userDetail)

    }
}