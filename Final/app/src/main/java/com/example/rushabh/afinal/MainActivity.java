package com.example.rushabh.afinal;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoView =(VideoView)findViewById(R.id.videoView);

        //Creating MediaController
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);

        //specify the location of media file
        Uri uri=Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/media/1.mp4");

        //Setting MediaController and URI, then starting the videoView
        videoView.setMediaController(mediaController);
//        videoView.setVideoURI(uri);
        videoView.setVideoPath("https://r6---sn-cvh7kn7s.googlevideo.com/videoplayback?key=cms1&sparams=clen,dur,ei,expire,gir,id,initcwndbps,ip,ipbits,ipbypass,itag,lmt,mime,mip,mm,mn,ms,mv,pl,ratebypass,requiressl,source&lmt=1505491910428267&expire=1510225277&clen=564740079&ipbits=0&requiressl=yes&signature=4D0404086C7C5317B2F1F42CD74E1B02482C0F9A.7BED64C828E26810915F4A64C6A97DF822DEF6DE&mime=video/mp4&dur=8124.685&itag=18&gir=yes&ip=165.227.57.186&ratebypass=yes&source=youtube&pl=24&id=o-AFwrTuplwl5Fa6Th9ANzm03A8ThrOHlI4kFIRzHDDtz4&ei=HOEDWo-3N4_y-wOTqJDoCw&title=Latest+Ram+charan+and+Priyanka+Chopra+movies+in+hindiLatest%20Ram%20charan%20and%20Priyanka%20Chopra%20movies%20in%20hindi_MobWon.Com.mp4&rm=sn-a8au-nh4e7e,sn-n4vk7l&fexp=23702512&req_id=312305d7f39da3ee&redirect_counter=2&cms_redirect=yes&ipbypass=yes&mip=163.53.176.179&mm=29&mn=sn-cvh7kn7s&ms=rdu&mt=1510203588&mv=m");
        //videoView.setVideoPath("http://techslides.com/demos/sample-videos/small.mp4");
        videoView.requestFocus();
        videoView.start();

    }


}