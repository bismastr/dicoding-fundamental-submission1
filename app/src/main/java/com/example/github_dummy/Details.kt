package com.example.github_dummy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.github_dummy.databinding.ActivityDetailsBinding

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
        val atSymbol = getString(R.string.at)
        //Data binding
        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User
        binding.tvName.text = user.name
        binding.tvCompany.text = user.company
        binding.tvFollower.text = user.follower
        binding.tvFollowing.text = user.following
        binding.tvUsername.text = String.format(atSymbol + user.username)
        binding.tvLocation.text = user.location
        binding.imgAvatar.setImageResource(user.avatar)
        //Share
        binding.btnShare.setOnClickListener {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "I'm sharing ${binding.tvName.text} profile, with ${binding.tvFollower.text} follower and ${binding.tvFollowing.text} following. this user username is ${binding.tvUsername.text}")
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Check this GitHub Profile!")
            startActivity(Intent.createChooser(shareIntent, "Share text via"))
        }
    }


}