package com.example.swapi.data

import com.example.swapi.data.dtos.CharacterDto
import com.example.swapi.data.dtos.SimpleListResult
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SwapiApi {

    @GET("api/people")
    suspend fun getCharacters(): SimpleListResult<CharacterDto>

    companion object {
         fun getApi() = Retrofit.Builder()
            .baseUrl("https://www.swapi.tech/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SwapiApi::class.java)
    }
}