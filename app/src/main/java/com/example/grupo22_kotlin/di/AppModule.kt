package com.example.grupo22_kotlin.di

import com.example.grupo22_kotlin.core.Constants.POSTS
import com.example.grupo22_kotlin.core.Constants.USERS
import com.example.grupo22_kotlin.data.repository.AuthRepositoryImpl
import com.example.grupo22_kotlin.data.repository.PostRepositoryImpl
import com.example.grupo22_kotlin.data.repository.UserRepositoryImpl
import com.example.grupo22_kotlin.domain.repository.AuthRepository
import com.example.grupo22_kotlin.domain.repository.PostRepository
import com.example.grupo22_kotlin.domain.repository.UserRepository
import com.example.grupo22_kotlin.domain.use_case.auth.AuthUseCases
import com.example.grupo22_kotlin.domain.use_case.auth.GetCurrentUser
import com.example.grupo22_kotlin.domain.use_case.auth.LogOut
import com.example.grupo22_kotlin.domain.use_case.auth.Login
import com.example.grupo22_kotlin.domain.use_case.auth.Signup
import com.example.grupo22_kotlin.domain.use_case.posts.AddReviewPost
import com.example.grupo22_kotlin.domain.use_case.posts.CreatePost
import com.example.grupo22_kotlin.domain.use_case.posts.DeleteLikePost
import com.example.grupo22_kotlin.domain.use_case.posts.DeletePost
import com.example.grupo22_kotlin.domain.use_case.posts.GetPostThatILiked
import com.example.grupo22_kotlin.domain.use_case.posts.GetPosts
import com.example.grupo22_kotlin.domain.use_case.posts.GetPostsByCategory
import com.example.grupo22_kotlin.domain.use_case.posts.GetPostsByUserId
import com.example.grupo22_kotlin.domain.use_case.posts.GetPostsByUserTaste
import com.example.grupo22_kotlin.domain.use_case.posts.GetReviewsByPost
import com.example.grupo22_kotlin.domain.use_case.posts.LikePost
import com.example.grupo22_kotlin.domain.use_case.posts.PostUseCases
import com.example.grupo22_kotlin.domain.use_case.posts.UpdatePost
import com.example.grupo22_kotlin.domain.use_case.posts.UpdateViews
import com.example.grupo22_kotlin.domain.use_case.users.AddContact
import com.example.grupo22_kotlin.domain.use_case.users.Create
import com.example.grupo22_kotlin.domain.use_case.users.GetUserById
import com.example.grupo22_kotlin.domain.use_case.users.GetUserContacts
import com.example.grupo22_kotlin.domain.use_case.users.SaveImage
import com.example.grupo22_kotlin.domain.use_case.users.Update
import com.example.grupo22_kotlin.domain.use_case.users.UserUseCases
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideFirebaseStorage(): FirebaseStorage = FirebaseStorage.getInstance()

    @Provides
    fun provideStorageUsersRed(storage: FirebaseStorage): StorageReference = storage.reference.child(
        USERS)

    @Provides
    fun provideFirebaseFirestore(): FirebaseFirestore = Firebase.firestore

    @Provides
    @Named(USERS)
    fun provideUsersRef(db: FirebaseFirestore): CollectionReference = db.collection(USERS)

    @Provides
    @Named(POSTS)
    fun provideStoragePostsRef(storage: FirebaseStorage): StorageReference = storage.reference.child(POSTS)

    @Provides
    @Named(POSTS)
    fun providePostsRef(db: FirebaseFirestore): CollectionReference = db.collection(POSTS)
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun provideUsersRepository(impl: UserRepositoryImpl): UserRepository = impl

    @Provides
    fun providePostRepository(impl: PostRepositoryImpl): PostRepository = impl

    @Provides
    fun provideAuthUseCases(repository: AuthRepository)= AuthUseCases(
        getCurrentUser = GetCurrentUser(repository),
        login = Login(repository),
        logOut = LogOut(repository),
        signup = Signup(repository)
    )

    @Provides
    fun provideUsersUseCases(repository: UserRepository) = UserUseCases(
        create = Create(repository),
        getUserById = GetUserById(repository),
        update = Update(repository),
        saveImage = SaveImage(repository),
        addContact = AddContact(repository),
        getUserContacts = GetUserContacts(repository)
    )

    @Provides
    fun providePostUseCases(repository: PostRepository) = PostUseCases(
        create = CreatePost(repository),
        getPosts = GetPosts(repository),
        deletePost = DeletePost(repository),
        getPostsByUserId = GetPostsByUserId(repository),
        getPostsByUserTaste = GetPostsByUserTaste(repository),
        getPostsByCategory = GetPostsByCategory(repository),
        updatePost = UpdatePost(repository),
        updateViews = UpdateViews(repository),
        likePost = LikePost(repository),
        deleteLikePost = DeleteLikePost(repository),
        getPostThatILiked = GetPostThatILiked(repository),
        addReviewPost = AddReviewPost(repository),
        getReviewsByPost = GetReviewsByPost(repository)
    )
}