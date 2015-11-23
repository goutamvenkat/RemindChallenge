package com.example.venkat.remindchallenge;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.tv.TvSeries;

public class DetailPageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Object obj = extras.get(getString(R.string.object_info));
            if (obj instanceof MovieDb) {
                MovieDb movie = (MovieDb) (obj);
                String title = movie.getOriginalTitle();
                String synopsis = movie.getOverview();
                double score = movie.getPopularity();
                setContentOnPage(title, synopsis, score, movie.getPosterPath());
            } else {
                TvSeries tvShow = (TvSeries) (obj);
                String title = tvShow.getOriginalName();
                String synopsis = tvShow.getOverview();
                double score = tvShow.getPopularity();
                setContentOnPage(title, synopsis, score, tvShow.getPosterPath());
            }
        }
        
    }

    private void setContentOnPage(String title, String synopsis, double popScore, String posterPath) {
        TextView titleText = (TextView) findViewById(R.id.poster_title);
        TextView synposisText = (TextView) findViewById(R.id.synopsis);
        TextView scoreText = (TextView) findViewById(R.id.popularity_score);
        SquareImageView image = (SquareImageView) findViewById(R.id.pictureDetailPage);
        String mainURL = getString(R.string.IMAGE_URL);
        String API_KEY = getString(R.string.API_KEY);
        Picasso.with(DetailPageActivity.this.getApplicationContext()).load(mainURL + posterPath + "?api_key" + API_KEY).into(image);

        titleText.setText("Title: " + title);
        synposisText.setText("Synopsis: " + synopsis);
        scoreText.setText("Popularity Score: " + Double.toString(popScore));
    }

}
