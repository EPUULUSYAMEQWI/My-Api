package com.example.mypost


    import android.content.Context
    import android.content.Intent
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.TextView
    import androidx.constraintlayout.widget.ConstraintLayout
    import androidx.recyclerview.widget.RecyclerView

    class PostRvAdapter(var context: Context, var PostList: List<Post>): RecyclerView.Adapter<ViewHolderPost>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPost {
            var itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_main, parent, false)
            return ViewHolderPost(itemView)

        }

        override fun onBindViewHolder(holder: ViewHolderPost, position: Int) {
            var currentPost = PostList.get(position)
            holder.tvName.text = currentPost.userId.toString()
            holder.tvemail.text = currentPost.Id.toString()
            holder.tvbody.text = currentPost.title
            holder.tvbodyLBL.text = currentPost.body
            holder.tvbody.setOnClickListener {
                var intent = Intent(context, ViewPostActivity::class.java)
                intent.putExtra("POST_ID", currentPost.userId)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)

            }


        }

        override fun getItemCount(): Int {
            return PostList.size
        }


    }
    class ViewHolderPost(itemView: View): RecyclerView.ViewHolder(itemView){
        var tvName=itemView.findViewById<TextView>(R.id.tvid)
        var tvemail=itemView.findViewById<TextView>(R.id.tvuserid)
        var tvbody=itemView.findViewById<TextView>(R.id.tvbody)
        var tvbodyLBL=itemView.findViewById<TextView>(R.id.tvtitle)

    }


