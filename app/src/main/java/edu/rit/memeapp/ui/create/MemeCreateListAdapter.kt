package edu.rit.memeapp.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.rit.memeapp.R
import edu.rit.memeapp.data.model.CreateMeme
import edu.rit.memeapp.data.model.MemeInfo
import edu.rit.memeapp.databinding.CreateMemeItemBinding

class MemeCreateListAdapter: RecyclerView.Adapter<MemeCreateListAdapter.MemeViewHolder>() {

    private var createMemeList = emptyList<CreateMeme>()

    class MemeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = CreateMemeItemBinding.bind(itemView);
         fun bind(meme: CreateMeme){
             binding.tvName.text = meme.name
             binding.tvMemeBottom.text = meme.bottomText
             binding.tvTopText.text = meme.topText
         }
    }

    fun setData(meme: List<CreateMeme>){
        createMemeList = meme
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeViewHolder{
        return MemeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.create_meme_item, parent, false))
    }

    override fun getItemCount(): Int {
        return createMemeList.size
    }

    override fun onBindViewHolder(holder: MemeViewHolder, position: Int) {
        val data = createMemeList[position]
        holder.bind(data)
    }
}