package com.example.github_dummy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.github_dummy.databinding.ActivityDetailsBinding
import com.example.github_dummy.databinding.ActivityMainBinding

class Details : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    companion object {
        const val EXTRA_USER = "EXTRA_USER"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Data binding
        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User
        binding.tvName.text = user.name
        binding.tvCompany.text = user.company
        binding.tvFollower.text = user.follower
        binding.tvFollowing.text = user.following
        binding.tvUsername.text = "@${user.username}"
        binding.tvLocation.text = user.location
        binding.imgAvatar.setImageResource(user.avatar)
    }
}