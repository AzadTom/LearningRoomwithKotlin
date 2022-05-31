package com.example.bottomsheet

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Images.Media.getBitmap
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.bottomsheet.Room.UserDetail
import com.example.bottomsheet.Room.UserViewmodal
import com.example.bottomsheet.databinding.ActivityAdduserBinding
import com.theartofdev.edmodo.cropper.CropImage
import kotlinx.coroutines.launch

class adduser : AppCompatActivity() {


    private lateinit var binding: ActivityAdduserBinding
    private var IUri: Uri? = null
    private val Crop = object : ActivityResultContract<Any?, Uri?>() {
        override fun createIntent(context: Context, input: Any?): Intent {

            return CropImage.activity().setAspectRatio(16, 9)
                .getIntent(this@adduser)

        }

        override fun parseResult(resultCode: Int, intent: Intent?): Uri? {

            return CropImage.getActivityResult(intent).uri

        }


    }

    private lateinit var cropActivityResultLauncher: ActivityResultLauncher<Any?>
    private val userViewmodal by viewModels<UserViewmodal>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAdduserBinding.inflate(layoutInflater)
        setContentView(binding.root)




        cropActivityResultLauncher = registerForActivityResult(Crop) {

            it?.let {


                IUri = it
                binding.circleImageView2.setImageURI(it)


            }


        }

        binding.circleImageView2.setOnClickListener {

            cropActivityResultLauncher.launch(null)

        }

        binding.add.setOnClickListener {


            userViewmodal.insertUser(
                UserDetail(
                    null,
                    IUri.toString(),
                    binding.name.text.toString(),
                    binding.phoneNumber.text.toString()
                )
            )

            Toast.makeText(this,"added successfully!",Toast.LENGTH_LONG).show()

            val intent =Intent(this,MainActivity::class.java)
            finish()
            startActivity(intent)

        }
    }
}