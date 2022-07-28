package com.example.mypost
import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.TextView
    import androidx.recyclerview.widget.RecyclerView

class RvCommentsAdapter(var commentList:List<comments>):RecyclerView.Adapter<CommentsViewHolder> (){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
            var itemView=LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_viewpostactivity,parent,false)
            return CommentsViewHolder(itemView)

        }
        override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
            var currentComment=commentList.get(position)
            holder.tv.text= currentComment.email
            holder.textView.text=currentComment.name
            holder.tvemail.text=currentComment.body
//            holder.tvView.text=currentComment.

        }

        override fun getItemCount(): Int {
            return commentList.size
        }
    }
    class CommentsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var tv=itemView.findViewById<TextView>(R.id.tvid)
        var textView=itemView.findViewById<TextView>(R.id.tvtitle)
        var tvemail=itemView.findViewById<TextView>(R.id.tvuserid)
//        var tvView=itemView.findViewById<TextView>(R.id.tvbody)

    }
