package net.noor.planetsapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_planet_details.*
import android.support.v4.view.ViewCompat.setTransitionName
import android.os.Build




class PlanetDetailsActivity : AppCompatActivity() {

    var planet: Planet = Planet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_details)

        planet = intent.getParcelableExtra(INTENT_PLANET)

        planetImageView.setImageResource(planet.image)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val imageTransitionName = planet.name
            planetImageView.setTransitionName(imageTransitionName)
        }

        toolbar.setTitle(planet.name)

        setSupportActionBar(toolbar)
    }

    companion object {

        private val INTENT_PLANET = "planet"

        fun start(context: Context, planet: Planet, imageView: ImageView) {
            val intent = Intent(context, PlanetDetailsActivity::class.java)
            intent.putExtra(INTENT_PLANET, planet)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                context as Activity,
                imageView,
                ViewCompat.getTransitionName(imageView)!!
            )
            context.startActivity(intent , options.toBundle())
        }
    }
}
