package com.example.bottomsheet

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.example.bottomsheet.Room.UserDetail
import de.hdodenhof.circleimageview.CircleImageView

class Adapter(private val context: Context,private val listUser: List<UserDetail>):RecyclerView.Adapter<Adapter.getViewholder>() {




    inner class getViewholder(itemview: View):RecyclerView.ViewHolder(itemview){

        val username:TextView =itemview.findViewById(R.id.username)
        val number :TextView =itemView.findViewById(R.id.usernumber)
        val  img :CircleImageView =itemview.findViewById(R.id.circleImageView)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): getViewholder {


         val view  =LayoutInflater.from(parent.context).inflate(R.layout.recbg,parent,false)
        return getViewholder(view)






    }

    override fun onBindViewHolder(holder: getViewholder, position: Int) {
        holder.username.text =listUser[position].username
        holder.number.text  =listUser[position].phoneNumber.toString()
        Glide.with(context).load(listUser[position].userImg?.toUri()).into(holder.img)







    }

    override fun getItemCount(): Int {
        return listUser.size
    }

}