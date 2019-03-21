package com.zendev.belajarmvvm.navigator;

import com.zendev.belajarmvvm.model.TeamDetail;

import java.util.List;

public interface TeamNavigator {

    void loadListTeam(List<TeamDetail> listTeam);
    void errorLoadListTeam(String message);
}
