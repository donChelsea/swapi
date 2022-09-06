package com.example.swapi.data.dtos

import com.example.swapi.domain.Character

data class CharacterDto(
    val uid: String,
    val name: String,
    val url: String,
) {
    fun toDomain() = Character(
        uid = uid,
        name = name,
        url = url
    )
}