package com.adriandiaz.evc3;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;

public class ExerciseCardViewHolder extends RecyclerView.ViewHolder {
    public NetworkImageView exerciseImage;
    public TextView exerciseTitle;
    public TextView exerciseDuration;

    public ExerciseCardViewHolder(@NonNull View itemView) {
        super(itemView);
        exerciseImage = itemView.findViewById(R.id.exercise_image);
        exerciseTitle = itemView.findViewById(R.id.exercise_title);
        exerciseDuration = itemView.findViewById(R.id.exercise_duration);
    }
}
