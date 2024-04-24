package com.example.grupo22_kotlin.domain.use_case.posts

data class PostUseCases (
    val create: CreatePost,
    val getPosts: GetPosts,
    val deletePost: DeletePost,
    val getPostsByUserId: GetPostsByUserId,
    val getPostsByUserTaste: GetPostsByUserTaste,
    val getPostsByCategory: GetPostsByCategory,
    val updatePost: UpdatePost
)