package com.sport.app.ui.feed

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.sport.app.databinding.FragmentFeedBinding
import com.sport.app.domain.entity.NewsItem
import kotlinx.coroutines.launch

class FeedFragment : Fragment() {

    private var _binding: FragmentFeedBinding? = null
    private var listener: OnListFragmentInteractionListener? = null

    private val binding get() = _binding!!

    var adapter: NewsRecyclerViewAdapter? = null

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val feedViewModel =
            ViewModelProvider(this)[FeedViewModel::class.java]

        _binding = FragmentFeedBinding.inflate(inflater, container, false)

        binding.listV.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        feedViewModel.news.observe(viewLifecycleOwner) {
            adapter = NewsRecyclerViewAdapter(it, listener, activity)
            binding.listV.adapter = adapter
            adapter!!.notifyDataSetChanged()
        }

        lifecycleScope.launch {
            feedViewModel.getNews()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(item: NewsItem?)
    }
}