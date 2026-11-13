package com.example.project_jelajah_riau.Rencana

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project_jelajah_riau.R
import com.example.project_jelajah_riau.databinding.ItemRencanaBinding

class RencanaAdapter(
    private val rencanaList: List<RencanaModel>,
    private val onItemClick: (RencanaModel) -> Unit
) : RecyclerView.Adapter<RencanaAdapter.RencanaViewHolder>() {
    inner class RencanaViewHolder(val binding: ItemRencanaBinding) :
        RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RencanaViewHolder {
        val binding = ItemRencanaBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return RencanaViewHolder(binding)
    }
    override fun onBindViewHolder(holder: RencanaViewHolder, position: Int) {
        val item = rencanaList[position]
        val context = holder.itemView.context
        with(holder.binding) {
            tvNama.text = item.nama
            tvInfo.text = "${item.daerah} · ${item.tanggal}"
            tvStatus.text = item.status
            // Warna badge mengikuti status
            if (item.status == "Disimpan") {
                tvStatus.setBackgroundResource(R.drawable.bg_badge_hati)
                tvStatus.setTextColor(ContextCompat.getColor(context, R.color.teks_utama))
            } else {
                tvStatus.setBackgroundResource(R.drawable.bg_badge_normal)
                tvStatus.setTextColor(ContextCompat.getColor(context, R.color.hijau_rimba))
            }
            Glide.with(context)
                .load(item.imageUrl)
                .into(imgRencana)
            root.setOnClickListener { onItemClick(item) }
        }
    }
    override fun getItemCount(): Int = rencanaList.size
}