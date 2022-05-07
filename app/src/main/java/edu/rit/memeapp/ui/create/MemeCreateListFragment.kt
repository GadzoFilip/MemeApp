package edu.rit.memeapp.ui.create

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import coil.ImageLoader
import edu.rit.memeapp.R
import edu.rit.memeapp.databinding.FragmentCreateListBinding

class MemeCreateListFragment: Fragment(R.layout.fragment_create_list) {

    private val viewModel: MemeCreateViewModel by activityViewModels()
    private lateinit var binding: FragmentCreateListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCreateListBinding.bind(view)

        val adapter = MemeCreateListAdapter()
        binding.rvCreate.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCreate.adapter = adapter

        viewModel.readData.observe(viewLifecycleOwner, Observer { memes ->
            adapter.setData(memes)
        })
    }


}
