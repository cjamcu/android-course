package com.cjamcu.earthquakemonitor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cjamcu.earthquakemonitor.databinding.EqListItemBinding

class EqAdapter : ListAdapter<Earthquake, EqAdapter.EqViewHolder>(DiffCallback) {
    companion object DiffCallback : DiffUtil.ItemCallback<Earthquake>() {
        override fun areItemsTheSame(oldItem: Earthquake, newItem: Earthquake): Boolean {
            return oldItem.id === newItem.id
        }

        override fun areContentsTheSame(oldItem: Earthquake, newItem: Earthquake): Boolean {
            return oldItem == newItem
        }

    }

    lateinit var onItemClickListener: (Earthquake) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EqAdapter.EqViewHolder {

        return EqViewHolder(
            EqListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: EqAdapter.EqViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class EqViewHolder(private val binding: EqListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(eq: Earthquake) {
            binding.eqMagnitudeText.text = eq.magnitude.toString()
            binding.eqPlaceText.text = eq.place
            binding.root.setOnClickListener {
                onItemClickListener(eq)
            }
        }

    }
}