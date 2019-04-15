package rezaberlian_id.sch.smktelkom_mlg.learn.materi6

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log.d
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiService::class.java)

        api.fetchAllUsers().enqueue(object : Callback<List<User>>{
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>> ){
                showData(response.body()!!)

            }
            override fun onFailure(call: Call<List<User>>,t: Throwable){
                d("daniel","onFailure")
            }
        })

        val users = mutableListOf<User>()
        for(i in 0..100){
            users.add(User("Daniel","Malone","danieljmalone@gmail.com", "512-111-1111"))
        }

        }
        private fun showData(users: List<User>){
            recyclerView.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = UserAdapter(users)

        }
    }
}
