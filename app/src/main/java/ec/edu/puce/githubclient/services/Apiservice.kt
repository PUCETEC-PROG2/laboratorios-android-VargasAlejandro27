package ec.edu.puce.githubclient.services

import ec.edu.puce.githubclient.models.Repository
import retrofit2.http.GET
import retrofit2.http.Query

interface Apiservice {
    @GET(value = "/user/repos")
    suspend fun getRepositories (
        @Query (value = "affilition") affiliation: String = "owner",
        @Query(value = "sort") sort: String = "created",
        @Query(value = "direction") direction: String = "desc",
        @Query(value = )
        @Query
    )
}