package rienierpatron.reminders;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "reminderDB.db";
    private static final String TABLE_REMINDERS = "reminders";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_EVENT = "eventName";
    public static final String COLUMN_DATE = "eventDate";
    public static final String COLUMN_TIME = "eventTime";
    public static final String COLUMN_NOTE = "eventNote";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_REMINDERS_TABLE = "CREATE TABLE" + TABLE_REMINDERS + "(" +
                                        COLUMN_ID + "INTEGER PRIMARY_KEY," + COLUMN_EVENT + "TEXT," +
                                        COLUMN_DATE + "TEXT," + COLUMN_TIME + "TEXT," + COLUMN_NOTE + "TEXT" +
                                        COLUMN_STATUS + "INTEGER" + ")";
        db.execSQL(CREATE_REMINDERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REMINDERS);
        onCreate(db);
    }

    public void addReminder(Reminders reminders) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_EVENT, reminders.get_eventName());
        values.put(COLUMN_DATE, reminders.get_eventDate());
        values.put(COLUMN_TIME, reminders.get_eventTime());
        values.put(COLUMN_NOTE, reminders.get_eventNote());
        values.put(COLUMN_STATUS, reminders.get_status());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_REMINDERS, null, values);
        db.close();
    }
}
