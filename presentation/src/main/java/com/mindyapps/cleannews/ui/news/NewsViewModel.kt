package com.mindyapps.cleannews.ui.news


import androidx.lifecycle.viewModelScope
import com.mindyapps.cleannews.base.BaseViewModel
import com.mindyapps.cleannews.utils.state.State
import com.mindyapps.domain.entity.NewsEntity
import com.mindyapps.domain.usecase.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.mindyapps.domain.core.Result
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
) : BaseViewModel() {

    private val _newsState = MutableStateFlow<State<NewsEntity>>(State.Default)
    val newsState: StateFlow<State<NewsEntity>> get() = _newsState.asStateFlow()

    init {
        //fixme Камиль сказал использовать init нежелательно, почитать почему именно
        getNews()
    }

    fun getNews() {
        _newsState.value = State.Loading
        viewModelScope.launch {
            when (val result = getNewsUseCase.invoke(Unit)) {
                is Result.Success -> _newsState.value = State.Success(result.data)
                is Result.Error -> _newsState.value = State.Error(result.failure)
            }
        }
    }
}