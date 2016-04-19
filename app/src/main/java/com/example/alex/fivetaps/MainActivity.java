package com.example.alex.fivetaps;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int clicks = 0;
    private long lastclick = 0;
    private long clickDistance = 500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout rl = (RelativeLayout) findViewById(R.id.mylayout);
        assert (rl != null);
        rl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                long time= System.currentTimeMillis();
                if(time - lastclick <= clickDistance)
                {
                    clicks++;
                }
                else
                {
                    clicks = 1;
                }
                lastclick = time;
                if(clicks >= 5)
                {
                    ((Vibrator) getSystemService(Context.VIBRATOR_SERVICE)).vibrate(300);
                    Context context = getApplicationContext();
                    CharSequence text = "Please stop :)";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });

    }
}
