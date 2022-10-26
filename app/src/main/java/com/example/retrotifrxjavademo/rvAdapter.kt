package com.example.retrotifrxjavademo

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv.view.*


class rvAdapter(private val foodList: ArrayList<Food>): RecyclerView.Adapter<rvAdapter.Holder>() {

    class Holder(view:View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = LayoutInflater.from(parent.context)
        val view =binding.inflate(R.layout.rv,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.foodName.text = foodList.get(position).name
        holder.itemView.calori.text = foodList.get(position).calori
        holder.itemView.carbonhidrat.text = foodList.get(position).carbonhidrat
        holder.itemView.protein.text = foodList.get(position).protein
        holder.itemView.oil.text = foodList.get(position).oil
    }

    override fun getItemCount(): Int {
       return foodList.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun listOfUpdate(new : List<Food>){
        foodList.clear()
        foodList.addAll(new)
        notifyDataSetChanged()
    }
}