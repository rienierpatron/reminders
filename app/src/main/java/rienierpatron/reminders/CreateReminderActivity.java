package rienierpatron.reminders;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class CreateReminderActivity extends AppCompatActivity {
    EditText eventDate, eventTime, eventNote;
    int year_x,month_x,day_x,minute_x,hour_x;
    static final int DIALOG_ID = 0, DIALOG_ID2 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_reminder);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);
        showDateOnEditTextTouch();
        showTimeOnEditTextTouch();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_reminder, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.save) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showDateOnEditTextTouch() {
        eventDate = (EditText)findViewById(R.id.event_date);

        eventDate.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        /*eventDate.setInputType(InputType.TYPE_NULL);*/
                        showDialog(DIALOG_ID);
                        return true;
                    }
                }
        );

        eventDate.setOnFocusChangeListener(
                new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if(hasFocus){
                            eventDate.setInputType(InputType.TYPE_NULL);
                            showDialog(DIALOG_ID);
                        }else{
                            eventDate.setInputType(InputType.TYPE_CLASS_TEXT);
                        }

                        //return true;
                    }
                }
        );

    }

    public void showTimeOnEditTextTouch() {
        eventTime = (EditText)findViewById(R.id.event_time);
        eventNote = (EditText)findViewById(R.id.event_note);
        eventTime.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        /*eventDate.setInputType(InputType.TYPE_NULL);*/
                        showDialog(DIALOG_ID2);
                        return true;
                    }
                }
        );

        eventTime.setOnFocusChangeListener(
                new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if(hasFocus){
                            showDialog(DIALOG_ID2);
                            eventTime.clearFocus();
                        }else{
                            eventTime.setInputType(InputType.TYPE_CLASS_TEXT);
                            eventNote.requestFocus();
                            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.showSoftInput(eventNote, InputMethodManager.SHOW_IMPLICIT);
                        }
                        //return true;
                    }
                }
        );

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(id == DIALOG_ID)
            return new DatePickerDialog(CreateReminderActivity.this, datepickerListener, year_x, month_x, day_x);
        else if (id == DIALOG_ID2)
            return new TimePickerDialog(CreateReminderActivity.this, timepickerListener, hour_x, minute_x, false);
        return null;
    }

    private DatePickerDialog.OnDateSetListener datepickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
            year_x = year;
            month_x = monthOfYear + 1;
            day_x = dayOfMonth;
            //Toast.makeText(CreateReminderActivity.this, year_x + "/" + month_x + "/" + day_x, Toast.LENGTH_LONG).show();
            String givenDate = year_x + "/" + month_x + "/" + day_x;
            eventDate.setText(givenDate.toString());
        }
    };

    private TimePickerDialog.OnTimeSetListener timepickerListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourofDay, int minute){
            hour_x = hourofDay;
            String AM_PM = (hour_x < 12)? "AM" : "PM";
            if(hour_x > 12){
                hour_x -= 12;
            }else if(hour_x == 0){
                hour_x = 12;
            }
            minute_x = minute;
            String hr = (hour_x < 10)? "0":"";
            String mt = (minute_x < 10)? "0":"";
            String givenTime = hr + hour_x + ":" + mt + minute_x + " " + AM_PM;
            eventTime.setText(givenTime.toString());
        }

    };

}
