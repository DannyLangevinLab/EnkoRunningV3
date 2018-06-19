


        package com.example.dlangevin.enkorunningv2;

        import android.content.Context;
        import android.content.Intent;
        import android.hardware.Sensor;
        import android.hardware.SensorEvent;
        import android.hardware.SensorEventListener;
        import android.hardware.SensorManager;
        import android.os.Bundle;
        import android.os.SystemClock;
        import android.support.design.widget.CollapsingToolbarLayout;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Chronometer;
        import android.widget.ImageButton;
        import android.widget.TextView;

/**
 * Created by d.langevin on 10/05/2016.
 */
public class InterfaceNvoParcours extends AppCompatActivity implements SensorEventListener {


    private ImageButton retoursport;
    Chronometer chronometer;
    private Button btn_start;
    private Button btn_pause;
    private Button btn_stop;
    private ImageButton btn_drawer2;

    //compteur de pas
    private TextView textView;
    private SensorManager mSensorManager;
    private Sensor mStepCounterSensor;
    private Sensor mStepDetectorSensor;




    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_nvoparcours);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        retoursport = (ImageButton) findViewById(R.id.retoursport);
        retoursport.setOnClickListener(new buttoncliquer());
        // Boutons CHRONOMETRE
        chronometer=(Chronometer)findViewById(R.id.chronometer);
        btn_start=(Button)findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new buttoncliquer());
        btn_pause=(Button)findViewById(R.id.btn_pause);
        btn_pause.setOnClickListener(new buttoncliquer());
        btn_stop=(Button)findViewById(R.id.btn_stop);
        btn_stop.setOnClickListener(new buttoncliquer());
        textView = (TextView) findViewById(R.id.textview);
        btn_drawer2=(ImageButton)findViewById(R.id.btn_drawer2);
        btn_drawer2.setOnClickListener(new buttoncliquer());

        mSensorManager = (SensorManager)
                getSystemService(Context.SENSOR_SERVICE);
        mStepCounterSensor = mSensorManager
                .getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        mStepDetectorSensor = mSensorManager
                .getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);

    }

    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        float[] values = event.values;
        int value = -1;

        if (values.length > 0) {
            value = (int) values[0];

        }

        if (sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            textView.setText("Step Counter Detected : " + value);
        } else if (sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            // For test only. Only allowed value is 1.0 i.e. for step taken
            textView.setText("Step Detector Detected : " + value);
        }
    }
    protected void onResume() {

        super.onResume();

        mSensorManager.registerListener(this, mStepCounterSensor,

                SensorManager.SENSOR_DELAY_FASTEST);
        mSensorManager.registerListener(this, mStepDetectorSensor,

                SensorManager.SENSOR_DELAY_FASTEST);

    }

    protected void onStop() {
        super.onStop();
        mSensorManager.unregisterListener(this, mStepCounterSensor);
        mSensorManager.unregisterListener(this, mStepDetectorSensor);
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    private class buttoncliquer implements Button.OnClickListener {

        @Override
        public void onClick(View v) {


            if (v == retoursport) {
                InterfaceNvoParcours.this.finish();
                System.exit(0);


            }
            if (v== btn_drawer2){
                Intent ouverture0 = new Intent(getApplicationContext(), InterfaceDrawerDroit.class);
                startActivity(ouverture0);
            }

            if (v== btn_start){
                chronometer.start();
            }
            if(v== btn_pause){
                chronometer.stop();
            }

            if(v== btn_stop){
                chronometer.setBase(SystemClock.elapsedRealtime());
            }

        }
    }
}
