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
                    val url : String)