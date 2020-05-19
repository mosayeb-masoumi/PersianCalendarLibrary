# PersianCalendarLibrary

   

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
  
 
     for android X
     implementation 'com.github.mosayeb-masoumi:PersianCalendarLibrary:1.1.0'
   
     for other APIs  
     implementation 'com.github.mosayeb-masoumi:PersianCalendarLibrary:1.0.0'

   
    
         how to use:
    
         private void openCalendar() {

        // here we can customize our calendar
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

                .buttonRegisterBackgroundColor(getResources().getColor(R.color.colorAccent))
                .buttonRegisterBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_btn_shape))
                .buttonRegisterTextColor(getResources().getColor(R.color.blue_dark))
                .buttonRegisterTextSize(20)

                .buttonSetTodayBackgroundColor(getResources().getColor(R.color.colorAccent))
                .buttonSetTodayBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_btn_shape))
                .buttonSetTodayTextColor(getResources().getColor(R.color.blue_dark))
                .buttonSetTodayTextSize(20)

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
    
    
   
   
