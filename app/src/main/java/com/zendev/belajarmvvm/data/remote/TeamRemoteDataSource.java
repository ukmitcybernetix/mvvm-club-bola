package com.zendev.belajarmvvm.data.remote;

import com.zendev.belajarmvvm.data.TeamDataSource;
import com.zendev.belajarmvvm.model.Team;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamRemoteDataSource implements TeamDataSource {

    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    @Override
    public void getListTeams(final GetTeamCallback callback) {
        retrofit2.Call<Team> call = apiInterface.getAllTeams("Spanish La Liga");
        call.enqueue(new Callback<Team>() {
            @Override
            public void onResponse(retrofit2.Call<Team> call, Response<Team> response) {
                callback.onTeamLoaded(response.body());
            }

            @Override
            public void onFailure(Call<Team> call, Throwable t) {
                callback.onDataNotAvailable(t.toString());
            }
        });
    }
}
