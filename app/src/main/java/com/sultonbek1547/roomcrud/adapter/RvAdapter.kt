package com.sultonbek1547.roomcrud.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.sultonbek1547.roomcrud.databinding.RvItemBinding
import com.sultonbek1547.roomcrud.databse.AppDatabase
import com.sultonbek1547.roomcrud.databse.MyUser

class RvAdapter(val context: Context, val list: ArrayList<MyUser>) :
    RecyclerView.Adapter<RvAdapter.Vh>() {
    val appDatabase = AppDatabase.getInstance(context)

    inner class Vh(val itemRvBinding: RvItemBinding) : RecyclerView.ViewHolder(itemRvBinding.root) {

        fun onBind(user: MyUser, position: Int) {

            itemRvBinding.apply {
                tvName.text = user.name
                tvNumber.text = user.number

                itemCard.setOnClickListener {
                    list.removeAt(position)
                    notifyItemRemoved(position)
                    notifyItemRangeChanged(0, itemCount)
                    Toast.makeText(context, "deleted", Toast.LENGTH_SHORT).show()
                    appDatabase.myUserDao().deleteUser(user)

                }

            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) =
        holder.onBind(list[position], position)


    override fun getItemCount(): Int = list.size


}