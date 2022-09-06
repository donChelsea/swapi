package com.example.swapi.data.dtos

data class SimpleListResult<T>(
    val results: List<T>
)