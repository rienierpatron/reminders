package rienierpatron.reminders;

public class Reminders {

    private int _id, _status;
    private String _eventName,_eventDate, _eventTime, _eventNote;

    public Reminders() {

    }

    public Reminders(int id, int status, String eventName, String eventDate, String eventTime, String eventNote) {
        this._id = id;
        this._status = status;
        this._eventName = eventName;
        this._eventDate = eventDate;
        this._eventTime = eventTime;
        this._eventNote = eventNote;
    }

    public Reminders(String eventName, String eventDate, String eventTime, String eventNote) {
        this._eventName = eventName;
        this._eventDate = eventDate;
        this._eventTime = eventTime;
        this._eventNote = eventNote;
    }

    public void setID(int id) {
        this._id = id;
    }

    public int getID() {
        return this._id;
    }

    public void setStatus(int status) {
        this._status = status;
    }

    public int get_status() {
        return this._status;
    }

    public void setEventName(String eventName) {
        this._eventName = eventName;
    }

    public String get_eventName() {
        return this._eventName;
    }

    public void setEventDate(String eventDate) {
        this._eventDate = eventDate;
    }

    public String get_eventDate() {
        return this._eventDate;
    }

    public void setEventTime(String eventTime) {
        this._eventTime = eventTime;
    }

    public String get_eventTime() {
        return this._eventTime;
    }

    public void setEventNote(String eventNote) {
        this._eventNote = eventNote;
    }

    public String get_eventNote() {
        return this._eventNote;
    }

}
