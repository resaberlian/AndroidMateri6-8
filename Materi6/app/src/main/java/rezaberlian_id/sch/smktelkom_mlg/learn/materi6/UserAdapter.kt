package rezaberlian_id.sch.smktelkom_mlg.learn.materi6

import android.support.v7.widget.RecyclerView
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.user_row.view.*

class UserAdapter(private val users: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.user_row, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val user = users[position]
        d("daniel","phone number? ${user.phone}" )
        holder.firstName.text = user.phone
        holder.lastName.text = user.lastName
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val firstName: TextView = itemView.firstName
        val lastName: TextView = itemView.lastName
    }
}

