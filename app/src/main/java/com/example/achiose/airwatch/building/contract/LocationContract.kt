package com.example.achiose.airwatch.building.contract

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import com.example.achiose.airwatch.BasePresenter
import com.example.achiose.airwatch.BaseView
import com.example.achiose.airwatch.building.model.Location

/**
 * Created by achiose on 26/12/17.
 */
interface LocationContract {
    interface View : BaseView<Presenter> {
        fun updateLocationItens(locationList : List<Location>)
        fun onLocationClicked(location : Location, position : Int)
    }

    interface Presenter : BasePresenter {
        fun setupRecyclerView(recyclerView: RecyclerView)
        fun setupSearchView(searchView: SearchView)
    }
}