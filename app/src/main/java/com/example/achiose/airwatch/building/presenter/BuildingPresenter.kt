package com.example.achiose.airwatch.building.presenter

import android.support.v7.widget.LinearLayoutManager
import com.example.achiose.airwatch.MeetingRoomApiService
import com.example.achiose.airwatch.building.contract.BuildingContract
import com.example.achiose.airwatch.building.model.Building
import com.example.achiose.airwatch.building.view.adapter.BuildingsAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by achiose on 26/12/17.
 */
class BuildingPresenter(val view : BuildingContract.View) : BuildingContract.Presenter {

    private lateinit var buildingList : MutableList<Building>

    init {
        start()
    }

    override fun start() {
        view.setPresenter(this)
    }

    override fun fetchBuilding(location: String) {
        view.showProgressBar(true)
        val buidingsList = MeetingRoomApiService.create().getBuildings(location)
        buidingsList.enqueue(object : Callback<List<Building>> {
            override fun onResponse(call: Call<List<Building>>?, response: Response<List<Building>>?) {
                view.showProgressBar(false)
                response?.body()?.let {
                    buildingList = it.toMutableList()
                    populateAdapter()
                }
            }

            override fun onFailure(call: Call<List<Building>>?, t: Throwable?) {
                view.showProgressBar(false)
                view.showError(t?.toString() ?: "Error")
            }
        })
    }

    fun populateAdapter() {
        view.recyclerView().layoutManager = LinearLayoutManager(view.recyclerView().context)
        view.recyclerView().adapter = BuildingsAdapter(buildingList) {
            view.onBuildingClicked(it)
        }
    }
}