package th.lifang.easytraffic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by jumpeena on 8/18/2015.
 */
public class MyAdapter extends BaseAdapter

{ //Main Class
    //Explicit
    private Context objContext;
    private int[] iconInts;
    private string[] titleStrings;

    public MyAdapter(Context objContext, int[] iconInts, string[] titleStrings) {
        this.objContext = objContext;
        this.iconInts = iconInts;
        this.titleStrings = titleStrings;
    }

    @Override
    public int getCount() {return 0;}

    @Override
    public Object getItem(int i) {return null;}

    @Override
    public long getItemId(int i) {return 0;}

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {

        return null;
    }
} //Main Class
