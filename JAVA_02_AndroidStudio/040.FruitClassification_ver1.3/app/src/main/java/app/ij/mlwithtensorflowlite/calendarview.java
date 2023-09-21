package app.ij.mlwithtensorflowlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import app.ij.mlwithtensorflowlite.R;
import app.ij.mlwithtensorflowlite.fruitselection;

public class calendarview extends Activity {

    private TextView dateTextView;
    private TextView fruitTextView;
    private SQLiteDatabase sqlDB;
    private Button btnRestart;
    private EditText etxRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendarview);
        dateTextView = findViewById(R.id.dateTextView);
        fruitTextView = findViewById(R.id.fruitTextView);
        btnRestart = findViewById(R.id.btnRestart);
        etxRestart = findViewById(R.id.etxRestart);

        // 데이터베이스 연결
        fruitselection.myDBHelper dbHelper = new fruitselection.myDBHelper(this);
        sqlDB = dbHelper.getReadableDatabase();

        CalendarView calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                String selectedDate = year + "-" + (month + 1) + "-" + dayOfMonth;

                // 데이터베이스에서 날짜에 해당하는 데이터를 조회
                String fruitData = getFruitDataFromDatabase(selectedDate);

                dateTextView.setText("날짜: " + selectedDate);
                fruitTextView.setText("" + fruitData);
            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // etxRestart에서 입력한 값을 가져옴
                String selectedDate = etxRestart.getText().toString();

                // 데이터베이스에서 선택한 날짜에 해당하는 데이터를 조회
                String fruitData = getFruitDataFromDatabase(selectedDate);

                dateTextView.setText("날짜: " + selectedDate);
                fruitTextView.setText("" + fruitData);
            }
        });
    }

    // 데이터베이스에서 날짜에 해당하는 과일 데이터를 가져오는 메서드
    private String getFruitDataFromDatabase(String selectedDate) {
        StringBuilder fruitData = new StringBuilder();

        Cursor cursor = sqlDB.rawQuery("SELECT * FROM groupTBL WHERE SUBSTR(gTime, 1, 10) = ?", new String[]{selectedDate});

        while (cursor.moveToNext()) {
            String name = cursor.getString(0);
            int number = cursor.getInt(1);
            fruitData.append(name).append(" ").append(number).append("개, ").append("\n");
        }
        cursor.close();

        if (fruitData.length() > 0) {
            // 마지막 쉼표 제거
            fruitData.setLength(fruitData.length() - 2);
        } else {
            fruitData.append("데이터가 없습니다.");
        }

        return fruitData.toString();
    }
}
