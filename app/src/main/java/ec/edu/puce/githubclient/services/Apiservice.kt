package ec.edu.puce.githubclient.services

import ec.edu.puce.githubclient.models.Repository
import ec.edu.puce.githubclient.models.RepositoryPayload
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET(value = "/users/{username}/repos")
    suspend fun getRepositories (
        @Path("username") username: String = "VargasAlejandro27",
        @Query(value = "sort") sort: String = "created",
        @Query(value = "direction") direction: String = "desc"
    ): List<Repository>

    @POST(value = "/user/repos")
    suspend fun createRepository (
        @Body repository: RepositoryPayload
    ): Repository
}
