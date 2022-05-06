package edu.rit.memeapp.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import edu.rit.memeapp.R
import edu.rit.memeapp.databinding.FragmentCreateListBinding
import edu.rit.memeapp.ui.MemeListViewModel

class MemeCreateListFragment: Fragment() {

    private val viewModel: MemeCreateViewModel by activityViewModels()
    private lateinit var binding: FragmentCreateListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCreateListBinding.bind(view)

        binding.rvCreate.layoutManager = LinearLayoutManager(requireContext())



//        viewModel.memeData.observe(viewLifecycleOwner) { memes ->
//            adapter.setData(memes)
//        }
    }
}