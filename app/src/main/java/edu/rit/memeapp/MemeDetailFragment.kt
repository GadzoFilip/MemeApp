package edu.rit.memeapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import edu.rit.memeapp.databinding.FragmentMemeDetailBinding
import edu.rit.memeapp.util.loadUrl

class MemeDetailFragment: Fragment(R.layout.fragment_meme_detail) {
    private lateinit var binding: FragmentMemeDetailBinding
    private val args: MemeDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMemeDetailBinding.bind(view)

        binding.tvMemeName.text = args.meme.name
        binding.tvMemeTags.text = args.meme.tags

        binding.memeItem.ivMeme.loadUrl(args.meme.image, false)
        binding.memeItem.tvMemeTop.text = args.meme.topText
        binding.memeItem.tvMemeBottom.text = args.meme.bottomText


        (requireActivity() as AppCompatActivity).supportActionBar?.title = args.meme.topText
    }
}