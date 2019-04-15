package rezaberlian_id.sch.smktelkom_mlg.learn.materi6

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/users")
    fun fetchAllUsers(): Call<List<User>>
}