package edu.rit.memeapp.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import edu.rit.memeapp.R
import edu.rit.memeapp.data.repository.FavoritesRepository
import edu.rit.memeapp.databinding.FragmentMemeDetailBinding
import edu.rit.memeapp.util.loadUrl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MemeDetailFragment: Fragment(R.layout.fragment_meme_detail) {
    private lateinit var binding: FragmentMemeDetailBinding
    private val args: MemeDetailFragmentArgs by navArgs()
    private lateinit var favoritesRepository: FavoritesRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMemeDetailBinding.bind(view)

        favoritesRepository = FavoritesRepository(requireContext())

        binding.tvMemeName.text = args.meme.name
        binding.tvMemeTags.text = args.meme.tags

        binding.memeItem.ivMeme.loadUrl(args.meme.image, false)
        binding.memeItem.tvMemeTop.text = args.meme.topText
        binding.memeItem.tvMemeBottom.text = args.meme.bottomText

        binding.btnToggleFavorites.setOnClickListener { toggleFavorite() }

        (requireActivity() as AppCompatActivity).supportActionBar?.title = args.meme.name

        updateButtonText()
    }

    private fun updateButtonText() {
        lifecycleScope.launch(Dispatchers.IO) {
            val isInFavorites = favoritesRepository.isInFavorites(args.meme)
            val btnText = if(isInFavorites) "Remove from favorites" else "Add to favorites"

            withContext(Dispatchers.Main) {
                binding.btnToggleFavorites.text = btnText
            }
        }
    }

    private fun toggleFavorite() {
        lifecycleScope.launch(Dispatchers.IO) {
            val isInFavorites = favoritesRepository.isInFavorites(args.meme)

            if(isInFavorites){
                favoritesRepository.remove(args.meme)
            } else {
                favoritesRepository.add(args.meme)
            }

            updateButtonText()
        }
    }

}