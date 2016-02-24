package com.manikandansethuraj.nepeancricketclub;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by ManikandanSethuraj on 2016-02-23.
 */
public class DataBasePlayers {

    SqlDataCreateUpdate sqlDataCreateUpdate;
    public DataBasePlayers(Context context){

        sqlDataCreateUpdate = new SqlDataCreateUpdate(context);
    }

    public long insert(String firstname, String lastname, String playertype, int fivematches, int fiveinns, int fiveruns, int fivewkts, int fourmatches, int fourinns, int fourruns, int fourwkts, int twomatches, int twoinns, int tworuns, int twowkts){

        SQLiteDatabase sqLiteDatabase = sqlDataCreateUpdate.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(sqlDataCreateUpdate.FIRST_NAME, firstname);
        contentValues.put(sqlDataCreateUpdate.LAST_NAME, lastname);
        contentValues.put(sqlDataCreateUpdate.TYPE_PLAYER, playertype);
        contentValues.put(sqlDataCreateUpdate.FIVE_NOMATCHES, fivematches);
        contentValues.put(sqlDataCreateUpdate.FIVE_INN, fiveinns);
        contentValues.put(sqlDataCreateUpdate.FIVE_RUNS, fiveruns);
        contentValues.put(sqlDataCreateUpdate.FIVE_WKS, fivewkts);
        contentValues.put(sqlDataCreateUpdate.FOUR_NOMATCHES, fourmatches);
        contentValues.put(sqlDataCreateUpdate.FOUR_INN, fourinns);
        contentValues.put(sqlDataCreateUpdate.FOUR_RUNS, fourruns);
        contentValues.put(sqlDataCreateUpdate.FOUR_WKS, fourwkts);
        contentValues.put(sqlDataCreateUpdate.TWO_NOMATCHES, twomatches);
        contentValues.put(sqlDataCreateUpdate.TWO_INN, twoinns);
        contentValues.put(sqlDataCreateUpdate.TWO_RUNS, tworuns);
        contentValues.put(sqlDataCreateUpdate.TWO_WKS, twowkts);

        long id = sqLiteDatabase.insert(sqlDataCreateUpdate.TABLE_NAME,null,contentValues);
        return id;
    }

    public String getAllData(){

        SQLiteDatabase sqLiteDatabase = sqlDataCreateUpdate.getWritableDatabase();

        String[] columns = { SqlDataCreateUpdate.FIRST_NAME, SqlDataCreateUpdate.LAST_NAME};
        Cursor cursor = sqLiteDatabase.query(SqlDataCreateUpdate.TABLE_NAME, columns, null, null, null, null, null);
        StringBuffer stringBuffer = new StringBuffer();
        while (cursor.moveToNext()){
            int id = cursor.getColumnCount();
            String cuname = cursor.getString(0);
            String cupass = cursor.getString(1);
            stringBuffer.append(cuname+" "+cupass+"\n");
        }
        return stringBuffer.toString();

    }


    static public class SqlDataCreateUpdate extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "Nepean";
        private static final String TABLE_NAME = "PlayersTable";
        private static final int DATABASE_VERSION = 1;
        private static final String UID = "_id";
        private static final String FIRST_NAME = "First_Name";
        private static final String LAST_NAME = "Last_Name";
        private static final String TYPE_PLAYER = "Type_Player";
        private static final String FIVE_NOMATCHES = "Five_Matches";
        private static final String FIVE_INN = "Five_Inn";
        private static final String FIVE_RUNS = "Five_Runs";
        private static final String FIVE_WKS = "Five_Wkts";
        private static final String FOUR_NOMATCHES = "Four_Matches";
        private static final String FOUR_INN = "Four_Inn";
        private static final String FOUR_RUNS = "Four_Runs";
        private static final String FOUR_WKS = "Four_Wkts";
        private static final String TWO_NOMATCHES = "Two_Matches";
        private static final String TWO_INN = "Two_Inn";
        private static final String TWO_RUNS = "Two_Runs";
        private static final String TWO_WKS = "Two_Wkts";

        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+FIRST_NAME+" VARCHAR(255), "+LAST_NAME+" VARCHAR(255), "
                +TYPE_PLAYER+" VARCHAR(30), "+FIVE_NOMATCHES+" INTEGER, "+FIVE_INN+" INGEGER, "+FIVE_RUNS+ " INTEGER, "+FIVE_WKS+ " INTEGER, " +FOUR_NOMATCHES+" INTEGER, "+FOUR_INN+" INTEGER, "+FOUR_RUNS+" INTEGER, "+FOUR_WKS+
        " INTEGER, "+TWO_NOMATCHES+" INTEGER, "+TWO_INN+" INTEGER, "+TWO_RUNS+ " INTEGER, "+TWO_WKS+ " INTEGER);" ;

        private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;
        private Context context;


        public SqlDataCreateUpdate(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
            Toast.makeText(context, "Cons", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
                Log.d("DB Created :", "DB created");
                Toast.makeText(context,"CREATE",Toast.LENGTH_SHORT).show();
                Log.d("DB CREATION :",context.toString());
            } catch (SQLException e) {
                e.printStackTrace();
                Toast.makeText(context,e.toString(),Toast.LENGTH_SHORT).show();
                Log.d("Error: ",e.toString());

            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



                try {
                    db.execSQL(DROP_TABLE);
                    onCreate(db);
                    Log.d("DB Updated :", "DB created");
                } catch (SQLException e) {
                    e.printStackTrace();
                    Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();

                }


        }



    }

}
