package net.noor.drinksapplication.Planets

import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_planet.view.*
import net.noor.planetsapplication.Planet
import net.noor.planetsapplication.PlanetDetailsActivity
import net.noor.planetsapplication.R

/**
 * Created by nsamir on 6/6/2019.
 */

class PlanetsAdapter(private val items: List<Planet>?) : RecyclerView.Adapter<PlanetsAdapter.PlanetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_planet, parent, false)
        return PlanetViewHolder(v)
    }

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        //First 2 items empty and last 1
        if (position != 0 && position != 1 && position <= items!!.size + 1) {
            val item = items[position - 2]
            holder.set(item, position)
        } else {
            holder.emptyItem()
        }
    }

    override fun getItemCount(): Int {
        return items?.size?.plus(4) ?: 0
    }

    inner class PlanetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                if (adapterPosition != 0 && adapterPosition != 1 && adapterPosition <= items!!.size + 1) {
                    PlanetDetailsActivity.start(itemView.context, items!!.get(adapterPosition - 2), it.imageView)
                }
            }
        }

        fun set(item: Planet, position: Int) {
            //UI setting code
            itemView.imageView.setImageResource(item.image)
            itemView.textView.text = item.name
            ViewCompat.setTransitionName(itemView.imageView, item.name);
        }

        fun emptyItem() {
            itemView.imageView.setImageResource(0)
            itemView.textView.text = ""
        }
    }
}
