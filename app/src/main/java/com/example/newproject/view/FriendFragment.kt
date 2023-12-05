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
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.newproject.MainActivity

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
class AddFriendFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
// Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 뷰를 찾음
        val etName = view.findViewById<EditText>(R.id.et_name)
        val etImageUrl = view.findViewById<EditText>(R.id.et_image_url)
        val btnSubmit = view.findViewById<Button>(R.id.btn_submit)

        // 제출 버튼에 클릭 리스너를 설정
        btnSubmit.setOnClickListener {
            val name = etName.text.toString()
            val imageUrl = etImageUrl.text.toString()

            // 이름과 이미지 URL이 모두 입력되었는지 확인
            if (name.isNotBlank() && imageUrl.isNotBlank()) {
                // 이름과 이미지 URL을 이용해서 새로운 Friend 객체를 생성
                val newFriend = Friend(name, imageUrl)

                // MainActivity에 접근
                (activity as? MainActivity)?.let { mainActivity ->
                    // FriendManager를 이용해서 친구 목록에 추가
                    mainActivity.friendManager.addFriend(newFriend)

                    // 사용자에게 친구가 추가되었다는 것을 알림
                    Toast.makeText(context, "$name 님이 친구 목록에 추가되었습니다.", Toast.LENGTH_SHORT).show()

                    // 친구 목록 화면으로 이동
                    mainActivity.supportFragmentManager.popBackStack()
                }
            } else {
                // 이름이나 이미지 URL이 입력되지 않았다면 사용자에게 알려줌
                Toast.makeText(context, "이름과 이미지 URL을 모두 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
class FriendFragment: Fragment() {
    private fun loadFriends():List<Friend> {
        (activity as? MainActivity)?.let{mainActivity ->
            return mainActivity.friendManager.getFriends()
        }
// 친구 목록 데이터를 로드하는 코드를 여기에 작성합니다.
// 예를 들어, 데이터베이스에서 친구 목록을 조회하거나
// 네트워크 API를 통해 친구 목록을 가져오는 등의 작업을 수행할 수 있습니다.
        return emptyList()
    }
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
        val view = inflater.inflate(R.layout.fragment_friend, container, false)
        //Initialize RecyclerView and Adapter
        friendRecyclerView = view.findViewById(R.id.friendRecyclerView)
        friendAdapter = FriendAdapter(loadFriends())
        friendRecyclerView.layoutManager = LinearLayoutManager(context)
        friendRecyclerView.adapter = friendAdapter

        // Initialize add friend button and set click listener
        val addFriendButton: Button = view.findViewById(R.id.addFriendButton)
        addFriendButton.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, AddFriendFragment())
            transaction?.addToBackStack(null)
            transaction?.commit()
        }

        return view
    }
}