package com.example.project_jelajah_riau.Rencana

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class RencanaTabsAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {
    // Jumlah total tab yang ada
    override fun getItemCount(): Int = 3
    // Menentukan Fragment yang ditampilkan berdasarkan posisi tab
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabRencanaFragment()
            1 -> TabTersimpanFragment()
            2 -> TabRiwayatFragment()
            else -> throw IllegalStateException("Posisi tidak valid")
        }
    }
}