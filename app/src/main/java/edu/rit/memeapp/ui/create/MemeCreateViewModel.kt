package edu.rit.memeapp.ui.create

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import edu.rit.memeapp.data.local.CreatedMemeDatabase
import edu.rit.memeapp.data.model.CreateMeme
import edu.rit.memeapp.data.repository.CreatedMemeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemeCreateViewModel(application: Application): AndroidViewModel(application) {


    val readData: LiveData<List<CreateMeme>>
    private val repository: CreatedMemeRepository

    init {
        val createdMemeDao = CreatedMemeDatabase.getDatabase(application).createdMemeDao()
        repository = CreatedMemeRepository(createdMemeDao)
        readData = repository.readData
    }

    fun addCreatedMeme(meme: CreateMeme) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addMeme(meme)
        }
    }

}