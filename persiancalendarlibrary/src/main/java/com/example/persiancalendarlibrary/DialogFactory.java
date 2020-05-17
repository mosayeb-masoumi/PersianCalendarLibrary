package com.example.persiancalendarlibrary;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;

import java.util.ArrayList;
import java.util.List;

public class DialogFactory {
    private Context context;



    public interface DialogFactoryInteraction {

        void onAcceptButtonClicked(String... strings);

        void onDeniedButtonClicked(boolean cancel_dialog);
    }

    public DialogFactory(Context ctx) {
        this.context = ctx;
    }



    public void createCalendarDialog(final DialogFactoryInteraction listener, View view) {
        View customLayout = LayoutInflater.from(context).inflate(R.layout.calendar_dialog, (ViewGroup) view, false);

        //define views inside of dialog
        ImageView img_close = customLayout.findViewById(R.id.img_close);
        final Button btn_register = customLayout.findViewById(R.id.btn1);
        Button btn_todayDate = customLayout.findViewById(R.id.btn2);
        final NumberPicker np_year = customLayout.findViewById(R.id.np_year);
        final NumberPicker np_month = customLayout.findViewById(R.id.np_month);
        final NumberPicker np_day = customLayout.findViewById(R.id.np_day);

        SolarCalendar calendar = new SolarCalendar();

        final int year = Integer.parseInt(calendar.getCurrentShamsiYear());
        final int month = Integer.parseInt(calendar.getCurrentShamsiMonth());
        final int day = Integer.parseInt(calendar.getCurrentShamsiDay());


// year --------------------------------------------------
        int min_year= year-50;
        int max_year = year+50;

        List<String> yearList = new ArrayList<>();
        for (int i = min_year; i <= max_year ; i++) {
            String y =ConvertEnDigitToFa.convert(String.valueOf(i));
            yearList.add(y);
        }

        String[] strYearList = new String[yearList.size()];
        strYearList = yearList.toArray(strYearList );

        np_year.setDisplayedValues(strYearList);

// month --------------------------------------------------------
        int min_month= 1;
        int max_month = 12;

        List<String> monthList = new ArrayList<>();
        for (int i = min_month; i <= max_month ; i++) {
            String m ="";
            if(i<10){
                m = "۰" +ConvertEnDigitToFa.convert(String.valueOf(i));
            }else{
                m = ConvertEnDigitToFa.convert(String.valueOf(i));
            }
            monthList.add(m);
        }

        String[] strMonthList = new String[monthList.size()];
        strMonthList = monthList.toArray(strMonthList );

        np_month.setDisplayedValues(strMonthList);

// day --------------------------------------------------------
        int min_day= 1;
        int max_day = 31;

        List<String> dayList = new ArrayList<>();
        for (int i = min_day; i <= max_day ; i++) {
            String d ="";
            if(i<10){
                d = "۰" +ConvertEnDigitToFa.convert(String.valueOf(i));
            }else{
                d = ConvertEnDigitToFa.convert(String.valueOf(i));
            }
            dayList.add(d);
        }

        String[] strDayList = new String[dayList.size()];
        strDayList = dayList.toArray(strDayList );

        np_day.setDisplayedValues(strDayList);

//  --------------------------------------------------------



        np_year.setMinValue(min_year);
        np_year.setMaxValue(max_year);

        np_month.setMinValue(min_month);
        np_month.setMaxValue(max_month);

        np_day.setMinValue(min_day);
        np_day.setMaxValue(max_day);

//        //init set
        np_year.setValue(year);
        np_month.setValue(month);
        np_day.setValue(day);

        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setView(customLayout);

        //create dialog and set background transparent
        final android.app.AlertDialog dialog = builder.create();
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        btn_todayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                np_year.setValue(year);
                np_month.setValue(month);
                np_day.setValue(day);

            }
        });





            btn_register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String year1 = ConvertEnDigitToFa.convert(String.valueOf(np_year.getValue()));
                    String month1 = ConvertEnDigitToFa.convert(String.valueOf(np_month.getValue()));
                    String month2 =(String.format("%s", month1.length() < 2 ? "۰" + month1 : month1));
                    String day1 = ConvertEnDigitToFa.convert(String.valueOf(np_day.getValue()));
                    String day2 = (String.format("%s", day1.length() < 2 ? "۰" + day1 : day1));

                    String date = year1+"/"+month2+"/"+day2;

//            String date = ConvertEnDigitToFa.convert(year+"/"+month+"/"+day) ;
                    listener.onAcceptButtonClicked(date);
                    dialog.dismiss();
                }
            });



        img_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }
}
