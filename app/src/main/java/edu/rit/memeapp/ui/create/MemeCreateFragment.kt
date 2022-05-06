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
import android.widget.Toast
import edu.rit.memeapp.databinding.FragmentMemeCreateBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import edu.rit.memeapp.R
import edu.rit.memeapp.data.model.CreateMeme
import edu.rit.memeapp.data.model.MemeInfo

class MemeCreateFragment: Fragment(R.layout.fragment_meme_create) {

    private lateinit var binding: FragmentMemeCreateBinding
    private lateinit var mMemeViewModel: MemeCreateViewModel

    private lateinit var topText: String
    private lateinit var bottomText: String
    private lateinit var name: String

    companion object {
        val IMAGE_REQUEST_CODE = 100

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mMemeViewModel = ViewModelProvider(this)[MemeCreateViewModel::class.java]

        binding = FragmentMemeCreateBinding.bind(view)

        binding.btnAddImage.setOnClickListener {
            pickImageGallery()
        }

        binding.btnCreateMeme.setOnClickListener {
            insertMemeToDatabase()
            clearFields()
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

    private fun insertMemeToDatabase() {
        topText = binding.etTopText.text.toString()
        bottomText = binding.etBottomText.text.toString()
        name = binding.etName.text.toString()

        val meme = CreateMeme(0, topText, bottomText, name)
        mMemeViewModel.addCreatedMeme(meme)
        Toast.makeText(requireContext(), "New meme successfully created", Toast.LENGTH_LONG).show()

    }

    private fun clearFields(){
        binding.etTopText.setText("")
        binding.etBottomText.setText("")
        binding.etName.setText("")
    }
}