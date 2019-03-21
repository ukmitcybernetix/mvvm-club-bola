package com.zendev.belajarmvvm.viewmodel;


import android.content.Context;

import com.zendev.belajarmvvm.data.TeamDataSource;
import com.zendev.belajarmvvm.data.TeamRepository;
import com.zendev.belajarmvvm.model.Team;
import com.zendev.belajarmvvm.navigator.TeamNavigator;

public class TeamViewModel {

    private TeamRepository teamRepository;
    private TeamNavigator mNavigator;

    public TeamViewModel(TeamRepository teamRepository, Context context){
        this.teamRepository = teamRepository;
    }

    public void setmNavigator(TeamNavigator navigator){
        mNavigator = navigator;
    }

    public void getListTeam(){
        teamRepository.getListTeams(new TeamDataSource.GetTeamCallback() {
            @Override
            public void onTeamLoaded(Team data) {
                mNavigator.loadListTeam(data.getTeams());
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                mNavigator.errorLoadListTeam(errorMessage);
            }
        });
    }
}
