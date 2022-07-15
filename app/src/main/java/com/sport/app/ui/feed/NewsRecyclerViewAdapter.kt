package com.sport.app.ui.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.textview.MaterialTextView
import com.sport.app.R
import com.sport.app.domain.entity.NewsItem

class NewsRecyclerViewAdapter(
    private val mValues: List<NewsItem>,
    private val mListener: FeedFragment.OnListFragmentInteractionListener?,
    private val context: FragmentActivity?
) : RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener = View.OnClickListener {
        val item = it.tag as NewsItem

//        val pageIntent = Intent(context, NewsPageActivity::class.java)
//        pageIntent.putExtra("page", item.link)
//        context?.startActivity(pageIntent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_news_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.titleTV?.text = item.title
        holder.linkTV?.text = item.link
        holder.contentTV?.text = item.description
        holder.pubDateTV?.text = item.pubDate

        context?.let {
            holder.featuredImg?.let { it1 ->
                Glide.with(it)
                    .load(item.image)
                    .centerCrop()
                    .into(it1)
            }
        }

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val titleTV: MaterialTextView? = mView.findViewById(R.id.txtTitle)
        val linkTV: TextView? = mView.findViewById(R.id.txtLink)
        val contentTV: MaterialTextView? = mView.findViewById(R.id.txtContent)
        val pubDateTV: TextView? = mView.findViewById(R.id.txtPubdate)
        val featuredImg: ImageView? = mView.findViewById(R.id.featuredImg);
    }
}