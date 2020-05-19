package com.example.persiancalendarlibrary;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

    //-------------------------------------------------CUSTOMIZED DIALOG--------------------------------------------

    public void createCalendarDialog(final DialogFactoryInteraction listener, View view, PersianCalendar persianCalendar) {
        View customLayout = LayoutInflater.from(context).inflate(R.layout.calendar_dialog, (ViewGroup) view, false);

        //define views inside of dialog
        ImageView img_close = customLayout.findViewById(R.id.img_close);
        final Button btn_register = customLayout.findViewById(R.id.btn1);
        Button btn_todayDate = customLayout.findViewById(R.id.btn2);
        final NumberPicker np_year = customLayout.findViewById(R.id.np_year);
        final NumberPicker np_month = customLayout.findViewById(R.id.np_month);
        final NumberPicker np_day = customLayout.findViewById(R.id.np_day);
        TextView txt_title = customLayout.findViewById(R.id.txt_title);
        RelativeLayout rl_header = customLayout.findViewById(R.id.rl_header);
        LinearLayout dialog_background = customLayout.findViewById(R.id.dialog_background);

        SolarCalendar calendar = new SolarCalendar();

        final int year = Integer.parseInt(calendar.getCurrentShamsiYear());
        final int month = Integer.parseInt(calendar.getCurrentShamsiMonth());
        final int day = Integer.parseInt(calendar.getCurrentShamsiDay());


        int min_year;
        int max_year;
        if (persianCalendar.getMin_year() != 0) {
            min_year = persianCalendar.getMin_year();
        } else {
            min_year = year - 50;
        }

        if (persianCalendar.getMax_year() != 0) {
            max_year = persianCalendar.getMax_year();
        } else {
            max_year = year + 50;
        }

        if (persianCalendar.getDateBackgroundColor() != 0)
            np_day.setBackgroundColor(persianCalendar.getDateBackgroundColor());
        np_month.setBackgroundColor(persianCalendar.getDateBackgroundColor());
        np_year.setBackgroundColor(persianCalendar.getDateBackgroundColor());

        if (persianCalendar.getDateBackgroundDrawable() != null) {
            np_day.setBackground(persianCalendar.getDateBackgroundDrawable());
            np_month.setBackground(persianCalendar.getDateBackgroundDrawable());
            np_year.setBackground(persianCalendar.getDateBackgroundDrawable());
        }

        if (persianCalendar.getTitle() != null)
            txt_title.setText(persianCalendar.getTitle());
        if (persianCalendar.getTitleTextColor() != 0)
            txt_title.setTextColor(persianCalendar.getTitleTextColor());
        if (persianCalendar.getTitleTextSize() != 0)
            txt_title.setTextSize(persianCalendar.getTitleTextSize());

        if (persianCalendar.getCloseIconVisibility() == null || persianCalendar.getCloseIconVisibility())
            img_close.setVisibility(View.VISIBLE);
        else
            img_close.setVisibility(View.GONE);

        if (persianCalendar.getCloseIconBackgroundDrawable() != null)
            img_close.setBackground(persianCalendar.getCloseIconBackgroundDrawable());


        if (persianCalendar.getHeaderBackgroundColor() != 0)
            rl_header.setBackgroundColor(persianCalendar.getHeaderBackgroundColor());
        if (persianCalendar.getHeaderBackgroundDrawable() != null)
            rl_header.setBackground(persianCalendar.getHeaderBackgroundDrawable());


        if (persianCalendar.getButtonRegisterBackgroundColor() != 0)
            btn_register.setBackgroundColor(persianCalendar.getButtonRegisterBackgroundColor());
        if (persianCalendar.getButtonRegisterBackgroundDrawable() != null)
            btn_register.setBackground(persianCalendar.getButtonRegisterBackgroundDrawable());
        if (persianCalendar.getButtonRegisterTextColor() != 0)
            btn_register.setTextColor(persianCalendar.getButtonRegisterTextColor());
        if (persianCalendar.getButtonRegisterTextSize() != 0)
            btn_register.setTextSize(persianCalendar.getButtonRegisterTextSize());

        if (persianCalendar.getButtonSetTodayBackgroundColor() != 0)
            btn_todayDate.setBackgroundColor(persianCalendar.getButtonSetTodayBackgroundColor());
        if (persianCalendar.getButtonSetTodayBackgroundDrawable() != null)
            btn_todayDate.setBackground(persianCalendar.getButtonSetTodayBackgroundDrawable());
        if (persianCalendar.getButtonSetTodayTextColor() != 0)
            btn_todayDate.setTextColor(persianCalendar.getButtonSetTodayTextColor());
        if (persianCalendar.getButtonSetTodayTextSize() != 0)
            btn_todayDate.setTextSize(persianCalendar.getButtonSetTodayTextSize());


        if (persianCalendar.getDialogBackgroundColor() != 0)
            dialog_background.setBackgroundColor(persianCalendar.getDialogBackgroundColor());
        if (persianCalendar.getDialogBackgroundDrawable() != null)
            dialog_background.setBackground(persianCalendar.getDialogBackgroundDrawable());


// year --------------------------------------------------
        List<String> yearList = new ArrayList<>();
        for (int i = min_year; i <= max_year; i++) {
            String y = ConvertEnDigitToFa.convert(String.valueOf(i));
            yearList.add(y);
        }

        String[] strYearList = new String[yearList.size()];
        strYearList = yearList.toArray(strYearList);

        np_year.setDisplayedValues(strYearList);

// month --------------------------------------------------------
        int min_month = 1;
        int max_month = 12;

        List<String> monthList = new ArrayList<>();
        for (int i = min_month; i <= max_month; i++) {
            String m = "";
            if (i < 10) {
                m = "۰" + ConvertEnDigitToFa.convert(String.valueOf(i));
            } else {
                m = ConvertEnDigitToFa.convert(String.valueOf(i));
            }
            monthList.add(m);
        }

        String[] strMonthList = new String[monthList.size()];
        strMonthList = monthList.toArray(strMonthList);

        np_month.setDisplayedValues(strMonthList);

// day --------------------------------------------------------
        int min_day = 1;
        int max_day = 31;

        List<String> dayList = new ArrayList<>();
        for (int i = min_day; i <= max_day; i++) {
            String d = "";
            if (i < 10) {
                d = "۰" + ConvertEnDigitToFa.convert(String.valueOf(i));
            } else {
                d = ConvertEnDigitToFa.convert(String.valueOf(i));
            }
            dayList.add(d);
        }

        String[] strDayList = new String[dayList.size()];
        strDayList = dayList.toArray(strDayList);

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
                String month2 = (String.format("%s", month1.length() < 2 ? "۰" + month1 : month1));
                String day1 = ConvertEnDigitToFa.convert(String.valueOf(np_day.getValue()));
                String day2 = (String.format("%s", day1.length() < 2 ? "۰" + day1 : day1));

                String date = year1 + "/" + month2 + "/" + day2;

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


    //-------------------------------------------------SIMPLE DIALOG--------------------------------------------

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

        int min_year;
        int max_year;

        min_year = year - 50;
        max_year = year + 50;


// year --------------------------------------------------
        List<String> yearList = new ArrayList<>();
        for (int i = min_year; i <= max_year; i++) {
            String y = ConvertEnDigitToFa.convert(String.valueOf(i));
            yearList.add(y);
        }

        String[] strYearList = new String[yearList.size()];
        strYearList = yearList.toArray(strYearList);

        np_year.setDisplayedValues(strYearList);

// month --------------------------------------------------------
        int min_month = 1;
        int max_month = 12;

        List<String> monthList = new ArrayList<>();
        for (int i = min_month; i <= max_month; i++) {
            String m = "";
            if (i < 10) {
                m = "۰" + ConvertEnDigitToFa.convert(String.valueOf(i));
            } else {
                m = ConvertEnDigitToFa.convert(String.valueOf(i));
            }
            monthList.add(m);
        }

        String[] strMonthList = new String[monthList.size()];
        strMonthList = monthList.toArray(strMonthList);

        np_month.setDisplayedValues(strMonthList);

// day --------------------------------------------------------
        int min_day = 1;
        int max_day = 31;

        List<String> dayList = new ArrayList<>();
        for (int i = min_day; i <= max_day; i++) {
            String d = "";
            if (i < 10) {
                d = "۰" + ConvertEnDigitToFa.convert(String.valueOf(i));
            } else {
                d = ConvertEnDigitToFa.convert(String.valueOf(i));
            }
            dayList.add(d);
        }

        String[] strDayList = new String[dayList.size()];
        strDayList = dayList.toArray(strDayList);

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
                String month2 = (String.format("%s", month1.length() < 2 ? "۰" + month1 : month1));
                String day1 = ConvertEnDigitToFa.convert(String.valueOf(np_day.getValue()));
                String day2 = (String.format("%s", day1.length() < 2 ? "۰" + day1 : day1));

                String date = year1 + "/" + month2 + "/" + day2;

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
