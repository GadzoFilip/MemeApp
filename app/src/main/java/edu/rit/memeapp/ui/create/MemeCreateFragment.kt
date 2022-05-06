package edu.rit.memeapp.ui.create

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import edu.rit.memeapp.databinding.FragmentMemeCreateBinding
import androidx.fragment.app.Fragment
import edu.rit.memeapp.R
import edu.rit.memeapp.data.model.MemeInfo

class MemeCreateFragment: Fragment(R.layout.fragment_meme_create) {

    private lateinit var binding: FragmentMemeCreateBinding
    private lateinit var topText: String
    private lateinit var bottomText: String
    private lateinit var name: String
    private lateinit var image: ImageView

    companion object {
        val IMAGE_REQUEST_CODE = 100

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMemeCreateBinding.bind(view)

        binding.btnAddImage.setOnClickListener {
            pickImageGallery()
        }
    }

    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
            binding.ivAddMeme.setImageURI(data?.data)
        }
    }
}