package edu.rit.memeapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.rit.memeapp.R
import edu.rit.memeapp.data.model.Meme
import edu.rit.memeapp.databinding.MemeItemBinding
import edu.rit.memeapp.util.loadUrl

class MemeAdapter(
    private val onTap: (Meme) -> Unit
): RecyclerView.Adapter<MemeAdapter.MemeViewHolder>() {
    class MemeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = MemeItemBinding.bind(itemView)

        fun bind(meme: Meme){
//            binding.ivMeme.loadUrl(meme.data.image, false)
            binding.tvMemeTop.text = meme.data.topText
            binding.tvMemeBottom.text = meme.data.bottomText
        }
    }

    private var data: List<Meme> = listOf()

    fun setData(new: List<Meme>){
        data = new
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.meme_item, parent, false)
        return MemeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MemeViewHolder, position: Int) {
        val meme = data[position]
        holder.bind(meme)
        holder.itemView.setOnClickListener{
            onTap(meme)
        }
    }
}