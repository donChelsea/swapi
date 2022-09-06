package com.example.swapi.data.repository

import com.example.swapi.data.SwapiApi
import com.example.swapi.domain.Character
import com.example.swapi.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CharacterRepository {
    private val api = SwapiApi.getApi()

    suspend fun getCharacters(): Flow<List<Character>> = flow {
        val characters = api.getCharacters()
        with(characters) {
            emit(results.map { it.toDomain() })
        }
    }.flowOn(Dispatchers.IO)
}