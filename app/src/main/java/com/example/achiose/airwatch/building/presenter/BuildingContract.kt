package com.example.achiose.airwatch.building.presenter

import com.example.achiose.airwatch.BasePresenter
import com.example.achiose.airwatch.BaseView

/**
 * Created by achiose on 26/12/17.
 */
interface BuildingContract {
    interface View : BaseView<Presenter> {
//        fun setUpRecyclerView()
    }

    interface Presenter : BasePresenter{
        fun fetchBuilding(location : String)
    }
}