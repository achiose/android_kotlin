package com.example.achiose.airwatch.building.presenter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import com.example.achiose.airwatch.building.model.Location
import com.example.achiose.airwatch.building.view.adapter.LocationsAdapter

/**
 * Created by achiose on 26/12/17.
 */
class LocationPresenter(val view: LocationContract.View) : LocationContract.Presenter {

    init {
        start()
    }

    lateinit var locationList: ArrayList<Location>

    override fun start() {
        view.setPresenter(this)
        locationList = ArrayList()
    }

    override fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.adapter = LocationsAdapter(populateLocationList()) { location: Location, position: Int ->
            view.onLocationClicked(location, position)
        }
    }

    override fun setupSearchView(searchView: SearchView) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { value ->
                    var list = locationList.filter {
                        it.name.toLowerCase().contains(value.toLowerCase())
                    } as MutableList<Location>
                    if (list.size == 0) list.add(Location("Chicago", "http://localhost:3001/city/chicago/image"))
                    view.updateLocationItens(list)
                }

                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { value ->
                    var list = locationList.filter {
                        it.name.toLowerCase().contains(value.toLowerCase())
                    } as MutableList<Location>
                    if (list.size == 0) list.add(Location("Chicago", "http://localhost:3001/city/chicago/image"))
                    view.updateLocationItens(list)
                }

                return true
            }
        })

        searchView.setOnCloseListener(object : SearchView.OnCloseListener {
            override fun onClose(): Boolean {
                view.updateLocationItens(locationList)
                return false
            }
        })
    }

    fun populateLocationList(): MutableList<Location> {
        locationList.clear()

        locationList.add(Location("Atlanta", "http://localhost:3001/city/atlanta/image"))
        locationList.add(Location("New York", "http://localhost:3001/city/new%20york/image"))
        locationList.add(Location("San Francisco", "http://localhost:3001/city/san%20francisco/image"))
        locationList.add(Location("Los Angeles", "http://localhost:3001/city/los%20angeles/image"))
        locationList.add(Location("Chicago", "http://localhost:3001/city/chicago/image"))

        return locationList.toMutableList()
    }

}