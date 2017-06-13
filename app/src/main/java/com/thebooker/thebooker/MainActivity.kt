package com.thebooker.thebooker

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.thebooker.thebooker.api.ApiClient
import com.thebooker.thebooker.model.Match
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

class MainActivity : AppCompatActivity() {

    private val subscriptions: CompositeSubscription = CompositeSubscription()

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_matches -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_more_soon -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val recyclerView = findViewById(R.id.matches_view) as RecyclerView

        val matchAdapter = MatchAdapter()
        recyclerView.adapter = matchAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        val apiClient = ApiClient()
        val matchesObservable = apiClient.theBookerApi.getMatches()

        subscriptions.add(
                matchesObservable
                        .subscribeOn(Schedulers.io())
                        .subscribe({ matches: List<Match>? -> matchAdapter.setItems(matches ?: emptyList()) })
        )

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
