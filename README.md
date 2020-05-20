# PersianCalendarLibrary

add jitpack to build.gradle(Project)

    buildscript {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
      }
    }

    allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
     }
    }

libray:

    for android X
    implementation 'com.github.mosayeb-masoumi:PersianCalendarLibrary:1.1.0'
   
    for other APIs  
    implementation 'com.github.mosayeb-masoumi:PersianCalendarLibrary:1.0.0'


how to create simple dialog:
   
    private void openCalendar() {
     DialogFactory dialogFactory = new DialogFactory(context);
        dialogFactory.createCalendarDialog(new DialogFactory.DialogFactoryInteraction() {
            @Override
            public void onAcceptButtonClicked(String... params) {

                String date = params[0];
                edt_date.setText(date);

            }

            @Override
            public void onDeniedButtonClicked(boolean bool) {

            }
           // layout_root is the id that we set in our layout.xml
        }, layout_root);
    }
 
 
how to create customized dialog:
    
     private void openCalendar() {
        PersianCalendar persianCalendar = new PersianCalendar.Builder()

                .max_year(1405)
                .min_year(1395)

                .title("تقویم")
                .titleTextColor(getResources().getColor(R.color.white))
                .titleTextSize(20)

                .closeIconVisibility(true)
                .closeIconBackgroundDrawable(getResources().getDrawable(R.drawable.ic_close))

                // here we can set color or drawable for header,base on need we can choose one these two below lines
                .headerBackgroundColor(getResources().getColor(R.color.colorAccent))
                .headerBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_header_shape))

                // here we can set color or drawable for numberPickers,base on need we can choose one these two below lines
                .dateBackgroundColor(getResources().getColor(R.color.yellow))
                .dateBackgroundDrawable(getResources().getDrawable(R.drawable.date_background))
                
                // here we can set color or drawable and other settings for register button
                .buttonRegisterBackgroundColor(getResources().getColor(R.color.colorAccent))
                .buttonRegisterBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_btn_shape))
                .buttonRegisterTextColor(getResources().getColor(R.color.blue_dark))
                .buttonRegisterTextSize(20)

                // here we can set color or drawable and other settings for todayDate button
                .buttonSetTodayBackgroundColor(getResources().getColor(R.color.colorAccent))
                .buttonSetTodayBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_btn_shape))
                .buttonSetTodayTextColor(getResources().getColor(R.color.blue_dark))
                .buttonSetTodayTextSize(20)

                // here we can set color or drawable for dialog,base on need we can choose one these two below lines
                .dialogBackgroundColor(getResources().getColor(R.color.colorAccent))
                .dialogBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_btn_shape))

                .build();
        
        
        DialogFactory dialogFactory = new DialogFactory(context);
        dialogFactory.createCalendarDialog(new DialogFactory.DialogFactoryInteraction() {
            @Override
            public void onAcceptButtonClicked(String... params) {

                String date = params[0];
                edt_date.setText(date);

            }

            @Override
            public void onDeniedButtonClicked(boolean bool) {

            }
           // layout_root is the id that we set in our layout.xml
        }, layout_root ,persianCalendar);
    }
    
 simple PersianCalendar image:
 
 ![simple_persian_calendar](https://user-images.githubusercontent.com/40134233/82436676-74547a80-9aab-11ea-958c-86dab2977d8b.png)
 
 
   
   
