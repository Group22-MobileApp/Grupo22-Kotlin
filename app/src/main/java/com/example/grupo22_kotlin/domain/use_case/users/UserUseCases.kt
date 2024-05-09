package com.example.grupo22_kotlin.domain.use_case.users

data class UserUseCases (
    val create: Create,
    val getUserById: GetUserById,
    val update: Update,
    val saveImage: SaveImage,
    val addContact: AddContact
    )