package com.example.achiose.airwatch.building.model

/**
 * Created by achiose on 15/12/17.
 */
data class Building(val id : Int,
                    val name : String,
                    val city : String,
                    val location : String,
                    val flag_parking : Int,
                    val flag_wifi : Int,
                    val flag_presentation : Int,
                    val room_count : Int,
                    val url : String) {

    fun roomCountToString() : String {
        val builder = StringBuilder()

        builder.append(room_count)
        builder.append(if (room_count > 1) " rooms" else " room")

        return builder.toString()
    }
}