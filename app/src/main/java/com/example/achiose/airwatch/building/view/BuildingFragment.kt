package com.example.achiose.airwatch.building.view

import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.achiose.airwatch.R
import com.example.achiose.airwatch.building.view.adapter.BuildingsAdapter
import com.example.achiose.airwatch.building.model.Building
import com.example.achiose.airwatch.building.presenter.BuildingContract
import com.example.achiose.airwatch.building.presenter.BuildingPresenter
import kotlinx.android.synthetic.main.building_fragment_layout.view.*

/**
 * Created by achiose on 15/12/17.
 */
class BuildingFragment : Fragment(), BuildingContract.View {

    private lateinit var rootView : View
    private lateinit var presenter : BuildingContract.Presenter

    companion object {

        fun newInstance(location : String): BuildingFragment {
            val fragment = BuildingFragment()
            val bundle = Bundle()
            bundle.putString("location", location)

            fragment.arguments = bundle

            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        BuildingPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        rootView = inflater!!.inflate(R.layout.building_fragment_layout, container, false)

        rootView.recycler_view.layoutManager = LinearLayoutManager(activity)

        (activity as AppCompatActivity).supportActionBar?.let {
            it.setHomeButtonEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }

        arguments?.let({
            updateContent(it.get("location") as String)
        })

        return rootView
    }

    override fun setPresenter(presenter: BuildingContract.Presenter) {
        this.presenter = presenter
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun updateContent(location : String) {
        rootView.recycler_view.adapter = BuildingsAdapter(populateBuildingList(location)) {
            Toast.makeText(activity, it.name, Toast.LENGTH_SHORT).show()
        }
    }

    fun populateBuildingList(location : String) : ArrayList<Building> {
        val buildingList = ArrayList<Building>()

//        buildingList.add(Building(location))
//        buildingList.add(Building("American Airlines"))
//        buildingList.add(Building("Madison Square Garden"))
//        buildingList.add(Building("Oracle Arena"))
//        buildingList.add(Building("TD Garden"))
//        buildingList.add(Building("Staples Center"))
//        buildingList.add(Building("Arena Corinthians"))

        return buildingList
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        item?.let {
            when (it.itemId) {
                android.R.id.home ->  (activity as AppCompatActivity).supportFragmentManager.popBackStack()
            }
        }

        return super.onOptionsItemSelected(item)
    }


}

