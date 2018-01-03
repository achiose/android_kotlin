package com.example.achiose.airwatch.building.view

import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.achiose.airwatch.R
import com.example.achiose.airwatch.building.view.adapter.LocationsAdapter
import com.example.achiose.airwatch.building.model.Location
import com.example.achiose.airwatch.building.contract.LocationContract
import com.example.achiose.airwatch.building.presenter.LocationPresenter
import kotlinx.android.synthetic.main.location_fragment_layout.view.*
import kotlinx.android.synthetic.main.location_list_item.view.*
import com.example.achiose.airwatch.grayScale

/**
 * Created by achiose on 15/12/17.
 */
class LocationFragment : Fragment(), LocationContract.View {

    private lateinit var presenter : LocationContract.Presenter
    private lateinit var rootView : View

    companion object {

        fun newInstance(): LocationFragment {
            return LocationFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        LocationPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        rootView = inflater!!.inflate(R.layout.location_fragment_layout, container, false)

        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        presenter.setupRecyclerView(rootView.location_recycler_view)
        presenter.setupSearchView(rootView.location_search_view)

        return rootView
    }

    override fun setPresenter(presenter: LocationContract.Presenter) {
        this.presenter = presenter
    }

    override fun updateLocationItens(locationList : List<Location>) {
        (rootView.location_recycler_view.adapter as LocationsAdapter).updateItens(locationList)
    }

    override fun onLocationClicked(location : Location, position : Int) {
        for (i in 0..(rootView.location_recycler_view.childCount -1)) {
            if (i != position) {
                (rootView.location_recycler_view.findViewHolderForAdapterPosition(i) as LocationsAdapter.ViewHolder).itemView.location_image.grayScale(true)
            } else {
                (rootView.location_recycler_view.findViewHolderForAdapterPosition(i) as LocationsAdapter.ViewHolder).itemView.location_image.grayScale(false)
            }
        }
        (activity as LocationActivity).launchBuildingFragment(location.name)
    }
}