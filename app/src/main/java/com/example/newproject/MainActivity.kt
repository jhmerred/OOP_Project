package com.example.newproject
import com.example.newproject.view.Friend
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.newproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val friendManager=FriendManager()
    class FriendManager {
        private val friendList = mutableListOf<Friend>()

        fun addFriend(friend: com.example.newproject.view.Friend) {
            friendList.add(friend)
        }
        fun getFriends():List<Friend>{
            return friendList
        }

    }

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)
        // Navigation 그래프 설정
    }
}