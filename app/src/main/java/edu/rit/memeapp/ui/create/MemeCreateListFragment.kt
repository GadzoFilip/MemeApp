package edu.rit.memeapp.ui.create

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import coil.ImageLoader
import edu.rit.memeapp.R
import edu.rit.memeapp.data.model.CreateMeme
import edu.rit.memeapp.databinding.CreateMemeItemBinding
import edu.rit.memeapp.databinding.FragmentCreateListBinding

class MemeCreateListFragment: Fragment(R.layout.fragment_create_list) {

    private lateinit var viewModel: MemeCreateViewModel
    private lateinit var binding: FragmentCreateListBinding
    private lateinit var createItem: CreateMemeItemBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MemeCreateViewModel::class.java]
        //createItem = CreateMemeItemBinding.bind(view)
        binding = FragmentCreateListBinding.bind(view)

        val adapter = MemeCreateListAdapter()
        binding.rvCreate.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCreate.adapter = adapter

        viewModel.readData.observe(viewLifecycleOwner) { memes ->
            adapter.setData(memes)
        }
/*
        createItem.btnDelete.setOnClickListener{
            deleteMeme()
        }*/
    }
/*
    private fun deleteMeme() {
        viewModel.deleteMeme()
        Toast.makeText(requireContext(), "Deleted Meme", Toast.LENGTH_LONG).show()
    }*/
}
