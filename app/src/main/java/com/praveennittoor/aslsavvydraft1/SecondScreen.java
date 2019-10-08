package com.praveennittoor.aslsavvydraft1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;

public class SecondScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    final String path = "/sdcard/Android/data/com.praveennittoor.aslsavvydraft1/files/videos/";
    final String endpath = "_asl.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen);
        Bundle gt=getIntent().getExtras();

        //getFilePath("amit.txt");

       // VideoView mVideoView = (VideoView)findViewById(R.id.videoView);


        /*final VideoView videoView;

        videoView = (VideoView) findViewById(R.id.videoView);

        Uri video = Uri.parse("/storage/raw/book_asl.mp4");
        videoView.setVideoURI(video);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                videoView.start();
            }
        });*/


        final String username=gt.getString("username");
        final String aslVid=gt.getString("aslVid");
        Toast.makeText
                (getApplicationContext(), "Username : " + username, Toast.LENGTH_SHORT)
                .show();
        System.out.println(aslVid);
        String LINK = path+aslVid+endpath;
        VideoView mVideoView  = (VideoView) findViewById(R.id.videoView);
        MediaController mc = new MediaController(this);
        mc.setAnchorView(mVideoView);
        mc.setMediaPlayer(mVideoView);
        Uri video = Uri.parse(LINK);
        mVideoView.setMediaController(mc);
        mVideoView.setVideoURI(video);
        mVideoView.start();
        final Button saveBtn = (Button) findViewById(R.id.button);
        saveBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                System.out.println("Selected Useename : " + username+ "\n ASL VID" +" "+ aslVid);
                //this will print the result
                Intent a=new Intent(SecondScreen.this,VideoCapture.class);
                // Bundle basket= new Bundle();
                //basket.putString("username", result);
                //basket.putString("aslVid",selectedItemText);
               // Intent a=new Intent(MainActivity.this,SecondScreen.class);
                //a.putExtras(basket);
                startActivity(a);
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public String getFilePath(String fileName) {

        String csvFilePath = getApplicationContext().getExternalFilesDir(null).getAbsolutePath()
                + "/"+fileName;



        File csvFile = new File(csvFilePath);
        if (csvFile.exists()) {
            csvFile.delete();
        }

        String saveFileDirectory = getApplicationContext().getExternalFilesDir(null).getAbsolutePath();


        File directory = new File(saveFileDirectory);
        if (!directory.exists()) {
            directory.mkdir();
        }


        if (!csvFile.exists()) {
            try {
                csvFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return csvFilePath;
    }
}
