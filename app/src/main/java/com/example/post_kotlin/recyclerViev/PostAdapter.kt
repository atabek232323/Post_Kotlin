package com.example.post_kotlin.recyclerViev

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.post_kotlin.R
import com.example.post_kotlin.databinding.ListPostBinding
import com.example.post_kotlin.model.Post

class PostAdapter : RecyclerView.Adapter<PostAdapter.PostVievHolder>() {
    var list: List<Post> = emptyList()
    private lateinit var binding: ListPostBinding


    class PostVievHolder(val binding: ListPostBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post) {

            binding.textView.text = post.id.toString()
            binding.textView2.text = post.userId.toString()
            binding.textView3.text = post.body
            binding.textView4.text = post.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostVievHolder {
        binding = ListPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostVievHolder(binding)
    }

    override fun onBindViewHolder(holder: PostVievHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(list: List<Post>) {
        this.list = list
        notifyDataSetChanged()
    }
}