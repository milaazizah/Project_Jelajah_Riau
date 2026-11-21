package com.example.project_jelajah_riau.Rencana

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project_jelajah_riau.data.entity.RencanaEntity
import com.example.project_jelajah_riau.databinding.ItemRencanaSayaBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class RencanaSayaAdapter(
    private val rencanaList: List<RencanaEntity>,
    private val onDelete: (RencanaEntity) -> Unit
) : RecyclerView.Adapter<RencanaSayaAdapter.RencanaSayaViewHolder>() {

    class RencanaSayaViewHolder(val binding: ItemRencanaSayaBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RencanaSayaViewHolder {
        val binding = ItemRencanaSayaBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return RencanaSayaViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: RencanaSayaViewHolder,
        position: Int
    ) {
        val rencana = rencanaList[position]
        holder.binding.tvNama.text = rencana.nama
        holder.binding.tvInfo.text = "${rencana.daerah} · ${rencana.tanggal}"
        holder.binding.tvCatatan.text = rencana.catatan
        holder.binding.tvCatatan.visibility =
            if (rencana.catatan.isBlank()) View.GONE else View.VISIBLE

        holder.binding.btnDelete.setOnClickListener {
            MaterialAlertDialogBuilder(holder.itemView.context)
                .setTitle("Hapus Rencana")
                .setMessage("Yakin ingin menghapus rencana ini?")
                .setPositiveButton("Ya") { _, _ -> onDelete(rencana) }
                .setNegativeButton("Batal", null)
                .show()
        }
    }

    override fun getItemCount(): Int = rencanaList.size
}