package com.cjamcu.earthquakemonitor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class EqAdapter :  ListAdapter<Earthquake,EqAdapter.EqViewHolder>(DiffCallback){
    companion object DiffCallback : DiffUtil.ItemCallback<Earthquake>(){
        override fun areItemsTheSame(oldItem: Earthquake, newItem: Earthquake): Boolean {
            return oldItem.id === newItem.id
        }

        override fun areContentsTheSame(oldItem: Earthquake, newItem: Earthquake): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EqAdapter.EqViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.eq_list_item,parent,false)
        return EqViewHolder(view)
    }

    override fun onBindViewHolder(holder: EqAdapter.EqViewHolder, position: Int) {
        val eq = getItem(position)
        holder.magnitudeTextView.text = eq.magnitude.toString()
        holder.placeTextView.text = eq.place

    }

    inner class EqViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        val magnitudeTextView = view.findViewById<TextView>(R.id.eq_magnitude_text)
        val placeTextView = view.findViewById<TextView>(R.id.eq_place_text)




    }
}