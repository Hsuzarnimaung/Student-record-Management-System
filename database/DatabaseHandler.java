package com.example.ucsm.studentrecordmanagement.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ucsm.studentrecordmanagement.model.Record;
import com.example.ucsm.studentrecordmanagement.model.SignUp;
import com.example.ucsm.studentrecordmanagement.model.Student;
import com.example.ucsm.studentrecordmanagement.model.Time;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UCSM on 10/27/2016.
 */

/**
 * Created by UCSM on 10/24/2016.
 */

public class
DatabaseHandler extends SQLiteOpenHelper {

    public static int DATABASE_VERSION = 1;
    public static String DATABASE_NAME = "record_database";
    public static String TABLE_NAME = "student_table";


    public static String DATABASE_ID = "_id";
    public static String STUDENT_ID = "student_id";
    public static String STUDENT_NAME = "student_name";
    public static String STUDENT_ROLLNO = "student_rollno";
    public static String STUDENT_GENDER = "student_gender";
    public static String STUDENT_DOB = "student_dob";
    public static String STUDENT_FATHER = "student_father";
    public static String STUDENT_CLASS = "student_class";
    public static String STUDENT_MAJOR="student_major";
    public static String STUDENT_SECTION = "student_section";
    public static String STUDENT_ACADEMIC="student_academic";
    public static String STUDENT_PHONENO = "student_phoneno";
    public static String STUDENT_EMAIL = "student_email";
    public static String STUDENT_ADDRESS = "student_address";


    public static String TIME_TABLE = "time_table";
    public static String TIME_ID = "id";
    public static String TIME_ACADEMICYEAR = "time_academicyear";
    public static String TIME_CLASS = "time_class";
    public static String TIME_MAJOR = "time_major";
    public static String TIME_DAY = "time_day";
    public static String TIME_SELECTION = "time_selection";
    public static String TIME_TIME1 = "time_time1";
    public static String TIME_TIME2 = "time_time2";
    public static String TIME_TIME3 = "time_time3";
    public static String TIME_TIME4 = "time_time4";
    public static String TIME_TIME5 = "time_time5";
    public static String TIME_TIME6 = "time_time6";
    public static String TIME_TIME7 = "time_time7";

    public static String SIGNUP_TABLE="singup_table";
    public static String SIGNUP_ID="id";
    public static String SIGNUP_USERNAME="signup_username";
    public static String SIGNUP_PASSWORD="signup_password";
    public static String SIGNUP_BACKUP = "signup_backup";

    public final static String ATTENDANCE_TABLE = "attendance_record";
    public final static String ATTENDANCE_ID="_id";
    public final static String DATE ="date";
    public final static String TOTAL_PRESENT = "total_present";
    public final static String TOTAL_ABSENT = "total_absent";
    public final static String TOTAL_STUDENT = "total_student";
    public final static String PRESENT_LIST = "present_list";
    public final static String ABSENT_LIST = "absent_list";


    public DatabaseHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }



    public void onCreate(SQLiteDatabase db) {
        String timetable="CREATE TABLE "+TIME_TABLE+"("
                +TIME_ID+" INTEGER PRIMARY KEY,"
                +TIME_ACADEMICYEAR+" TEXT,"
                +TIME_CLASS+" TEXT,"
                +TIME_MAJOR+" TEXT,"
                +TIME_SELECTION+" TEXT,"
                +TIME_DAY+" TEXT,"
                +TIME_TIME1+" TEXT,"
                +TIME_TIME2+" TEXT,"
                +TIME_TIME3+" TEXT,"
                +TIME_TIME4+" TEXT,"
                +TIME_TIME5+" TEXT,"
                +TIME_TIME6+" TEXT,"
                +TIME_TIME7+" TEXT"
                +")";

        String studentTable="CREATE TABLE "+TABLE_NAME+"("
                +DATABASE_ID+" INTEGER PRIMARY KEY,"
                +STUDENT_ID+" TEXT,"
                +STUDENT_ROLLNO+" TEXT,"
                +STUDENT_NAME+" TEXT,"
                +STUDENT_GENDER+" TEXT,"
                +STUDENT_DOB+" TEXT,"
                +STUDENT_FATHER+" TEXT,"
                +STUDENT_CLASS+ " TEXT,"
                +STUDENT_MAJOR+" TEXT,"
                +STUDENT_SECTION+" TEXT,"
                +STUDENT_ACADEMIC+" TEXT,"
                +STUDENT_PHONENO+" TEXT,"
                +STUDENT_EMAIL+" TEXT,"
                +STUDENT_ADDRESS+" TEXT"
                +")";

        String signupTable="CREATE TABLE "+SIGNUP_TABLE+"("
                +SIGNUP_ID+" INTEGER PRIMARY KEY,"
                +SIGNUP_USERNAME+" TEXT,"
                +SIGNUP_PASSWORD+" TEXT, "
                +SIGNUP_BACKUP+" TEXT "
                +")";


        String recordTable = "CREATE TABLE " + ATTENDANCE_TABLE + " ( " +
                ATTENDANCE_ID + " INTEGER PRIMARY KEY, " + DATE + " TEXT, " +
                TOTAL_PRESENT + " INTEGER ," + TOTAL_ABSENT + " INTEGER, " +
                TOTAL_STUDENT + " INTEGER, " +
                PRESENT_LIST+ " TEXT, " +
                ABSENT_LIST+ " TEXT " +")";

        db.execSQL(recordTable);
        db.execSQL(signupTable);
        db.execSQL(studentTable);
        db.execSQL(timetable);

    }




    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String createTable="DROP TABLE IF EXIT "+TABLE_NAME;
        String createTable2="DROP TABLE IF EXIT "+TIME_TABLE;
        String createTable3="DROP TABLE IF EXIT "+SIGNUP_TABLE;
        String newTable = "DROP TABLE IF EXIT " + ATTENDANCE_TABLE;
        db.execSQL(newTable);
        db.execSQL(createTable2);
        db.execSQL(createTable);
        db.execSQL(createTable3);
        onCreate(db);

    }


    public void insertRecordData(Record record){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(DATE,record.getDate());
        values.put(TOTAL_PRESENT,record.getTotalPre());
        values.put(TOTAL_ABSENT,record.getTotalAb());
        values.put(TOTAL_STUDENT,record.getTotalStu());
        values.put(PRESENT_LIST,record.getPreList());
        values.put(ABSENT_LIST,record.getAbList());
        db.insert(ATTENDANCE_TABLE,null,values);
    }

    public  Cursor getAllData(){
        SQLiteDatabase database1=this.getWritableDatabase();
        String selectData="SELECT * FROM "+ATTENDANCE_TABLE;
        Cursor cursor = database1.rawQuery(selectData, null);
        return cursor;
    }

    /*public Cursor getData(int signUpId){
        return database1.query(TABLE_NAME,new String[]{DATE,TOTAL_PRESENT,TOTAL_ABSENT,TOTAL_STUDENT,PRESENT_LIST,ABSENT_LIST},DATABASE_ID +" =?",new String[]{String.valueOf(signUpId)},null,null,null,null);
    }*/

    public void deleteRecord (Record record) {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(ATTENDANCE_TABLE, ATTENDANCE_ID + " = ?",
                new String[] { String.valueOf(record.getDate()) });
        db.close();
    }

    public Cursor getRecordData(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.query(ATTENDANCE_TABLE,new String[]{ATTENDANCE_ID,DATE,TOTAL_PRESENT,TOTAL_ABSENT,TOTAL_STUDENT,PRESENT_LIST,ABSENT_LIST},
                ATTENDANCE_ID+"=?",new String[]{String.valueOf(id)},null,null,null,null);
    }
    public int updateData(Record record){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DATE,record.getDate());
        values.put(TOTAL_PRESENT,record.getTotalPre());
        values.put(TOTAL_ABSENT,record.getTotalAb());
        values.put(TOTAL_STUDENT,record.getTotalStu());
        values.put(PRESENT_LIST,record.getPreList());
        values.put(ABSENT_LIST,record.getAbList());

        return db.update(TABLE_NAME, values, ATTENDANCE_ID+ " = ?",
                new String[] { String.valueOf(record.getDate())});
    }


    public void insertSignUpData(SignUp signUp){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(SIGNUP_USERNAME,signUp.getSignUpName());
        values.put(SIGNUP_PASSWORD,signUp.getSignUpPassword());
        values.put(SIGNUP_BACKUP,signUp.getBackup());
        db.insert(SIGNUP_TABLE,null,values);
        db.close();

    }


    public List<SignUp> getAllSignUpData(){
        SQLiteDatabase db=this.getWritableDatabase();
        List<SignUp> list=new ArrayList<SignUp>();
        String sql="SELECT * FROM "+SIGNUP_TABLE;
        Cursor cursor=db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do {
                SignUp signUp=new SignUp();
                signUp.setSignUpId(Integer.parseInt(cursor.getString(0)));
                signUp.setSignUpName(cursor.getString(1));
                signUp.setSignUpPassword(cursor.getString(2));
                signUp.setBackup(cursor.getString(3));
                list.add(signUp);
            }while (cursor.moveToNext());

        }

        return list;
    }




    public Cursor getSignUpData(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.query(SIGNUP_TABLE,new String[]{SIGNUP_ID,SIGNUP_USERNAME,SIGNUP_PASSWORD,SIGNUP_BACKUP},SIGNUP_ID+"=?",new String[]{String.valueOf(id)},null,null,null,null);


        return cursor;
    }





    public int updateSignUpData(SignUp signUp){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(SIGNUP_ID,signUp.getSignUpId());
        values.put(SIGNUP_USERNAME,signUp.getSignUpName());
        values.put(SIGNUP_PASSWORD,signUp.getSignUpPassword());
        values.put(SIGNUP_BACKUP,signUp.getBackup());
        return db.update(SIGNUP_TABLE,values,SIGNUP_ID+"=?",new String[]{String.valueOf(signUp.getSignUpId())});
    }






    public void insertStudentData(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(STUDENT_ID, student.getStudentId());
        values.put(STUDENT_ROLLNO, student.getStudentRollNo());
        values.put(STUDENT_NAME, student.getStudentName());
        values.put(STUDENT_GENDER, student.getStudentGender());
        values.put(STUDENT_DOB, student.getStudentDob());
        values.put(STUDENT_FATHER, student.getStudentFather());
        values.put(STUDENT_CLASS, student.getStudentClass());
        values.put(STUDENT_MAJOR,student.getStudentMajor());
        values.put(STUDENT_SECTION, student.getStudentSection());
        values.put(STUDENT_ACADEMIC,student.getStudentAcademic());
        values.put(STUDENT_PHONENO, student.getStudentPhoneno());
        values.put(STUDENT_EMAIL, student.getStudentEmail());
        values.put(STUDENT_ADDRESS, student.getStudentAddress());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }





    public Cursor getAllStudentData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectData = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectData, null);
        return cursor;

    }




    public Cursor getStudentData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{DATABASE_ID,
                STUDENT_ID, STUDENT_ROLLNO,
                STUDENT_NAME, STUDENT_GENDER,
                STUDENT_DOB, STUDENT_FATHER,
                STUDENT_CLASS,STUDENT_MAJOR, STUDENT_SECTION
                ,STUDENT_ACADEMIC
                , STUDENT_PHONENO, STUDENT_EMAIL, STUDENT_ADDRESS}, DATABASE_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        return cursor;
    }





    public void updateStudentData(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(STUDENT_ID, student.getStudentId());
        values.put(STUDENT_ROLLNO, student.getStudentRollNo());
        values.put(STUDENT_NAME, student.getStudentName());
        values.put(STUDENT_GENDER, student.getStudentGender());
        values.put(STUDENT_DOB,student.getStudentDob());
        values.put(STUDENT_FATHER,student.getStudentFather());
        values.put(STUDENT_CLASS,student.getStudentClass());
        values.put(STUDENT_MAJOR,student.getStudentMajor());
        values.put(STUDENT_SECTION,student.getStudentSection());
        values.put(STUDENT_ACADEMIC,student.getStudentAcademic());
        values.put(STUDENT_PHONENO,student.getStudentPhoneno());
        values.put(STUDENT_EMAIL,student.getStudentEmail());
        values.put(STUDENT_ADDRESS,student.getStudentAddress());
        db.update(TABLE_NAME,values,DATABASE_ID+"=?",new String[]{String.valueOf(student.getDatabaseId())});
    }






    public void deleteStudentData(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, DATABASE_ID + "=?", new String[]{String.valueOf(id)});
        db.close();
    }


    public Cursor searchData(String studentData){
        SQLiteDatabase db=this.getWritableDatabase();


        String sql="SELECT * FROM "+TABLE_NAME+" WHERE "+STUDENT_ID+" LIKE "+"\'"+studentData+"%\' "+" OR "+STUDENT_NAME+" LIKE "+"\'"+studentData+"%\' "+" OR "
                +STUDENT_GENDER+" LIKE "+"\'"+studentData+"%\' "+" OR "+STUDENT_ROLLNO+" LIKE "+"\'"+studentData+"%\' "
                +" OR "+STUDENT_DOB+" LIKE "+"\'"+studentData+"%\' "+" OR "+STUDENT_FATHER+" LIKE "+"\'"+studentData+"%\' "
                +" OR "+STUDENT_CLASS+" LIKE "+"\'"+studentData+"%\' "+" OR "+STUDENT_MAJOR+" LIKE "+"\'"+studentData+"%\' "
                +" OR "+STUDENT_SECTION+" LIKE "+"\'"+studentData+"%\' "+" OR "+STUDENT_ACADEMIC+" LIKE "+"\'"+studentData+"%\' "
                +" OR "+STUDENT_PHONENO+" LIKE "+"\'"+studentData+"%\' "+" OR "+STUDENT_EMAIL+" LIKE "+"\'"+studentData+"%\' "
                +" OR "+STUDENT_ADDRESS+" LIKE "+"\'"+studentData+"%\' ";

        Cursor cursor=db.rawQuery(sql,null);


        return cursor;


    }









    public void insertTime(Time time){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(TIME_ACADEMICYEAR,time.getAcademicyear());
        values.put(TIME_CLASS,time.getTimeclass());
        values.put(TIME_MAJOR,time.getTimemajor());
        values.put(TIME_SELECTION,time.getTimeselect());
        values.put(TIME_DAY,time.getTimeday());
        values.put(TIME_TIME1,time.getTime1());
        values.put(TIME_TIME2,time.getTime2());
        values.put(TIME_TIME3,time.getTime3());
        values.put(TIME_TIME4,time.getTime4());
        values.put(TIME_TIME5,time.getTime5());
        values.put(TIME_TIME6,time.getTime6());
        values.put(TIME_TIME7,time.getTime7());
        db.insert(TIME_TABLE,null,values);
        db.close();


    }


    public List<Time> getAllTimeData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String sequence = "SELECT * FROM " + TIME_TABLE;
        List<Time> list=new ArrayList<Time>();
        Cursor cursor = db.rawQuery(sequence, null);
        if (cursor.moveToFirst()) {
            do {
                Time time = new Time();
                time.setTimeId(Integer.parseInt(cursor.getString(0)));
                time.setAcademicyear(cursor.getString(1));
                time.setTimeclass(cursor.getString(2));
                time.setTimemajor(cursor.getString(3));
                time.setTimeday(cursor.getString(4));
                time.setTimeselect(cursor.getString(5));
                time.setTime1(cursor.getString(6));
                time.setTime2(cursor.getString(7));
                time.setTime3(cursor.getString(8));
                time.setTime4(cursor.getString(9));
                time.setTime5(cursor.getString(10));
                time.setTime6(cursor.getString(11));
                time.setTime7(cursor.getString(12));
                list.add(time);
            } while (cursor.moveToNext());


        }
        return list;

    }


    public Time getTimeData(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.query(TIME_TABLE,new String[]{TIME_ID,TIME_ACADEMICYEAR
                ,TIME_CLASS,TIME_MAJOR
                ,TIME_DAY,TIME_SELECTION,
                TIME_TIME1,TIME_TIME2
                ,TIME_TIME3,TIME_TIME4
                ,TIME_TIME5,TIME_TIME6
                ,TIME_TIME7},TIME_ID+"=?",new String[]{String.valueOf(id)},null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        Time time=new Time(Integer.parseInt(cursor.getString(0))
                ,cursor.getString(1),cursor.getString(2)
                ,cursor.getString(3),cursor.getString(4)
                ,cursor.getString(5),cursor.getString(6)
                ,cursor.getString(7),cursor.getString(8)
                ,cursor.getString(9),cursor.getString(10)
                ,cursor.getString(11),cursor.getString(12));
        return time;
    }


    public List<Time> selectTimeTable(Time time){
        String sql;
        String year;
        String timeclass;
        String timemajor;
        String timeselection;
        String timeday;


        if(time.getAcademicyear().equals("All")&& time.getTimeclass().equals("All")
                && time.getTimemajor().equals("All")
                && time.getTimeselect().equals("All")
                && time.getTimeday().equals("All")){
            sql="SELECT * FROM "+TIME_TABLE;
        } else {

            if(!(time.getAcademicyear().equals("All")))
            {
                year=" "+TIME_ACADEMICYEAR+" = "+"\'"+time.getAcademicyear()+"\'";
            } else {
                year="";
            }


            if( time.getTimeclass().equals("All")){
                timeclass="";


            }else if(year.equals("")&&time.getTimeclass().length()>3){

                timeclass=TIME_CLASS+" = "+"\'"+time.getTimeclass()+"\'";
            }else {

                timeclass=" AND "+TIME_CLASS+" = "+"\'"+time.getTimeclass()+"\'";
            }




            if(time.getTimemajor().equals("All")){

                timemajor="";

            }else if(year.equals("")&&timeclass.equals("")&&time.getTimemajor().length()<=3){

                timemajor=TIME_MAJOR+" = "+"\'"+time.getTimemajor()+"\'";
            }else {
                timemajor=" AND "+TIME_MAJOR+" = "+"\'"+time.getTimemajor()+"\'";

            }


            if(time.getTimeselect().equals("All")){
                timeselection="";


            }else if(year.equals("")&&timeclass.equals("")&&timemajor.equals("")&&time.getTimeselect().length()==1){

                timeselection=TIME_SELECTION+" = "+"\'"+time.getTimeselect()+"\'";
            }else {

                timeselection=" AND "+TIME_SELECTION+" = "+"\'"+time.getTimeselect()+"\'";
            }



            if(time.getTimeday().equals("All")){
                timeday="";


            }else if(year.equals("")&&timeclass.equals("")&&timemajor.equals("")&&timeselection.equals("")&&time.getTimeday().length()==3){

                timeday=TIME_DAY+" = "+"\'"+time.getTimeday()+"\'";
            }else {

                timeday=" AND "+TIME_DAY+" = "+"\'"+time.getTimeday()+"\'";

            }



            sql="SELECT * FROM "+TIME_TABLE+" WHERE "+year+timeclass+timemajor+timeselection+timeday;

        }

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(sql,null);
        List<Time> list=new ArrayList<Time>();
        if(cursor.moveToFirst()){

            do {
                Time time1=new Time();
                time1.setTimeId(Integer.parseInt(cursor.getString(0)));
                time1.setAcademicyear(cursor.getString(1));
                time1.setTimeclass(cursor.getString(2));
                time1.setTimemajor(cursor.getString(3));
                time1.setTimeselect(cursor.getString(4));
                time1.setTimeday(cursor.getString(5));
                time1.setTime1(cursor.getString(6));
                time1.setTime2(cursor.getString(7));
                time1.setTime3(cursor.getString(8));
                time1.setTime4(cursor.getString(9));
                time1.setTime5(cursor.getString(10));
                time1.setTime6(cursor.getString(11));
                time1.setTime7(cursor.getString(12));
                list.add(time1);
            }while (cursor.moveToNext());

        }

        return list;
    }





}