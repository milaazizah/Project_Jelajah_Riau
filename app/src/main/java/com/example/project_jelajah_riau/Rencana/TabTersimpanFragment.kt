package com.example.project_jelajah_riau.Rencana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_jelajah_riau.R
import com.example.project_jelajah_riau.databinding.FragmentTabRiwayatBinding
import com.example.project_jelajah_riau.databinding.FragmentTabTersimpanBinding

class TabTersimpanFragment : Fragment() {

    private var _binding: FragmentTabTersimpanBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTabTersimpanBinding.inflate(inflater, container, false)
        return binding.root
    }
    private val rencanaList = listOf(
        RencanaModel("Ulu Kasok", "Kampar", "Belum dijadwalkan", "Disimpan", "https://genpi.id/wp-content/uploads/2020/09/WhatsApp-Image-2020-09-05-at-7.21.09-AM.jpeg"),
        RencanaModel("Batu Dinding", "Kampar", "Belum dijadwalkan", "Disimpan", "https://media.zcreators.id/crop/0x0:0x0/750x500/photo/indizone/2022/07/26/OjsN9e8/air-terjun-batu-dinding-kampar-penuh-tantangan-untuk-mendatanginya22.jpg"),
        RencanaModel("Pantai Selat Baru", "Bengkalis", "Belum dijadwalkan", "Disimpan", "https://img.cnt.traveloka.com/tvlk/dam/i/01kw3vhpt0j1s3a8bcpr7e746y.jpg")
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
        binding.rvTabB.apply {
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