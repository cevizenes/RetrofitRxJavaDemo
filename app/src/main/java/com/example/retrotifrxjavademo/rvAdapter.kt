package com.example.retrotifrxjavademo

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrotifrxjavademo.databinding.RvBinding
import kotlinx.android.synthetic.main.rv.view.*


class rvAdapter(private val foodList: ArrayList<Food>): RecyclerView.Adapter<rvAdapter.Holder>() {

    class Holder(val binding: RvBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = RvBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.foodName.text = foodList.get(position).name
        holder.binding.calori.text = foodList.get(position).calori
        holder.binding.carbonhidrat.text = foodList.get(position).carbonhidrat
        holder.binding.protein.text = foodList.get(position).protein
        holder.binding.oil.text = foodList.get(position).oil
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