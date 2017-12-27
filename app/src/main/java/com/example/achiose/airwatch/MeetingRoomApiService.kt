package com.example.achiose.airwatch

import com.example.achiose.airwatch.building.model.Building
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by achiose on 26/12/17.
 */
interface MeetingRoomApiService {

    @GET("buildings")
    fun getBuildings(@Query("city") city : String) : Call<List<Building>>

    companion object {
        fun create() : MeetingRoomApiService {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://localhost:3001/")
                    .build()

            return retrofit.create(MeetingRoomApiService::class.java)
        }
    }
}