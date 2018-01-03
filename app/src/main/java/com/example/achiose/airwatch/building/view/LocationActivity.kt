package com.example.achiose.airwatch.building.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.achiose.airwatch.R

/**
 * Created by achiose on 15/12/17.
 */
class LocationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.location_activity_main)

        supportActionBar?.title = "Meeting Room"

        var locationFragment = fragmentManager.findFragmentById(R.id.location_fragment)
        if (locationFragment == null) {
            locationFragment = LocationFragment.newInstance()
            fragmentManager.beginTransaction().replace(R.id.frame_layout, locationFragment).commit()
        }
    }

    fun launchBuildingFragment(location: String) {
        var buildingFragment = fragmentManager.findFragmentById(R.id.building_fragment)
        if (buildingFragment == null) {
            val fragment = BuildingFragment.newInstance(location)
            fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).addToBackStack(null).commit()
        } else {
            (buildingFragment as BuildingFragment).updateContent(location)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.info_menu, menu)

        return true
    }

    override fun onBackPressed() {
        if (fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        item?.let {
            when (it.itemId) {
                R.id.info_menu_item -> Toast.makeText(this, "Info menu clicked", Toast.LENGTH_SHORT).show()
                android.R.id.home ->  fragmentManager.popBackStack()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}