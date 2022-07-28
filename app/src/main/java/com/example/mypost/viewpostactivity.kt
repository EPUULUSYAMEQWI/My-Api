package com.example.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import androidx.recyclerview.widget.RecyclerView
import com.example.mypost.databinding.ActivityViewpostactivityBinding

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ViewPostActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewpostactivityBinding
    var postId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewpostactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        postId = intent.getIntExtra("POST_ID", 0)
//        setSupportActionBar(binding.r())
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        getPost()

    }

    fun getPost() {
        var retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = retrofit.getPostsbyId(postId)
        request.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) {
                    binding.tvtitle.text = response.body()?.title
                    binding.tvbody.text = response.body()?.body
                    binding.tvuserid.text = response.body()?.body

                }

            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()


            }

        }
        )
    }
}

