package com.example.barleybreak2;


import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
    int width = 5;
    int height = 6;
    public int[][] counts = new int[height][width];
    private static final String TAG = "MyApp";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillTheButtons(width, height);
        Log.i(TAG, "2.........."+Arrays.deepToString(counts));
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void fillTheButtons(int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j <width ; j++) {
                counts[i][j] = random();
            }
        }
        Log.i(TAG, "1.........."+Arrays.deepToString(counts));
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                checkwidth(i, j);
                checkheight(i, j);
            }
        }
    }

    public void checkwidth(int i, int j) {
        if (j == 2) {
            if (counts[i][j - 2] + counts[i ][j- 1] + counts[i][j]== 15) {
                counts[i][j] = random();
                checkwidth(i, j);
            }
        }

        else if (j >= 3) {
            if (counts[i ][j- 2] + counts[i ][j- 1] + counts[i][j]== 15) {
                counts[i][j] = random();
                checkwidth(i, j);

            }
            else if (counts[i ][j- 3] + counts[i][j - 2] + counts[i][j - 1] + counts[i][j]== 15) {
                counts[i][j] = random();
                checkwidth(i, j);

            }
        }
    }

    public void checkheight(int i, int j) {
        if (i == 2) {
            if (counts[i - 2][j] + counts[i - 1 ][j] + counts[i][j]== 15) {
                counts[i][j] = random();
                checkheight(i, j);
            }
        }

        else if (i >= 3) {
            if (counts[i- 2 ][j] + counts[i - 1][j] + counts[i][j]== 15) {
                counts[i][j] = random();
                checkheight(i, j);
            }
            else if (counts[i - 3][j] + counts[i - 2][j ] + counts[i- 1][j ] + counts[i][j]== 15) {
                counts[i][j] = random();
                checkheight(i, j);
            }
        }

    }

    public int random(){
        return (int) (1 + (Math.random() * (6 - 1)));
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}

