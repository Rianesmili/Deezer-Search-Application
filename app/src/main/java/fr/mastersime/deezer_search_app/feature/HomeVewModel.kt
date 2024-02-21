package fr.mastersime.deezer_search_app.feature

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.mastersime.deezer_search_app.data.entities.AuthorEntity
import fr.mastersime.deezer_search_app.repository.AppRepository
import fr.mastersime.deezer_search_app.repository.AuthorResponse
import kotlinx.coroutines.flow.first
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
        Log.d("HomeViewModel", "Hello from updateData called with artistName: $artistName")
        viewModelScope.launch {
            try {
                _isUpdating.postValue(true)
                appRepository.updateAuthor(artistName)
                val list = appRepository.authorResponse.first()
                if (list is AuthorResponse.Success) {
                    _authorList.postValue(list.list)
                    Log.d("HomeViewModel", "Success: ${list.list}")
                } else if (list is AuthorResponse.Failure) {
                    _errorMessage.postValue(list.errorMessage)
                    Log.d("HomeViewModel", "Failure: ${list.errorMessage}")
                }
            } catch (e: Exception) {
                _errorMessage.postValue(e.message)
                Log.d("HomeViewModel", "Exception: ${e.message}")
            } finally {
                _isUpdating.postValue(false)
            }
        }
    }

}