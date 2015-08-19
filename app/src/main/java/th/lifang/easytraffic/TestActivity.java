package th.lifang.easytraffic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {

    //Explicit
    private TextView questionTextView;
    private ImageView trafficImageView;
    private RadioGroup choiceRadioGroup;
    private RadioButton choice1RadioButton,choice2RadioButton,
            choice3RadioButton, choice4RadioButton;

    private String[] questionStrings;
    private int[] imageInts;

    private int radioAnInt;  //AnInt ได้มาจาก Ctrl + Space
    private int indexAnInt; //Check index ของ if ใน myModel

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //ใช้สำหรับ RadioButton

        //Bind Widget
        bindWidget();

        //Radio controller
        radioController();

    } //onCreate
    public void clickAnswer(View view) {
        if (radioAnInt==0) {
            Toast.makeText(TestActivity.this, "Please answer",Toast.LENGTH_SHORT).show();
            //กรณีที่ไม่มีการเลือกคำตอบให้แสดงประมาณ 4 วินาที ด้วยข้อความ Please answer
        } else {
            myModel();
        }
    }//clickAnswer
    private void showAnswerDialog() {

    }
    private void myModel() {
        if (indexAnInt == 9) {
            showAnswerDialog();
        } else {
            indexAnInt += 1;  //เปลี่ยนข้อ
            //Change View
            changeView(indexAnInt);

        }
    } //myModel

    private void changeView(int anInt) {
        //change Question
        questionTextView.setText(questionStrings[anInt]); //ข้อที่ 2
        //change Image
        trafficImageView.setImageResource(imageInts[anInt]);
        //change Choice
        int[] intTimes = {R.array.times1, R.array.times2,
                R.array.times3, R.array.times4,
                R.array.times5, R.array.times6,
                R.array.times7, R.array.times8,
                R.array.times9, R.array.times10};
        String[] strChoice = getResources().getStringArray(intTimes[anInt]);
        choice1RadioButton.setText(strChoice[0]);
        choice2RadioButton.setText(strChoice[1]);
        choice3RadioButton.setText(strChoice[2]);
        choice4RadioButton.setText(strChoice[3]);
    }


    private void radioController() {
      choiceRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(RadioGroup radioGroup, int i) {
              switch (i) {
                  case R.id.radioButton:
                      radioAnInt = 1;
                      break;
                  case R.id.radioButton2:
                      radioAnInt = 2;
                      break;
                  case R.id.radioButton3:
                      radioAnInt = 3;
                      break;
                  case R.id.radioButton4:
                      radioAnInt = 4;
                      break;
                  default:
                      radioAnInt = 0;
                      break;
              }

          }
      });
    }

    //Activity Life Cycle
    // การดึงคลาสสำเร็จรูป ชื่อ start  เพื่อให้ทำการทำงานเป็นเมทอดแรก อยู่ใน oncreate การทำแบบนี้เรียนก override
    @Override
    protected void onStart() {
        //Setup
        questionStrings = getResources().getStringArray(R.array.question);
        imageInts = new int[10];
        imageInts[0] = R.drawable.traffic_01;
        imageInts[1] = R.drawable.traffic_02;
        imageInts[2] = R.drawable.traffic_03;
        imageInts[3] = R.drawable.traffic_04;
        imageInts[4] = R.drawable.traffic_05;
        imageInts[5] = R.drawable.traffic_06;
        imageInts[6] = R.drawable.traffic_07;
        imageInts[7] = R.drawable.traffic_08;
        imageInts[8] = R.drawable.traffic_09;
        imageInts[9] = R.drawable.traffic_10;

        String[] strChoice = getResources().getStringArray(R.array.times1); //กำหนดตัวแรก mvc

        //just Start
        questionTextView.setText(questionStrings[0]);
        trafficImageView.setImageResource(imageInts[0]);
        choice1RadioButton.setText(strChoice[0]);
        choice2RadioButton.setText(strChoice[1]);
        choice3RadioButton.setText(strChoice[2]);
        choice4RadioButton.setText(strChoice[3]);

        super.onStart();
    }

    private void bindWidget() {
        questionTextView = (TextView) findViewById(R.id.txtQuestion);
        trafficImageView = (ImageView) findViewById(R.id.imvTrafficTest);
        choiceRadioGroup = (RadioGroup) findViewById(R.id.ragChoice);
        choice1RadioButton = (RadioButton) findViewById(R.id.radioButton);
        choice2RadioButton = (RadioButton) findViewById(R.id.radioButton2);
        choice3RadioButton = (RadioButton) findViewById(R.id.radioButton3);
        choice4RadioButton = (RadioButton) findViewById(R.id.radioButton4);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
