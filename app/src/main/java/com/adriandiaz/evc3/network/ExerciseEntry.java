package com.adriandiaz.evc3.network;

import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

import com.adriandiaz.evc3.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ExerciseEntry  {
    private static final String TAG = ExerciseEntry.class.getSimpleName();

    public final String title;
    public final Uri dynamicUrl;
    public final String url;
    public final String duration;
    public final String description;

    public ExerciseEntry(String title, String dynamicUrl, String url, String duration, String description) {
        this.title = title;
        this.dynamicUrl = Uri.parse(dynamicUrl);
        this.url = url;
        this.duration = duration;
        this.description = description;
    }

    public static List<ExerciseEntry> initExerciseEntryList(Resources resources) {
        InputStream inputStream = resources.openRawResource(R.raw.exercise);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            int pointer;
            while ((pointer = reader.read(buffer)) != -1) {
                writer.write(buffer, 0 , pointer);
            }
        } catch (IOException exception){
            Log.e(TAG, "Hubo un error al momento de leer y escribir el archivo JSON.", exception);
        } finally {
            try {
                inputStream.close();
            } catch (IOException exception) {
                Log.e(TAG, "Hubo error al cerrar el input stream", exception);
            }
        }

        String jsonExerciseString = writer.toString();
        Gson gson = new Gson();
        Type exerciseListType = new TypeToken<ArrayList<ExerciseEntry>>(){
        }.getType();

        return gson.fromJson(jsonExerciseString, exerciseListType);
    }
}
