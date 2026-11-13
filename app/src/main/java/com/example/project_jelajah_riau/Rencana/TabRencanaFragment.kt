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


class TabRencanaFragment : Fragment() {
    private var _binding: FragmentTabRencanaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTabRencanaBinding.inflate(inflater, container, false)
        return binding.root
    }
    private val rencanaList = listOf(
        RencanaModel("Candi Muara Takus", "Kampar", "20 Des 2026", "Terjadwal", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQTfOGTkHYkJypu6vfLGI3xWqqpo2-YrY4GM0IpOq7zVJ4lrp7nZ5h8cCOA&s=10"),
        RencanaModel("Istana Siak", "Siak", "27 Des 2026", "Terjadwal", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4qRWHfb0siO9AD_IE17aSYqvty-sVEmGXPh3gIx0YCNqEzX1VBgB6fFs&s=10"),
        RencanaModel("Pantai Rupat Utara", "Bengkalis", "3 Jan 2027", "Terjadwal", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRRzT-BzyMldyONV93gIECjkcZccDjr1oxp2WRY3m-2pRbXYTQSQbYA_Xlx&s=10"),
        RencanaModel("Danau Zamrud", "Siak", "10 Jan 2027", "Terjadwal", "https://awsimages.detik.net.id/community/media/visual/2021/02/04/dev-danau-zamrud-si-hijau-dari-riau-1.jpeg?w=600&q=90")
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
        binding.rvTabA.apply {
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