package edu.rit.memeapp.ui.create

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.drawToBitmap
import edu.rit.memeapp.databinding.FragmentMemeCreateBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import edu.rit.memeapp.R
import edu.rit.memeapp.data.model.CreateMeme
import kotlinx.coroutines.launch

class MemeCreateFragment: Fragment(R.layout.fragment_meme_create) {

    private lateinit var binding: FragmentMemeCreateBinding
    private lateinit var memeViewModel: MemeCreateViewModel

    private lateinit var topText: String
    private lateinit var bottomText: String
    private lateinit var name: String

    companion object {
        val IMAGE_REQUEST_CODE = 100

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        memeViewModel = ViewModelProvider(this)[MemeCreateViewModel::class.java]

        binding = FragmentMemeCreateBinding.bind(view)

        binding.btnAddImage.setOnClickListener {
            pickImageGallery()
        }

        binding.btnCreateMeme.setOnClickListener {
            insertMemeToDatabase()
        }
    }
//    WIP: Don't know how to retrieve image from database
//    private suspend fun getBitmap(): Bitmap {
//        val loading = ImageLoader(this)
//        val request = ImageRequest.Builder(this).data(binding.ivAddMeme).build()
//        val result = (loading.execute(request) as SuccessResult).drawable
//        return (result as BitmapDrawable).bitmap
//    }

    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            binding.ivAddMeme.setImageURI(data?.data)
        }
    }

    private fun insertMemeToDatabase() {
        topText = binding.etTopText.text.toString()
        bottomText = binding.etBottomText.text.toString()
        name = binding.etName.text.toString()

        if (checkFields()) {
            lifecycleScope.launch {
                val meme = CreateMeme(0, topText, bottomText, name)
                memeViewModel.addCreatedMeme(meme)
                Toast.makeText(requireContext(), "New meme successfully created", Toast.LENGTH_LONG)
                    .show()
                clearFields()
            }

        } else {
            Toast.makeText(requireContext(), "Fill in all the fields", Toast.LENGTH_LONG)
                .show()
        }

    }

    private fun checkFields(): Boolean {
        return !(topText.isNullOrEmpty() || bottomText.isNullOrEmpty() || name.isNullOrEmpty())
    }

    private fun clearFields() {
        binding.etTopText.setText("")
        binding.etBottomText.setText("")
        binding.etName.setText("")
    }
}