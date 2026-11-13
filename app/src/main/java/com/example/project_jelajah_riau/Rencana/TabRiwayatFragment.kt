package com.example.project_jelajah_riau.Rencana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_jelajah_riau.R
import com.example.project_jelajah_riau.databinding.FragmentTabRencanaBinding
import com.example.project_jelajah_riau.databinding.FragmentTabRiwayatBinding

class TabRiwayatFragment : Fragment() {
    private var _binding: FragmentTabRiwayatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTabRiwayatBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val rencanaList = listOf(
        RencanaModel("Pantai Selat Baru", "Bengkalis", "12 Okt 2026", "Selesai", "https://img.cnt.traveloka.com/tvlk/dam/i/01kw3vhpt0j1s3a8bcpr7e746y.jpg"),
        RencanaModel("Danau Zamrud", "Siak", "5 Sep 2026", "Selesai", "https://awsimages.detik.net.id/community/media/visual/2021/02/04/dev-danau-zamrud-si-hijau-dari-riau-1.jpeg?w=600&q=90"),
        RencanaModel("Ulu Kasok", "Kampar", "15 Agu 2026", "Selesai", "https://genpi.id/wp-content/uploads/2020/09/WhatsApp-Image-2020-09-05-at-7.21.09-AM.jpeg")
    )
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rencanaAdapter = RencanaAdapter(rencanaList) { selectedItem ->
            Toast.makeText(
                requireContext(),
                "Anda memilih ${selectedItem.nama}",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.rvTabC.apply {
// Mode Linear (daftar ke bawah)
            layoutManager = LinearLayoutManager(requireContext())
// Jika ingin mode Grid 2 kolom:
// layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = rencanaAdapter
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}