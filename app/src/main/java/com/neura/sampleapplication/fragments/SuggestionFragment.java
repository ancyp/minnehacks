package com.neura.sampleapplication.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.neura.sampleapplication.R;

import java.io.InputStream;

public class SuggestionFragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        int event = arguments.getInt("event");
        int layout = R.layout.fragment_main;
        switch (event) {
            /*"userStartedWalking", "userStartedRunning",
                    "userArrivedToWork", "userLeftWork",
                    "userFinishedRunning", "userFinishedWalking",
                    "userFinishedDriving", "userStartedDriving");*/
            case 1:
                layout = R.layout.suggestion;
                break;
            case 2:
                layout = R.layout.suggestion_running;
                break;
            case 3:
                layout = R.layout.suggestion;
                break;
            case 4:
                layout = R.layout.suggestion_running;
                break;
            case 5:
                layout = R.layout.suggestion;
                break;
            case 6:
                layout = R.layout.suggestion_running;
                break;
            case 7:
                layout = R.layout.suggestion;
                break;
            case 8:
                layout = R.layout.suggestion_running;
                break;
            default:
                return null;
        }
        return inflater.inflate(layout, null);
    }
}


class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;

    public DownloadImageTask(ImageView bmImage) {
        this.bmImage = bmImage;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
    }
}
