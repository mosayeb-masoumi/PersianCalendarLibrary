package com.example.persiancalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.persiancalendarlibrary.DialogFactory;
import com.example.persiancalendarlibrary.PersianCalendar;

public class MainActivity extends AppCompatActivity {

    EditText edt_date;
    RelativeLayout layout_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout_root = findViewById(R.id.layout_root);
        edt_date=findViewById(R.id.edt_date);
        
        edt_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCalendar();
            }
        });
        
    }

    private void openCalendar() {

        PersianCalendar persianCalendar = new PersianCalendar.Builder()

                .max_year(1405)
                .min_year(1395)

                .title("تقویم")
                .titleTextColor(getResources().getColor(R.color.white))
                .titleTextSize(20)

                .closeIconVisibility(true)
                .closeIconBackgroundDrawable(getResources().getDrawable(R.drawable.ic_close))

                .headerBackgroundColor(getResources().getColor(R.color.colorAccent))
                .headerBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_header_shape))

                .dateBackgroundColor(getResources().getColor(R.color.yellow))
                .dateBackgroundDrawable(getResources().getDrawable(R.drawable.date_background))
//
                .buttonRegisterBackgroundColor(getResources().getColor(R.color.colorAccent))
                .buttonRegisterBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_btn_shape))
                .buttonRegisterTextColor(getResources().getColor(R.color.blue))
                .buttonRegisterTextSize(20)
////
                .buttonSetTodayBackgroundColor(getResources().getColor(R.color.colorAccent))
                .buttonSetTodayBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_btn_shape))
                .buttonSetTodayTextColor(getResources().getColor(R.color.blue))
                .buttonSetTodayTextSize(20)
//
                .dialogBackgroundColor(getResources().getColor(R.color.colorAccent))
                .dialogBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_btn_shape))

                .build();



        DialogFactory dialogFactory = new DialogFactory(MainActivity.this);
        dialogFactory.createCalendarDialog(new DialogFactory.DialogFactoryInteraction() {
            @Override
            public void onAcceptButtonClicked(String... params) {

                String date = params[0];
                edt_date.setText(date);

            }

            @Override
            public void onDeniedButtonClicked(boolean bool) {

            }

        }, layout_root ,persianCalendar);
    }
}
