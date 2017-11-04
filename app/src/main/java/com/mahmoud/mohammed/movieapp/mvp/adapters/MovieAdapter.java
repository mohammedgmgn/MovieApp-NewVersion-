package com.mahmoud.mohammed.movieapp.mvp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mahmoud.mohammed.movieapp.R;
import com.mahmoud.mohammed.movieapp.mvp.helper.ImageHelper;
import com.mahmoud.mohammed.movieapp.mvp.ui.main.model.Movie;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mohammed on 11/2/2017.
 */
public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Movie> moviesList;
    Context context;
    private OnMovieClickListener onMovieClickListener;

    public MovieAdapter(List<Movie> movies, Context context) {
        this.moviesList = movies;
        this.context = context;
    }

    public void setOnMovieClickListener(OnMovieClickListener onMovieClickListener) {
        this.onMovieClickListener = onMovieClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //we can check here if viewtype =my specifc number

        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row, parent, false);
        Movieholder holder = new Movieholder(row);
        return holder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Movieholder movieholder = (Movieholder) (holder);
        Movie movie = moviesList.get(position);
        movieholder.movie_name.setText(movie.getTitle());
        Log.v("imageUrl", movie.getPosterPath());
        ImageHelper.setGlideImage(context, movie.getPosterPath(), movieholder.moviepic);
        holder.itemView.setOnClickListener(view -> onMovieClickListener.onMovieClicked(movie));

    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public void updateAdapter(List<Movie> movies) {
        this.moviesList.clear();
        this.moviesList.addAll(movies);
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class Movieholder extends RecyclerView.ViewHolder {

        @BindView(R.id.txv_row)
        TextView movie_name;
        @BindView(R.id.movieposteIMG)
        ImageView moviepic;

        public Movieholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }


    }


}