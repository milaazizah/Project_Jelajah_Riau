package com.example.project_jelajah_riau.Rencana

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.project_jelajah_riau.R
import com.example.project_jelajah_riau.data.AppDatabase
import com.example.project_jelajah_riau.data.entity.RencanaEntity
import com.example.project_jelajah_riau.databinding.ActivityRencanaFormBinding
import kotlinx.coroutines.launch

class RencanaFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRencanaFormBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRencanaFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        binding.toolbar.setNavigationOnClickListener { finish() }

        db = AppDatabase.getInstance(this)

        binding.btnSaveRencana.setOnClickListener {
            val nama = binding.etNama.text.toString().trim()
            val daerah = binding.etDaerah.text.toString().trim()
            val tanggal = binding.etTanggal.text.toString().trim()
            val catatan = binding.etCatatan.text.toString().trim()

            if (nama.isBlank() || daerah.isBlank() || tanggal.isBlank()) {
                Toast.makeText(
                    this, "Isi nama, daerah, dan tanggal!", Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            binding.btnSaveRencana.isEnabled = false
            lifecycleScope.launch {
                try {
                    db.rencanaDao().insert(
                        RencanaEntity(
                            nama = nama,
                            daerah = daerah,
                            tanggal = tanggal,
                            catatan = catatan
                        )
                    )
                    finish()
                } catch (e: Exception) {
                    binding.btnSaveRencana.isEnabled = true
                    Toast.makeText(
                        this@RencanaFormActivity,
                        "Gagal menyimpan rencana",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}