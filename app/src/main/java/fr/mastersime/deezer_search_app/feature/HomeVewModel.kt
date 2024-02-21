package fr.mastersime.deezer_search_app.feature

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.mastersime.deezer_search_app.data.entities.AuthorEntity
import fr.mastersime.deezer_search_app.repository.AppRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val appRepository: AppRepository,
) : ViewModel() {

    private val _isUpdating = MutableLiveData(false)
    private val _authorList = MutableLiveData<List<AuthorEntity>>()
    private val _errorMessage = MutableLiveData<String>()

    val errorMessage: LiveData<String> = _errorMessage
    val isUpdating: LiveData<Boolean> = _isUpdating
    val authorList: LiveData<List<AuthorEntity>> = _authorList


    fun updateData(artistName: String) {
        viewModelScope.launch {
            _isUpdating.postValue(true)
            appRepository.updateAuthor(artistName)
            _isUpdating.postValue(false)
        }
    }

}