package edu.rit.memeapp.ui.create

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import edu.rit.memeapp.R
import edu.rit.memeapp.data.model.CreateMeme
import edu.rit.memeapp.databinding.FragmentMemeCreateBinding

class CreateMemeAdapter: Fragment() {

    private lateinit var binding: FragmentMemeCreateBinding
    private lateinit var mMemeViewModel: MemeCreateViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_meme_create, container, false)

        mMemeViewModel = ViewModelProvider(this)[MemeCreateViewModel::class.java]

        binding.btnCreateMeme.setOnClickListener {
            insertMemeToDatabase()
        }

        return view
    }

    private fun insertMemeToDatabase() {
        val topText = binding.etTopText.text.toString()
        val bottomText = binding.etBottomText.text.toString()
        val name = binding.etName.text.toString()

        if(inputCheck(topText, bottomText, name)){
            val meme = CreateMeme(0, topText, bottomText, name)
            mMemeViewModel.addCreatedMeme(meme)
            Toast.makeText(requireContext(), "New meme successfully created", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(requireContext(), "Fill all the fields", Toast.LENGTH_LONG).show()

        }
    }


    private fun inputCheck(topText: String, bottomText: String, name: String): Boolean{
        return !(TextUtils.isEmpty(topText) && TextUtils.isEmpty(bottomText) && TextUtils.isEmpty(name))
    }


}