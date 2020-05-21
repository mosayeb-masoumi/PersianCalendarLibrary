package com.example.persiancalendar;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.persiancalendarlibrary.DialogFactory;
import com.example.persiancalendarlibrary.PersianCalendar;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout_root;
    Button btn_openCalendar;
    TextView txt_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout_root = findViewById(R.id.layout_root);
        btn_openCalendar=findViewById(R.id.btn_openCalendar);
        txt_date=findViewById(R.id.txt_date);

        btn_openCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCalendar();
            }
        });
        
    }

    private void openCalendar() {

        PersianCalendar persianCalendar = new PersianCalendar.Builder()

                .setMax_year(1402)
                .setMin_year(1398)

                .setTitle("تقویم")
                .setTitleTextColor(getResources().getColor(R.color.white))
                .setTitleTextSize(20)

                .setCloseIconVisibility(true)
                .setCloseIconBackgroundDrawable(getResources().getDrawable(R.drawable.ic_close))

                .setHeaderBackgroundColor(getResources().getColor(R.color.colorAccent))
                .setHeaderBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_header_shape))

                .setDateBackgroundColor(getResources().getColor(R.color.yellow))
                .setDateBackgroundDrawable(getResources().getDrawable(R.drawable.date_background))

                .setButtonRegisterBackgroundColor(getResources().getColor(R.color.colorAccent))
                .setButtonRegisterBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_btn_shape))
                .setButtonRegisterTextColor(getResources().getColor(R.color.blue_dark))
                .setButtonRegisterTextSize(20)

                .setButtonSetTodayBackgroundColor(getResources().getColor(R.color.colorAccent))
                .setButtonSetTodayBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_btn_shape))
                .setButtonSetTodayTextColor(getResources().getColor(R.color.blue_dark))
                .setButtonSetTodayTextSize(20)

                .setDialogBackgroundColor(getResources().getColor(R.color.colorAccent))
                .setDialogBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_btn_shape))

                .build();


        DialogFactory dialogFactory = new DialogFactory(MainActivity.this);
        dialogFactory.createCalendarDialog(new DialogFactory.DialogFactoryInteraction() {
            @Override
            public void onAcceptButtonClicked(String... params) {

                String date = params[0];
                txt_date.setText(date);

            }

            @Override
            public void onDeniedButtonClicked(boolean bool) {

            }

        }, layout_root,persianCalendar);
    }
}
