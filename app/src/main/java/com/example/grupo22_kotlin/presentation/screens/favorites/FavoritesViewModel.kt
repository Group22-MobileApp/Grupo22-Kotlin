package com.example.grupo22_kotlin.presentation.screens.favorites
import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grupo22_kotlin.domain.model.Post
import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.domain.use_case.auth.AuthUseCases
import com.example.grupo22_kotlin.domain.use_case.posts.PostUseCases
import com.example.grupo22_kotlin.presentation.screens.mainHome.NetworkConnectivityObserver
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val postUseCases: PostUseCases,
    private val authUseCases: AuthUseCases,
    @ApplicationContext private val context: Context
): ViewModel()  {

    val connectivityObserver = NetworkConnectivityObserver(context.applicationContext)
    var postsResponse by mutableStateOf<Response<List<Post>>?>(null)
    val currentUser = authUseCases.getCurrentUser()
    init {
        getPosts()
    }

    fun getPosts() = viewModelScope.launch {
        postsResponse = Response.Loading
        postUseCases.getPostThatILiked(currentUser?.uid ?: "").collect() { response ->
            postsResponse = response
        }
    }



}