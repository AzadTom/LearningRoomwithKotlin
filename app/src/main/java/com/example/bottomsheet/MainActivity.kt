package com.example.bottomsheet

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.example.bottomsheet.Room.UserDetail
import com.example.bottomsheet.Room.UserViewmodal
import com.example.bottomsheet.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.theartofdev.edmodo.cropper.CropImage
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding


    private lateinit var viewmodal: UserViewmodal
    private lateinit var adapter: Adapter
    private lateinit var data: ArrayList<UserDetail>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewmodal = ViewModelProvider(this)[UserViewmodal::class.java]













        binding.floatingActionButton.setOnClickListener {

            val intent =Intent(this,adduser::class.java)

            startActivity(intent)



        }


        viewmodal.getAlluser().observe(this, {

            data = it as ArrayList<UserDetail>
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            adapter = Adapter(this, it)
            binding.recyclerView.adapter = adapter


        })


    }


     suspend fun getBitmap(uri: Uri): Bitmap {

        val loading = ImageLoader(this)
        val request = ImageRequest.Builder(this).data(uri).build()


        val result = (loading.execute(request) as SuccessResult).drawable

        return (result as BitmapDrawable).bitmap

    }
}