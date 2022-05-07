package edu.rit.memeapp.ui.create

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import edu.rit.memeapp.R
import edu.rit.memeapp.databinding.FragmentCreateListBinding

class MemeCreateListFragment: Fragment(R.layout.fragment_create_list) {

    private lateinit var viewModel: MemeCreateViewModel
    private lateinit var binding: FragmentCreateListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MemeCreateViewModel::class.java]
        binding = FragmentCreateListBinding.bind(view)

        val adapter = MemeCreateListAdapter()
        binding.rvCreate.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCreate.adapter = adapter


        viewModel.readData.observe(viewLifecycleOwner) { memes ->
            adapter.setData(memes)
        }
    }

}
