package jast.org.simple_signature_app;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.SimpleFormatter;

import jast.org.simple_signature_app.widget.DrawingView;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    DrawingView mDrawingView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.m_text_view);
        mDrawingView = (DrawingView)findViewById(R.id.m_drawing_view_signature_please);


        int initialDelay = 1000; //first update in miliseconds
        int period = 1000;      //nexts updates in miliseconds

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {


                new Thread(new Runnable() {
                    public void run() {
                        runOnUiThread(new Runnable() {
                            public void run() {
                                Calendar mCalendar = Calendar.getInstance();
                                SimpleDateFormat shortDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
                                String time = shortDateFormat.format(mCalendar.getTime());
                                mTextView.setText(time);
                            }
                        });
                    }
                }).start();

            }
        };
        timer.scheduleAtFixedRate(task, initialDelay, period);

    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.m_button_clear:
                mDrawingView.clearCanvas();
                break;
        }
    }

}
