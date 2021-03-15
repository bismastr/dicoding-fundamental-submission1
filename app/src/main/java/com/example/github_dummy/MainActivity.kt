package com.example.github_dummy

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.github_dummy.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
private lateinit var userAdapter: UserRecyclerViewAdapter
private lateinit var dataName: Array<String>
private lateinit var dataUsername: Array<String>
private lateinit var dataAvatar: TypedArray
private lateinit var dataFollower: Array<String>
private lateinit var dataFollowing: Array<String>
private lateinit var dataCompany: Array<String>
private lateinit var dataLocation: Array<String>
private lateinit var dataRepo: Array<String>
private var users = arrayListOf<User>()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepare()
        addItem()
        initRecylerview()
        //submit data to adapter
        userAdapter.submitList(users)

    }


    //init Recyclerview
    private fun initRecylerview() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        userAdapter = UserRecyclerViewAdapter()
        binding.recyclerView.adapter = userAdapter
        userAdapter.setOnItemClickCallback(object : UserRecyclerViewAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                val moveDetails = Intent(this@MainActivity, Details::class.java)
                moveDetails.putExtra(Details.EXTRA_USER, data)
                startActivity(moveDetails)
            }
        })

    }
    //prepare data
    private fun prepare() {
        dataName = resources.getStringArray(R.array.name)
        dataUsername = resources.getStringArray(R.array.username)
        dataFollower = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
        dataCompany = resources.getStringArray(R.array.company)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepo = resources.getStringArray(R.array.repository)
        dataAvatar = resources.obtainTypedArray(R.array.avatar)
    }
    //add data
    private fun addItem() {
        for (position in dataName.indices) {
            val user = User(
                    dataAvatar.getResourceId(position, -1),
                    dataUsername[position],
                    dataName[position],
                    dataCompany[position],
                    dataLocation[position],
                    dataFollower[position],
                    dataFollowing[position],
                    dataRepo[position]
            )
            users.add(user)
        }
    }

}