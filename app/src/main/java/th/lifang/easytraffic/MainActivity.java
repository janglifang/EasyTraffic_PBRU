package th.lifang.easytraffic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //---Explicit variable--
    private ListView trafficListView;
    //method onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initial Widget
        initialWidget();

        //create
        createListView();
    }
    // CreateListView
    private void createListView() {
        final String[] strTitle = new String[20];
        strTitle[0] = "ห้ามเลี้ยวซ้าย";
        strTitle[1] = "ห้ามเลี้ยวขวา";
        strTitle[2] = "ตรงไป";
        strTitle[3] = "เลี้ยวขวา";
        strTitle[4] = "เลี้ยวซ้าย";
        strTitle[5] = "ออก";
        strTitle[6] = "เข้า";
        strTitle[7] = "ออก";
        strTitle[8] = "หยุด";
        strTitle[9] = "จำกัดความสูง";
        strTitle[10] = "ทางแยก";
        strTitle[11] = "ห้ามกลับรถ";
        strTitle[12] = "ห้ามจอด";
        strTitle[13] = "มีรถสวนทาง";
        strTitle[14] = "ห้ามแซง";
        strTitle[15] = "เข้า";
        strTitle[16] = "หยุดตรวจ";
        strTitle[17] = "จำกัดความเร็ว";
        strTitle[18] = "จำกัดความกว้าง 2.5 ม.";
        strTitle[19] = "จำกัดความสูง 5 ม.";



        final int[] intImage = {R.drawable.traffic_01,R.drawable.traffic_02,
                R.drawable.traffic_03,R.drawable.traffic_04, R.drawable.traffic_05,
                R.drawable.traffic_06,R.drawable.traffic_07,R.drawable.traffic_08,
                R.drawable.traffic_09,R.drawable.traffic_10,R.drawable.traffic_11,
                R.drawable.traffic_12,R.drawable.traffic_13,R.drawable.traffic_14,
                R.drawable.traffic_15,R.drawable.traffic_16,R.drawable.traffic_17,
                R.drawable.traffic_18,R.drawable.traffic_19,R.drawable.traffic_20};

        MyAdapter objMyAdapter = new MyAdapter(MainActivity.this, intImage, strTitle);
        trafficListView.setAdapter(objMyAdapter);

        //Active onClick on Listview
        trafficListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent objIntent = new Intent(MainActivity.this, DetailActivity.class);

                objIntent.putExtra("Title", strTitle[i]);
                objIntent.putExtra("Image", intImage[i]);
                objIntent.putExtra("Detail", i);


                startActivity(objIntent);
            }
        });

    }

    private void initialWidget() {
        trafficListView = (ListView) findViewById(R.id.listView);
    }

    //method onCreateOptionsMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }






    //method onOptionsItemSelected
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
