package com.indigo.gymapp.domain.exercises

import retrofit.Call
import retrofit.http.GET

interface ExercisesServiceRetrofit {

    @GET("exercises")
    fun getExercises() : Call<List<Exercise>>
}

