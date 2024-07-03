package com.abutsko.auratestapp.screen.main

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abutsko.auratestapp.R
import com.abutsko.auratestapp.data.local.BootCountLocal
import com.abutsko.auratestapp.databinding.ItemBootBinding
import com.abutsko.auratestapp.utils.dateWithoutTime

class BootAdapter(private val context: Context) :
    RecyclerView.Adapter<BootAdapter.BootViewHolder>() {

    private val newsItemList: MutableList<BootCountLocal> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(list: List<BootCountLocal>) {
        newsItemList.clear()
        newsItemList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BootViewHolder {
        val binding = ItemBootBinding.inflate(LayoutInflater.from(context), parent, false)
        return BootViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BootViewHolder, position: Int) {
        val foodItem = newsItemList[position]
        holder.bind(foodItem)
    }

    override fun getItemCount(): Int {
        return newsItemList.size
    }


    class BootViewHolder(itemBootBinding: ItemBootBinding) :
        RecyclerView.ViewHolder(itemBootBinding.root) {

        private val binding = itemBootBinding

        fun bind(boot: BootCountLocal) {
            with(binding) {
                tvBootTime.text = root.context.getString(R.string.boot_text, boot.date.dateWithoutTime(), boot.times)
            }
        }

    }
}