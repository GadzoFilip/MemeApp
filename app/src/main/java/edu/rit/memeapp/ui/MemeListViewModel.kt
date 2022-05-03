package edu.rit.memeapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.rit.memeapp.data.model.Meme
import edu.rit.memeapp.data.repository.MemeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemeListViewModel(
    private val repository: MemeRepository = MemeRepository()
): ViewModel() {
    val memeData: MutableLiveData<List<Meme>> = MutableLiveData()

    init{
        getMemeData()
    }

    fun getMemeData(){
        viewModelScope.launch(Dispatchers.IO){
            val memes = repository.getMeme()
            memeData.postValue(memes)
        }
    }
}