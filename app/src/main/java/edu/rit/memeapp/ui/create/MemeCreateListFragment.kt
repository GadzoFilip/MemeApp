package edu.rit.memeapp.ui.create


import androidx.fragment.app.Fragment
import edu.rit.memeapp.R


class MemeCreateListFragment: Fragment(R.layout.fragment_create_list) {
//    private lateinit var binding: FragmentMemeFavoritesBinding
//    private lateinit var repo: FavoritesRepository
//
//    private val adapter = MemeAdapter {meme ->
//        val direction = MemeFavoritesFragmentDirections.actionGlobalMemeDetailFragment(meme)
//        findNavController().navigate(direction)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding = FragmentMemeFavoritesBinding.bind(view)
//        repo = FavoritesRepository(requireContext())
//
//        binding.rvFavorites.adapter = adapter
//
//        lifecycleScope.launch(Dispatchers.IO) {
//            val data = repo.getAllMemes()
//            withContext(Dispatchers.Main){
//                adapter.setData(data)
//            }
//        }
//    }
}