package com.example.achiose.airwatch.building.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.achiose.airwatch.R
import com.example.achiose.airwatch.building.model.Building
import kotlinx.android.synthetic.main.building_list_item.view.*

/**
 * Created by achiose on 15/12/17.
 */
class BuildingsAdapter(private val buildingsList : List<Building>, private val buildingClicked : (Building) -> Unit) :
        RecyclerView.Adapter<BuildingsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.building_list_item, parent, false)
        return ViewHolder(view, buildingClicked)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindBuilding(buildingsList[position])
    }

    override fun getItemCount() = buildingsList.size

    class ViewHolder(view: View, private val itemClick: (Building) -> Unit)
        : RecyclerView.ViewHolder(view) {

        fun bindBuilding(building : Building) {
            with(building) {
                itemView.building_name.text = building.name
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}