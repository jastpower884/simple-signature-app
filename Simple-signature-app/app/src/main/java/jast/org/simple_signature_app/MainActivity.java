package jast.org.simple_signature_app;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.SimpleFormatter;

import jast.org.simple_signature_app.widget.DrawingView;
import jast.org.simple_signature_app.widget.WheelPicker;

public class MainActivity extends AppCompatActivity {

    DrawingView mDrawingView;

    WheelPicker mWheelPickerLeft;
    WheelPicker mWheelPickerRight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawingView = (DrawingView) findViewById(R.id.m_drawing_view_signature_please);

        mWheelPickerLeft = (WheelPicker) findViewById(R.id.wheel_picker_left);
        mWheelPickerRight = (WheelPicker) findViewById(R.id.wheel_picker_right);


        List<String> hourString = new ArrayList<>();
        List<String> minString = new ArrayList<>();

        for (int hour = 0; hour < 24; hour++) {
            NumberFormat formatter = new DecimalFormat("00");

            hourString.add(formatter.format(hour));

        }

        for (int minute = 0; minute < 60; minute++) {
            NumberFormat formatter = new DecimalFormat("00");

            minString.add(formatter.format(minute));

        }

        mWheelPickerLeft.setData(hourString);
        mWheelPickerRight.setData(minString);

        mWheelPickerLeft.setVisibleItemCount(2);
        mWheelPickerRight.setVisibleItemCount(2);

        mWheelPickerRight.setOnWheelChangeListener(new WheelPicker.OnWheelChangeListener() {
            @Override
            public void onWheelScrolled(int offset) {
//                int rightOffset = Math.abs(offset);
//                if (rightOffset > rightOffset % (mWheelPickerRight.getItemSpace() * mWheelPickerRight.getData().size())) {
//                    mWheelPickerLeft.setSelectedItemPosition(mWheelPickerLeft.getSelectedItemPosition() + 1);
//                }
//
//                Log.v("MainActivity", "position:" + offset);
//                Log.v("MainActivity", "item space:" + mWheelPickerRight.getItemSpace());
//

            }

            @Override
            public void onWheelSelected(int position) {

                Log.v("MainActivity", "position:" + position);

            }

            @Override
            public void onWheelScrollStateChanged(int state) {

            }
        });


//
//        int initialDelay = 1000; //first update in miliseconds
//        int period = 1000;      //nexts updates in miliseconds
//
//        Timer timer = new Timer();
//        TimerTask task = new TimerTask() {
//            public void run() {
//
//
//                new Thread(new Runnable() {
//                    public void run() {
//                        runOnUiThread(new Runnable() {
//                            public void run() {
//                                Calendar mCalendar = Calendar.getInstance();
//                                SimpleDateFormat shortDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
//                                String time = shortDateFormat.format(mCalendar.getTime());
//                                mTextView.setText(time);
//                            }
//                        });
//                    }
//                }).start();
//
//            }
//        };
//        timer.scheduleAtFixedRate(task, initialDelay, period);

    }

    @Override
    protected void onResume() {
        super.onResume();


        Calendar mCalendar = Calendar.getInstance();

        mWheelPickerLeft.setSelectedItemPosition(mCalendar.get(Calendar.HOUR_OF_DAY));
        mWheelPickerRight.setSelectedItemPosition(mCalendar.get(Calendar.MINUTE));


    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.m_button_clear:
                mDrawingView.clearCanvas();
                break;
        }
    }

}
