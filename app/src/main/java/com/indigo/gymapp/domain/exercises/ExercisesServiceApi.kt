package com.indigo.gymapp.domain.exercises

import android.content.Context
import android.widget.Toast
import retrofit.Call
import retrofit.Callback
import retrofit.GsonConverterFactory
import retrofit.Response
import retrofit.Retrofit

class ExercisesServiceApi {
    fun getExercises(context: Context, onSuccess: (List<Exercise>) -> Unit, onFail: () -> Unit, loadingFinished: () -> Unit) {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(
                "10.0.2.2/exercises"
            )
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()

        val service: ExercisesServiceRetrofit = retrofit.create(ExercisesServiceRetrofit::class.java)

        val call: Call<List<Exercise>> = service.getExercises()

        call.enqueue(object : Callback<List<Exercise>> {
            override fun onResponse(response: Response<List<Exercise>>?, retrofit: Retrofit?) {
                loadingFinished()
                if(response?.isSuccess == true) {
                    val jokes: List<Exercise> = response.body()
                    onSuccess(jokes)
                } else {
                    onFailure(Exception("Bad request"))
                }
            }

            override fun onFailure(t: Throwable?) {
                Toast.makeText(context, "Can't get rankings", Toast.LENGTH_SHORT).show()
                onFail()
                loadingFinished()
            }
        })
    }
}