package com.example.project_jelajah_riau.More

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project_jelajah_riau.R
import com.example.project_jelajah_riau.databinding.FragmentMoreBinding

class MoreFragment : Fragment() {
    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    private val dataListWithDesc = listOf(
        mapOf("title" to "Alam", "desc" to "Pantai, hutan, danau, dan air terjun di Riau"),
        mapOf("title" to "Sejarah", "desc" to "Candi, istana, dan peninggalan kerajaan Melayu"),
        mapOf("title" to "Kuliner", "desc" to "Makanan khas Melayu Riau"),
        mapOf("title" to "Desa Wisata", "desc" to "Wisata budaya dan alam yang dikelola warga desa"),
        mapOf("title" to "Kampar", "desc" to "Rumah Candi Muara Takus dan Ulu Kasok"),
        mapOf("title" to "Siak", "desc" to "Istana Siak dan wisata sungai"),
        mapOf("title" to "Bengkalis", "desc" to "Pantai dan pulau di pesisir timur Riau"),
        mapOf("title" to "Tentang Aplikasi", "desc" to "Jelajah Riau, satu aplikasi untuk menjelajah seluruh Riau")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Lainnya"

        // Adapter: penghubung dataListWithDesc dengan layout simple_list_item_2
        val adapter = SimpleAdapter(
            requireContext(),
            dataListWithDesc,
            android.R.layout.simple_list_item_2,
            arrayOf("title", "desc"),                        // key yang diambil dari data
            intArrayOf(android.R.id.text1, android.R.id.text2) // tempat tampilnya
        )
        binding.listViewItems.adapter = adapter

        // Aksi saat item diklik
        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = dataListWithDesc[position]
            val title = selectedItem["title"]
            val desc = selectedItem["desc"]
            Toast.makeText(requireContext(), "Kamu memilih: $title ($desc)", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}