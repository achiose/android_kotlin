package com.example.achiose.airwatch.building.view

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.achiose.airwatch.R
import com.example.achiose.airwatch.building.view.adapter.LocationsAdapter
import com.example.achiose.airwatch.building.model.Location
import kotlinx.android.synthetic.main.location_fragment_layout.view.*

/**
 * Created by achiose on 15/12/17.
 */
class LocationFragment : Fragment() {

    var locationClickedListener : LocationClickedListener? = null
    private lateinit var rootView : View

    companion object {

        fun newInstance(): LocationFragment {
            return LocationFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        rootView = inflater!!.inflate(R.layout.location_fragment_layout, container, false)

        // Set recyclerView
        rootView.location_recycler_view.layoutManager = LinearLayoutManager(activity)
        rootView.location_recycler_view.adapter = LocationsAdapter(populateLocationList()) {
            locationClickedListener?.onLocationClicked(it.name)
        }

        rootView.location_search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

        return rootView
    }

    interface LocationClickedListener {
        fun onLocationClicked(location : String)
    }

    fun populateLocationList() : ArrayList<Location> {
        val locationList = ArrayList<Location>()

        locationList.add(Location("Cleveland"))
        locationList.add(Location("New York"))
        locationList.add(Location("San Franscisco"))
        locationList.add(Location("Boston"))
        locationList.add(Location("Los Angeles"))
        locationList.add(Location("Sao Paulo"))

        return locationList
    }

}