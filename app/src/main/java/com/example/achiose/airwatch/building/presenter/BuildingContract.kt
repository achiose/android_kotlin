package com.example.achiose.airwatch.building.presenter

import android.support.v7.widget.RecyclerView
import com.example.achiose.airwatch.BasePresenter
import com.example.achiose.airwatch.BaseView
import com.example.achiose.airwatch.building.model.Building

/**
 * Created by achiose on 26/12/17.
 */
interface BuildingContract {
    interface View : BaseView<Presenter> {
        fun onBuildingClicked(building : Building)
        fun showProgressBar(show : Boolean)
        fun showError(error : String)
        fun recyclerView() : RecyclerView
    }

    interface Presenter : BasePresenter{
        fun fetchBuilding(location : String)
    }
}