package com.example.achiose.airwatch.building.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.achiose.airwatch.R
import com.example.achiose.airwatch.building.model.Location
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.location_list_item.view.*
import com.example.achiose.airwatch.grayScale

/**
 * Created by achiose on 15/12/17.
 */
class LocationsAdapter(private var locationList : MutableList<Location>, private val locationClicked : (Location, Int) -> Unit) :
        RecyclerView.Adapter<LocationsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.location_list_item, parent, false)
        return ViewHolder(view, locationClicked)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindBuilding(locationList[position])
    }

    override fun getItemCount() = locationList.size

    fun updateItens(locationList : List<Location>) {
        this.locationList.clear()
        this.locationList.addAll(locationList)
        notifyDataSetChanged()
    }


    class ViewHolder(view: View, private val itemClick: (Location, Int) -> Unit)
        : RecyclerView.ViewHolder(view) {

        fun bindBuilding(location : Location) {
            with(location) {
                itemView.location_name.text = name
                Picasso
                        .with(itemView.context)
                        .load(imageUrl)
                        .into(itemView.location_image, object : Callback {
                            override fun onError() {
                            }

                            override fun onSuccess() {
                                itemView.location_image.grayScale(true)
                            }
                        })
                itemView.setOnClickListener {
                    itemClick(this, adapterPosition)
                }
            }
        }
    }
}