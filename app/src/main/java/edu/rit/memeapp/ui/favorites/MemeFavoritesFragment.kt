package edu.rit.memeapp.ui.favorites

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import edu.rit.memeapp.R
import edu.rit.memeapp.data.repository.FavoritesRepository
import edu.rit.memeapp.databinding.FragmentMemeFavoritesBinding
import edu.rit.memeapp.ui.MemeAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemeFavoritesFragment : Fragment(R.layout.fragment_meme_favorites) {

    private lateinit var binding: FragmentMemeFavoritesBinding
    private lateinit var repo: FavoritesRepository

    private val adapter = MemeAdapter {meme ->
        val direction = MemeFavoritesFragmentDirections.actionGlobalMemeDetailFragment(meme)
        findNavController().navigate(direction)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMemeFavoritesBinding.bind(view)
        repo = FavoritesRepository(requireContext())

        binding.rvFavorites.adapter = adapter

        lifecycleScope.launch(Dispatchers.IO) {
            val data = repo.getAllMemes()
            adapter.setData(data)
        }
    }
}