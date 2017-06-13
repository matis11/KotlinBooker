package com.thebooker.thebooker

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.thebooker.thebooker.model.Match
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.Observable;

class MatchAdapter : RecyclerView.Adapter<MatchAdapter.ViewHolder>() {

    private var mItems: MutableList<Match> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.main_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mItems[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun setItems(newItems: List<Match>) {
        mItems = newItems.toMutableList()

        Observable.just(1)
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe({ notifyDataSetChanged() })

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val firstBookTitle = itemView.findViewById(R.id.first_book_title) as TextView
        val firstBookAuthor = itemView.findViewById(R.id.first_book_author) as TextView
        val firstBookCover = itemView.findViewById(R.id.first_book_cover) as ImageView

        val secondLayout = itemView.findViewById(R.id.second_layout) as LinearLayout
        val secondBookTitle = itemView.findViewById(R.id.second_book_title) as TextView
        val secondBookAuthor = itemView.findViewById(R.id.second_book_author) as TextView
        val secondBookCover = itemView.findViewById(R.id.second_book_cover) as ImageView

        val offerLayout = itemView.findViewById(R.id.offer_layout) as LinearLayout
        val offerTitle = itemView.findViewById(R.id.offer_title) as TextView
        val offerDescription = itemView.findViewById(R.id.offer_description) as TextView
        val tradeIcon = itemView.findViewById(R.id.trade_icon) as ImageView

        fun bind(match: Match) {
            if (match.offer != null) {
                tradeIcon.visibility = View.GONE
                secondLayout.visibility = View.GONE
                offerLayout.visibility = View.VISIBLE

                offerTitle.text = match.offer.title
                offerDescription.text = match.offer.description

                firstBookTitle.text = match.offer.bookTitle
                firstBookAuthor.text = match.offer.bookAuthor

                Glide.with(itemView.context)
                        .load(match.offer.bookCoverLink)
                        .into(firstBookCover)

                return
            }

            firstBookTitle.text = match.sourceUserBook?.title
            firstBookAuthor.text = match.sourceUserBook?.author

            Glide.with(itemView.context)
                    .load(match.sourceUserBook?.coverLink)
                    .into(firstBookCover)

            secondBookTitle.text = match.targetUserBook?.title
            secondBookAuthor.text = match.targetUserBook?.author
            Glide.with(itemView.context)
                    .load(match.targetUserBook?.coverLink)
                    .into(secondBookCover)
        }
    }
}