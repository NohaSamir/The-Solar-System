package net.noor.planetsapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_planets.*
import net.noor.drinksapplication.Planets.PlanetsAdapter
import net.noor.drinksapplication.Planets.SnapHelperOneByOne
import net.noor.planetsapplication.CustomListView.HalfCurveLayoutManager

class PlanetsActivity : AppCompatActivity() {

    val images: List<Planet> = listOf(
        Planet("Mercury", "", R.drawable.ic_planet_1),
        Planet("Venus", "", R.drawable.ic_planet_2),
        Planet("Earth", "", R.drawable.ic_planet_9),
        Planet("Mars", "", R.drawable.ic_planet_4),
        Planet("Jupiter", "", R.drawable.ic_planet_5),
        Planet("Saturn", "", R.drawable.ic_planet_6),
        Planet("Uranus", "", R.drawable.ic_planet_7),
        Planet("Neptune", "", R.drawable.ic_planet_8),
        Planet("Pluto", "", R.drawable.ic_planet_9)
    )

    var planetsAdapter: PlanetsAdapter =
        PlanetsAdapter(images)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planets)

        recycler.layoutManager = HalfCurveLayoutManager(this, 7.0f)

        val snapHelper = SnapHelperOneByOne()

        snapHelper.attachToRecyclerView(recycler)

        recycler.adapter = planetsAdapter
    }
}
