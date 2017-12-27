package com.example.achiose.airwatch.building.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.achiose.airwatch.R
import com.example.achiose.airwatch.building.model.Location
import kotlinx.android.synthetic.main.location_list_item.view.*

/**
 * Created by achiose on 15/12/17.
 */
class LocationsAdapter(private val locationList : List<Location>, private val locationClicked : (Location) -> Unit) :
        RecyclerView.Adapter<LocationsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.location_list_item, parent, false)
        return ViewHolder(view, locationClicked)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindBuilding(locationList[position])
    }

    override fun getItemCount() = locationList.size

    class ViewHolder(view: View, private val itemClick: (Location) -> Unit)
        : RecyclerView.ViewHolder(view) {

        fun bindBuilding(location : Location) {
            with(location) {
                itemView.location_name.text = location.name
                itemView.setOnClickListener {
                    itemClick(this)
                }
            }
        }
    }
}