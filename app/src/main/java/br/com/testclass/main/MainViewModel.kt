package br.com.testclass.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val repo: MainRepository,
    private val colorMapper: ColorMapper
) : ViewModel() {

    private val _state: MutableLiveData<MainState> = MutableLiveData()
    val state: LiveData<MainState> = _state
    private val model = MainModel()

    fun fetchColor() {
        CoroutineScope(Dispatchers.Main).launch {
            val state = repo.getColorName()
                .takeIf { it.isSuccessful }
                ?.let {
                    model.color = colorMapper.getColor(it.body())
                    MainState.Success(model)
                }
                ?: MainState.Error("api error")

            _state.postValue(state)
        }
    }
}