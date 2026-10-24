package com.example.project_jelajah_riau.Jelajah

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.project_jelajah_riau.R
import com.example.project_jelajah_riau.databinding.ItemJelajahBinding
import com.google.android.material.snackbar.Snackbar

class JelajahAdapter (
    context: Context,
    private val items: List<JelajahModel>
) : ArrayAdapter<JelajahModel>(context, 0, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemJelajahBinding.inflate(LayoutInflater.from(context), parent, false)
        val view = binding.root
        val data = items[position]

        // Muat gambar dari URL ke ImageView
        Glide.with(context)
            .load(data.fotoUrl)
            .into(binding.fotoImg)

        binding.textNama.text = data.nama
        binding.textLokasi.text = "${data.kabupaten} · ${data.kategori}"
        binding.textRating.text = "${data.rating} · ${data.ulasan} ulasan"
        binding.textTiket.text = data.tiket

        binding.textStatus.text = data.status
        when (data.status) {
            "Normal" -> {
                binding.textStatus.setBackgroundResource(R.drawable.bg_badge_normal)
                binding.textStatus.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_status_normal, 0, 0, 0)
                binding.textStatus.setTextColor(ContextCompat.getColor(context, R.color.hijau_rimba))
            }
            "Hati-hati" -> {
                binding.textStatus.setBackgroundResource(R.drawable.bg_badge_hati)
                binding.textStatus.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_warning, 0, 0, 0)
                binding.textStatus.setTextColor(ContextCompat.getColor(context, R.color.teks_utama))
            }
            else -> {
                binding.textStatus.setBackgroundResource(R.drawable.bg_badge_tutup)
                binding.textStatus.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_tutup, 0, 0, 0)
                binding.textStatus.setTextColor(ContextCompat.getColor(context, R.color.merah_bata))
            }
        }
        // Aksi klik dipasang di adapter, bukan di Fragment
        view.setOnClickListener {
            Snackbar.make(
                parent,
                "${data.nama} · ${data.status} ·${data.tiket}",
                Snackbar.LENGTH_SHORT
            ).show()
        }
        return view
    }
}
