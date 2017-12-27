package com.example.achiose.airwatch.building.presenter

/**
 * Created by achiose on 26/12/17.
 */
class BuildingPresenter(val view : BuildingContract.View) : BuildingContract.Presenter {

    init {
        view.setPresenter(this)
    }
    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fetchBuilding(location: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun populateAdapter() {
//        view.setUpRecyclerView()
    }
}