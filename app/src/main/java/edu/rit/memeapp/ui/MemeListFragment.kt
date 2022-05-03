package edu.rit.memeapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import edu.rit.memeapp.R
import edu.rit.memeapp.databinding.FragmentMemeListBinding

class MemeListFragment: Fragment(R.layout.fragment_meme_list) {
    private val viewModel: MemeListViewModel by activityViewModels()
    private lateinit var binding: FragmentMemeListBinding

    private val adapter = MemeAdapter {meme ->
        val direction = MemeListFragmentDirections.actionGlobalMemeDetailFragment(meme)
        findNavController().navigate(direction)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMemeListBinding.bind(view)

        binding.rvMeme.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMeme.adapter = adapter

        viewModel.memeData.observe(viewLifecycleOwner) { memes ->
            adapter.setData(memes)
        }
    }
}