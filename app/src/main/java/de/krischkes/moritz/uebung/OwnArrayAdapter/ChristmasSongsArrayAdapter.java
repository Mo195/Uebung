package de.krischkes.moritz.uebung.OwnArrayAdapter;

import android.content.Context;
import android.text.style.DrawableMarginSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.krischkes.moritz.uebung.R;

/**
 * Created by Moritzkrischke on 25/12/15.
 */
public class ChristmasSongsArrayAdapter extends ArrayAdapter{

    private ArrayList<RowContent> allRows;
    private int layoutRessourceID;
    private int drawableOptionIconRessourceID;
    //Create Object to implement synchronized lock concept --> lock is only available once (no function)
    //it must be prevented that there are multiple accesses at the same time
    private Object lock = new Object();
    private Context mContext;

    //todo: check if layoutRessourceID makes any sense here
    public ChristmasSongsArrayAdapter(Context context, int layoutRessourceID, String[] stringsForFirstTV, String[] stringsForSecondTV, int drawableOptionIconRessourceID){
        super(context, layoutRessourceID);
        this.setDrawableOptionIconRessourceID(drawableOptionIconRessourceID);
        this.setLayoutRessourceID(layoutRessourceID);
        this.setmContext(context);
        this.allRows= new ArrayList<RowContent>();
        this.addAll(stringsForFirstTV,stringsForSecondTV);
    }

    //Created own class for contents to order stuff
    class RowContent{
        String firstTVString;
        String secondTVString;
    }

    public void add(RowContent rowContent){
        //need lock to access unsynchronized data structure
        synchronized (lock){
            allRows.add(rowContent);
        }
    }

    public void addAll(String[] stringsForFirstTV, String[] stringsForSecondTV){
        //need lock to access unsynchronized data structure
        synchronized (lock){

            //checking if both arrays have same size (default)
            if(stringsForFirstTV.length==stringsForSecondTV.length){
                for(int i=0; i<=(stringsForFirstTV.length-1);i++){
                    RowContent temp = new RowContent();
                    temp.firstTVString=stringsForFirstTV[i];
                    temp.secondTVString=stringsForSecondTV[i];
                    allRows.add(temp);
                }
            }else{
                //todo: throw exception
                //throw new Exception("Arrays must have the same length");
            }
        }
    }

    public int getCount(){
        return allRows.size();
    }

    //todo:check if solution could work, because RowContent is inner class and unknown to outside --> consider using private modifier
    public RowContent getItem (int position){
        return allRows.get(position);
    }

    //todo:implement
    public View getView(int position, View convertView, ViewGroup parent){
        View row;

        if(convertView==null) {
            //need to create new row
            LayoutInflater layoutInflater = (LayoutInflater) getmContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(layoutRessourceID, parent,false);
        }else {
            row = convertView;
        }

        //get view Ressources from particular row
        TextView firstTV=(TextView)row.findViewById(R.id.interpretTV);
        TextView secondTV=(TextView)row.findViewById(R.id.songTitleTV);
        ImageView optionsIconIV =(ImageView) row.findViewById(R.id.optionsIconIV);

        //get RowContent Object
        RowContent rowContent = allRows.get(position);

        //fill the views with content
        firstTV.setText(rowContent.firstTVString);
        secondTV.setText(rowContent.secondTVString);
        //todo: add images here
        return row;
    }

    //Getter and Setter
    public int getDrawableOptionIconRessourceID() {
        return drawableOptionIconRessourceID;
    }

    public void setDrawableOptionIconRessourceID(int drawableOptionIconRessourceID) {
        this.drawableOptionIconRessourceID = drawableOptionIconRessourceID;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public int getLayoutRessourceID() {
        return layoutRessourceID;
    }

    public void setLayoutRessourceID(int layoutRessourceID) {
        this.layoutRessourceID = layoutRessourceID;
    }
}