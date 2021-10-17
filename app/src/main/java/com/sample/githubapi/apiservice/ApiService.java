package com.sample.githubapi.apiservice;

import com.sample.githubapi.model.CommitRecord;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("{userName}/{repoName}/commits")
    public Call<List<CommitRecord>> getCommitRecords(@Path("userName") String userName,
                                                     @Path("repoName") String repoName);
}
