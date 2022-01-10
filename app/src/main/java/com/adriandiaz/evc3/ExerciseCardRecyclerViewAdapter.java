package com.adriandiaz.evc3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adriandiaz.evc3.network.ExerciseEntry;
import com.adriandiaz.evc3.network.ImageRequester;

import java.util.List;

public class ExerciseCardRecyclerViewAdapter extends RecyclerView.Adapter<ExerciseCardViewHolder> {
    private List<ExerciseEntry> exerciseList;
    private ImageRequester imageRequester;

    ExerciseCardRecyclerViewAdapter(List<ExerciseEntry> exerciseList){
        this.exerciseList = exerciseList;
        imageRequester = ImageRequester.getInstance();
    }

    @NonNull
    @Override
    public ExerciseCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercise_card, parent, false);
        return new ExerciseCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseCardViewHolder holder, int position) {
        if (exerciseList != null & position < exerciseList.size()) {
            ExerciseEntry exercise = exerciseList.get(position);
            holder.exerciseTitle.setText(exercise.title);
            holder.exerciseDuration.setText(exercise.duration);
            imageRequester.setImageFromUrl(holder.exerciseImage, exercise.url);
        }
    }
    @Override
    public  int getItemCount() {
        return exerciseList.size();
    }

}

