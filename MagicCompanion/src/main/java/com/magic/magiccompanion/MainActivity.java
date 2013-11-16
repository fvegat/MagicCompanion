package com.magic.magiccompanion;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLifeLess = (Button)findViewById(R.id.btn_life_less);
        Button btnLifePlus = (Button)findViewById(R.id.btn_life_plus);
        btnLifeLess.setOnClickListener(this);
        btnLifePlus.setOnClickListener(this);

        Button btnLifeLess3 = (Button)findViewById(R.id.btn_life_less3);
        Button btnLifePlus3 = (Button)findViewById(R.id.btn_life_plus3);
        btnLifeLess3.setOnClickListener(this);
        btnLifePlus3.setOnClickListener(this);

        Button btnLifeLess5 = (Button)findViewById(R.id.btn_life_less5);
        Button btnLifePlus5 = (Button)findViewById(R.id.btn_life_plus5);
        btnLifeLess5.setOnClickListener(this);
        btnLifePlus5.setOnClickListener(this);

        Button btnReset = (Button) findViewById(R.id.btn_reset);
        btnReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        TextView tvLife = (TextView) findViewById(R.id.tv_life);
        TextView tvFatefulHour = (TextView) findViewById(R.id.tv_fateful_hour);
        int lifeValue = Integer.parseInt(tvLife.getText().toString());

        switch(view.getId())
        {
            case R.id.btn_life_less:
                lifeValue--;
                break;
            case R.id.btn_life_plus:
                lifeValue++;
                break;
            case R.id.btn_life_less3:
                lifeValue = lifeValue -3;
                break;
            case R.id.btn_life_plus3:
                lifeValue = lifeValue +3;
                break;
            case R.id.btn_life_less5:
                lifeValue = lifeValue -5;
                break;
            case R.id.btn_life_plus5:
                lifeValue = lifeValue +5;
                break;
            case R.id.btn_reset:
                lifeValue = reset(tvLife, tvFatefulHour);
                break;
        }
        setFatefulHour(tvLife, tvFatefulHour, lifeValue);
        tvLife.setText(lifeValue+"");
    }

    private int reset(TextView tvLife, TextView tvFatefulHour)
    {
        tvFatefulHour.setVisibility(View.INVISIBLE);
        return Integer.parseInt(getResources().getString(R.string.life));
    }

    private void setFatefulHour(TextView tvLife, TextView tvFatefulHour, int lifeValue)
    {
        if(lifeValue <= 5)
        {
            tvLife.setTextColor(Color.RED);
            tvFatefulHour.setVisibility(View.VISIBLE);
        }
        else
        {
            tvLife.setTextColor(Color.BLACK);
            tvFatefulHour.setVisibility(View.INVISIBLE);
        }
    }
}
