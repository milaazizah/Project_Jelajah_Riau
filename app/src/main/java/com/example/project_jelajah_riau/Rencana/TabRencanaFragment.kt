package com.example.project_jelajah_riau.Rencana

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_jelajah_riau.data.AppDatabase
import com.example.project_jelajah_riau.data.entity.RencanaEntity
import com.example.project_jelajah_riau.databinding.FragmentTabRencanaBinding
import kotlinx.coroutines.launch

class TabRencanaFragment : Fragment() {
    private var _binding: FragmentTabRencanaBinding? = null
    private val binding get() = _binding!!
    private lateinit var db: AppDatabase
    private lateinit var adapter: RencanaSayaAdapter
    private val rencanaList = mutableListOf<RencanaEntity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTabRencanaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = AppDatabase.getInstance(requireContext())
        adapter = RencanaSayaAdapter(rencanaList) { rencana -> deleteRencana(rencana) }

        binding.rvTabA.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTabA.adapter = adapter
        binding.fabAddRencana.setOnClickListener {
            startActivity(Intent(requireContext(), RencanaFormActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        if (_binding != null) fetchRencana()
    }

    private fun fetchRencana() {
        viewLifecycleOwner.lifecycleScope.launch {
            val result = db.rencanaDao().getAll()
            rencanaList.clear()
            rencanaList.addAll(result)
            adapter.notifyDataSetChanged()
        }
    }

    private fun deleteRencana(rencana: RencanaEntity) {
        viewLifecycleOwner.lifecycleScope.launch {
            db.rencanaDao().delete(rencana)
            fetchRencana()
        }
    }

    override fun onDestroyView() {
        binding.rvTabA.adapter = null
        _binding = null
        super.onDestroyView()
    }
}