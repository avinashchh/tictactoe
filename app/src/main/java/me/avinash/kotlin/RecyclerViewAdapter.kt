package me.avinash.kotlin

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.avinash.kotlin.RecyclerViewAdapter.RecyclerViewHolder
import me.avinash.learn.kotlin.coroutines.R

class RecyclerViewAdapter(
    private val courseDataArrayList: ArrayList<RecyclerData>,
    private val mcontext: Context
) : RecyclerView.Adapter<RecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        // Inflate Layout
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        // Set the data to textview and imageview.
        val recyclerData = courseDataArrayList[position]
        if (recyclerData.type == 0) {
            holder.courseTV.text = "O"
        }
        if (recyclerData.type == 1) {
            holder.courseTV.text = "1"
        }
        holder.courseTV.setOnClickListener { view: View? ->
            courseDataArrayList[position].type = 1
            notifyDataSetChanged()
            playCpuMove()
        }
    }

    private fun playCpuMove() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            for (i in courseDataArrayList.indices) {
                if (courseDataArrayList[i].type == -1) {
                    courseDataArrayList[i].type = 0
                    notifyDataSetChanged()
                    break
                }
            }
        }
    }

    override fun getItemCount(): Int {
        // this method returns the size of recyclerview
        return courseDataArrayList.size
    }

    // View Holder Class to handle Recycler View.
    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var courseTV: TextView

        init {
            courseTV = itemView.findViewById(R.id.tv_value)
        }
    }
}