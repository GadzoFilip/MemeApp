package edu.rit.memeapp.ui

import android.content.Intent
import android.content.pm.PackageManager
import android.provider.MediaStore
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import edu.rit.memeapp.databinding.FragmentMemeCreateBinding
import androidx.fragment.app.Fragment
import edu.rit.memeapp.R

class MemeCreateFragment: Fragment(R.layout.fragment_meme_create) {

    private lateinit var binding: FragmentMemeCreateBinding
    /*
    fun access(view: View){
        if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),1)
        } else {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(gallery, 2)
        }
    }*/
}