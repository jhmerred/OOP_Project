package com.example.newproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newproject.R
import android.widget.TextView
import android.widget.ImageView

data class Friend(val name: String, val profileImage: String)
class FriendAdapter(private val friendList: List<Friend>) : RecyclerView.Adapter<FriendAdapter.FriendViewHolder>() {

    class FriendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val friendName: TextView = itemView.findViewById(R.id.friendName)
        val friendImage: ImageView = itemView.findViewById(R.id.friendImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_friend, parent, false)
        return FriendViewHolder(view)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        val friend = friendList[position]
        holder.friendName.text = friend.name
        // Assuming the profile image is a URL, you may need to use a library such as Glide or Picasso to load it.
        // Glide.with(holder.itemView.context).load(friend.profileImage).into(holder.friendImage)
    }

    override fun getItemCount() = friendList.size
}

class FriendFragment: Fragment() {
    private lateinit var friendRecyclerView: RecyclerView
    private lateinit var friendAdapter: FriendAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_friend,container,false)
        //Initialize RecyclerView and Adapter
        friendRecyclerView = view.findViewById(R.id.friendRecyclerView)
        friendAdapter = FriendAdapter(loadFriends())
        friendRecyclerView.layoutManager=LinearLayoutManager(context)
        friendRecyclerView.adapter = friendAdapter
        return view
    }
    private fun loadFriends(): List<Friend>{
        //Load your friends data here. This is just a placeholder.
        return listOf(
            Friend("홍길동", "https://example.com/image1.png")
        )
    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment FriendFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            FriendFragment().apply {
//                arguments = Bundle().apply {
//                }
//            }
//    }
}