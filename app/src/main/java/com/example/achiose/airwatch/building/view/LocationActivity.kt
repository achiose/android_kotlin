package com.example.achiose.airwatch.building.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.achiose.airwatch.MeetingRoomApiService
import com.example.achiose.airwatch.R
import com.example.achiose.airwatch.building.model.Building
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by achiose on 15/12/17.
 */
class LocationActivity : AppCompatActivity(), LocationFragment.LocationClickedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.location_activity_main)

        supportActionBar?.let {
            it.setTitle("Test")
            it.setHomeButtonEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }

        val buidingsList = MeetingRoomApiService.create().getBuildings("Atlanta")
        buidingsList.enqueue(object : Callback<List<Building>> {
            override fun onResponse(call: Call<List<Building>>?, response: Response<List<Building>>?) {
                response?.body()?.let {
                    val buildings : List<Building> = it
                    buildings.forEach({ building ->
                        Log.d("Response", building.name)
                        Log.d("Response", building.toString())
                    })
                }
            }

            override fun onFailure(call: Call<List<Building>>?, t: Throwable?) {
                Log.e("Error", t.toString())
            }
        })

        var locationFragment = fragmentManager.findFragmentById(R.id.location_fragment)
        if (locationFragment == null) {
            locationFragment = LocationFragment.newInstance()
//            fragmentManager.beginTransaction().replace(R.id.frame_layout, locationFragment).commit()
        }

        (locationFragment as LocationFragment).locationClickedListener = this
    }

    override fun onLocationClicked(location : String) {
        var buildingFragment = fragmentManager.findFragmentById(R.id.building_fragment)
        if(buildingFragment == null) {
            val fragment = BuildingFragment.newInstance(location);

//            fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit()
        } else {
            (buildingFragment as BuildingFragment).updateContent(location)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.info_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        item?.let {
            when(it.itemId) {
                R.id.info_menu_item -> Toast.makeText(this, "Info menu clicked", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}