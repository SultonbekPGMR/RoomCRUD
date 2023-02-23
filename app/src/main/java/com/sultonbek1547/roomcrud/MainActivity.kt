package com.sultonbek1547.roomcrud

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sultonbek1547.roomcrud.adapter.RvAdapter
import com.sultonbek1547.roomcrud.databinding.ActivityMainBinding
import com.sultonbek1547.roomcrud.databse.AppDatabase
import com.sultonbek1547.roomcrud.databse.MyUser

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var rvAdapter: RvAdapter
    private lateinit var appDatabase: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        appDatabase = AppDatabase.getInstance(this)
        rvAdapter = RvAdapter(this, appDatabase.myUserDao().getAllUser() as ArrayList<MyUser>)

        binding.myRv.adapter = rvAdapter

        binding.apply {
            btnSave.setOnClickListener {
                val user = MyUser()
                user.name = edtName.text.toString().trim()
                user.number = edtNumber.text.toString().trim()
                appDatabase.myUserDao().addUser(user)
                user.id = appDatabase.myUserDao().getUserById(user.name!!, user.number!!)
                rvAdapter.list.add(user)
                rvAdapter.notifyItemInserted(rvAdapter.itemCount)

            }

        }


    }
}