package com.example.achiose.airwatch.building.view

import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.achiose.airwatch.R
import com.example.achiose.airwatch.building.model.Building
import com.example.achiose.airwatch.building.presenter.BuildingContract
import com.example.achiose.airwatch.building.presenter.BuildingPresenter
import kotlinx.android.synthetic.main.building_fragment_layout.*
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
            bundle.putString(LOCATION_BUNDLE_KEY, location)

            fragment.arguments = bundle

            return fragment
        }

        val LOCATION_BUNDLE_KEY = "location_bundle_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        BuildingPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        rootView = inflater!!.inflate(R.layout.building_fragment_layout, container, false)

        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        return rootView
    }

    override fun onResume() {
        super.onResume()

        arguments?.let({
            presenter.fetchBuilding(it.get(LOCATION_BUNDLE_KEY) as String)
        })
    }

    override fun setPresenter(presenter: BuildingContract.Presenter) {
        this.presenter = presenter
    }

    override fun onBuildingClicked(building: Building) {
        Toast.makeText(activity, building.name + " clicked", Toast.LENGTH_SHORT).show()
    }

    override fun showError(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgressBar(show: Boolean) {
        building_progress.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun recyclerView(): RecyclerView {
        return rootView.recycler_view;
    }

    fun updateContent(location : String) {
        presenter.fetchBuilding(location)
    }
}

