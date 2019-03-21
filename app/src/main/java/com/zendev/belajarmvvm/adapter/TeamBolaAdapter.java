package com.zendev.belajarmvvm.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zendev.belajarmvvm.R;
import com.zendev.belajarmvvm.model.TeamDetail;

import java.util.List;

public class TeamBolaAdapter extends RecyclerView.Adapter<TeamBolaAdapter.TeamBolaHolder> {

    private List<TeamDetail> listKlubBola;

    public TeamBolaAdapter(List<TeamDetail> listKlubBola) {
        this.listKlubBola = listKlubBola;
    }

    @NonNull
    @Override
    public TeamBolaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row, viewGroup, false);

        return new TeamBolaHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamBolaHolder teamBolaHolder, int i) {
        TeamDetail data = listKlubBola.get(i);
        teamBolaHolder.clubName.setText(data.getTeamName());
        Picasso.get().load(data.getTeamLogo()).into(teamBolaHolder.clubImage);

    }

    @Override
    public int getItemCount() {
        return listKlubBola.size();
    }

    public class TeamBolaHolder extends RecyclerView.ViewHolder {

        TextView clubName;
        ImageView clubImage;

        public TeamBolaHolder(@NonNull View itemView) {
            super(itemView);
            clubName = itemView.findViewById(R.id.txt_item_club_name);
            clubImage = itemView.findViewById(R.id.item_club_img);
        }
    }
}
