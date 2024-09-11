package com.indigo.gymapp.service.api.exercises

import retrofit.Call
import retrofit.http.GET

interface ExercisesServiceRetrofit {

    @GET("exercises")
    fun getExercises() : Call<List<Exercise>>
}

