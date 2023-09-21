package app.ij.mlwithtensorflowlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class fruitselection extends AppCompatActivity {

    myDBHelper myHelper;
    EditText edtName, edtNumber, edtNameResult, edtNumberResult;
    Button btnInit, btnInsert, btnSelect;
    SQLiteDatabase sqlDB;
    TextView mTime;
    TextView editTextText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruitselection);

        // Intent로 전달된 텍스트 값 가져오기
        Intent intent = getIntent();
        String text = intent.getStringExtra("TEXT");

        // TextView 찾기
        editTextText = findViewById(R.id.edtName); // 여기서 'textViewId'는 실제로 사용하는 TextView의 ID로 변경해야 합니다.

        // TextView에 텍스트 설정
        editTextText.setText(text);

        edtName = findViewById(R.id.edtName);
        edtNumber = findViewById(R.id.edtNumber);
        edtNameResult = findViewById(R.id.edtNameResult);
        edtNumberResult = findViewById(R.id.edtNumberResult);
        mTime = findViewById(R.id.mTime);
        btnInit = findViewById(R.id.btnInit);
        btnInsert = findViewById(R.id.btnInsert);
        btnSelect = findViewById(R.id.btnSelect);
        myHelper = new myDBHelper(this);

        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                myHelper.onUpgrade(sqlDB, 1, 2);
                sqlDB.close();
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                String name = edtName.getText().toString();
                String number = edtNumber.getText().toString();

                // 현재 시간을 가져옵니다.
                long now = System.currentTimeMillis();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
                String currentTime = sdf.format(new Date(now));
                mTime.setText("버튼을 누른 시간: " + currentTime);

                String insertQuery = "INSERT INTO groupTBL (gName, gNumber, gTime) VALUES ('" + name + "', " + number + ", '" + currentTime + "');";
                sqlDB.execSQL(insertQuery);
                sqlDB.close();

                edtName.setText("");
                edtNumber.setText("");

                // 입력 후 자동으로 조회 실행
                performSelect();

                Toast.makeText(getApplicationContext(), "입력됨", Toast.LENGTH_SHORT).show();
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 수동으로 조회 버튼을 클릭할 때 사용되던 내용은 제거합니다.
                // 코드 수정 없이 이 핸들러만 비워두어도 됩니다.
            }
        });

        // 앱 시작 시 초기 조회 실행
        performSelect();
    }

    // 자동으로 데이터베이스 조회를 수행하는 메서드 추가
    private void performSelect() {
        sqlDB = myHelper.getReadableDatabase();
        Cursor cursor;
        cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);

        String strNames = "과일" + "\r\n" + "-------" + "\r\n";
        String strNumbers = "갯수" + "\r\n" + "-------" + "\r\n";
        String strTimes = "시간" + "\r\n" + "-------" + "\r\n";

        while (cursor.moveToNext()) {
            strNames += cursor.getString(0) + "\r\n";
            strNumbers += cursor.getString(1) + "\r\n";
            strTimes += cursor.getString(2) + "\r\n";
        }

        edtNameResult.setText(strNames.toString());
        edtNumberResult.setText(strNumbers.toString());
        mTime.setText(strTimes.toString());

        cursor.close();
        sqlDB.close();
    }

    public class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context) {
            super(context, "groupDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE groupTBL (gName CHAR(20) PRIMARY KEY, gNumber INTEGER, gTime DATETIME);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS groupTBL");
            onCreate(db);
        }
    }
}