package com.example.project_jelajah_riau.Rencana

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.project_jelajah_riau.databinding.FragmentRencanaBinding
import com.google.android.material.tabs.TabLayoutMediator

class RencanaFragment : Fragment() {
    private var _binding: FragmentRencanaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRencanaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Rencana"
        // 1. Inisialisasi adapter
        val tabsAdapter = RencanaTabsAdapter(this)
        // 2. Pasang adapter ke ViewPager2
        binding.viewPager.adapter = tabsAdapter
        // 3. Hubungkan TabLayout dan ViewPager2
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
        // Atur judul untuk setiap tab
            when (position) {
                0 -> {
                    tab.text = "Rencana Saya"
                }
                1 -> {
                    tab.text = "Tersimpan"
                }
                2 -> {
                    tab.text = "Riwayat"
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                    badge.number = 2
                }
            }
        }.attach()

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}