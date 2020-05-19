# PersianCalendarLibrary

  for android X
   implementation 'com.github.mosayeb-masoumi:PersianCalendarLibrary:1.1.0'
   
  for other APIs  
   implementation 'com.github.mosayeb-masoumi:PersianCalendarLibrary:1.0.0'


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
  
 
   
   
    
    how to use:
    
       private void openCalendar() {
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
                    // layout_root is the id of layout
        }, layout_root);
    }
    
    
    ![image](https://github.com/mosayeb-masoumi/PersianCalendarLibrary/blob/master/app/src/main/res/drawable/calendar.png)
   
