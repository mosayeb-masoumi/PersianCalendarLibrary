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
    
needed minSdk:

     minSdkVersion 18

libray:

    implementation 'com.github.mosayeb-masoumi:PersianCalendarLibrary:2.0'
   
    
# implimentation in java

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

          // layout_root is the id that we set in our layout.xml
        }, layout_root,persianCalendar);
    }
    
  # implimentation in kotlin   
  
    class SecondActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val builder = PersianCalendar.Builder()
                .setMax_year(1402)
                .setMin_year(1398)
                .build()
        
        openCalendar(builder)
    }

    private fun openCalendar(builder: PersianCalendar) {

        val dialogFactory = DialogFactory(this)
        dialogFactory.createCalendarDialog(object : DialogFactory.DialogFactoryInteraction {
            override fun onAcceptButtonClicked(vararg strings: String?) {
            
                 val date: String? = strings.get(0)
                 text_date.text = date
            }

            override fun onDeniedButtonClicked(cancel_dialog: Boolean) {

            }
        
        // layout_root is the id that we set in our layout.xml
        }, layout_root, builder)
    }
    }

    
    
    
 customized PersianCalendar dialog image:
 
 ![customizedPersian Calendar](https://user-images.githubusercontent.com/40134233/82438923-0d38c500-9aaf-11ea-8b25-f9a859cc2127.png)
    
 simple PersianCalendar dialog image:
 
 ![simple_persian_calendar](https://user-images.githubusercontent.com/40134233/82439752-6d7c3680-9ab0-11ea-89ce-65e4a665f43c.png)
 
 
 
 
   
   
