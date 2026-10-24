package com.example.project_jelajah_riau.Jelajah

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.project_jelajah_riau.R
import com.example.project_jelajah_riau.databinding.FragmentJelajahBinding

class JelajahFragment : Fragment() {
    private var _binding: FragmentJelajahBinding? = null
    private val binding get() = _binding!!

    private val destinasiList = listOf(
        JelajahModel("Candi Muara Takus", "Kampar", "Sejarah", "4,8", 128, "Normal", "Rp10.000", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQTfOGTkHYkJypu6vfLGI3xWqqpo2-YrY4GM0IpOq7zVJ4lrp7nZ5h8cCOA&s=10"),
        JelajahModel("Ulu Kasok", "Kampar", "Alam", "4,7", 128, "Hati-hati", "Rp10.000", "https://genpi.id/wp-content/uploads/2020/09/WhatsApp-Image-2020-09-05-at-7.21.09-AM.jpeg"),
        JelajahModel("Batu Dinding", "Kampar", "Alam", "4,6", 128, "Tutup sementara", "Rp15.000", "https://media.zcreators.id/crop/0x0:0x0/750x500/photo/indizone/2022/07/26/OjsN9e8/air-terjun-batu-dinding-kampar-penuh-tantangan-untuk-mendatanginya22.jpg"),
        JelajahModel("Istana Siak", "Siak", "Sejarah", "4,9", 210, "Normal", "Rp15.000", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4qRWHfb0siO9AD_IE17aSYqvty-sVEmGXPh3gIx0YCNqEzX1VBgB6fFs&s=10"),
        JelajahModel("Danau Zamrud", "Siak", "Alam", "4,5", 96, "Normal", "Rp10.000", "https://awsimages.detik.net.id/community/media/visual/2021/02/04/dev-danau-zamrud-si-hijau-dari-riau-1.jpeg?w=600&q=90"),
        JelajahModel("Pantai Rupat Utara", "Bengkalis", "Alam", "4,6", 87, "Hati-hati", "Gratis", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRRzT-BzyMldyONV93gIECjkcZccDjr1oxp2WRY3m-2pRbXYTQSQbYA_Xlx&s=10"),
        JelajahModel("Pantai Selat Baru", "Bengkalis", "Alam", "4,4", 64, "Normal", "Gratis", "https://img.cnt.traveloka.com/tvlk/dam/i/01kw3vhpt0j1s3a8bcpr7e746y.jpg")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJelajahBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Jelajah Riau"

        val adapter = JelajahAdapter(requireContext(), destinasiList)
        binding.listJelajah.adapter = adapter
        binding.txtJumlah.text = "${destinasiList.size} destinasi"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}