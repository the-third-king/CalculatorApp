package com.example.calculatorapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView

/**
 * this class shows a list of views in the recycler view
 * @param moves list of moves
 */
class MoveAdapter (private val moves: MutableList<Move>) : RecyclerView.Adapter<MoveAdapter.MoveViewHolder>() {

    /**
     * this class holds the layout of the recycler view
     * @param itemView is a view
     */
    class MoveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    /**
     * this function creates the view holder for the previous moves
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     * an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoveViewHolder {
        return MoveViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.prev_attacks,
            parent,
            false))
    }

    /**
     * bind the data from the moves list to the view of the list
     * @param holder The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: MoveViewHolder, position: Int) {
        val curMove = moves[position]
        holder.itemView.apply{
        }
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int {
        return moves.size
    }
}