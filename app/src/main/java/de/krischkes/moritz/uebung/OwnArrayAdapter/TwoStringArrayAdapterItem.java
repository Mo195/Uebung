package de.krischkes.moritz.uebung.OwnArrayAdapter;

/**
 * Created by Moritzkrischke on 25/12/15.
 */
public class TwoStringArrayAdapterItem {

    String valueForLeftTextView;
    String valueForRightTextView;

    //this class has been created to reuse AdapterCode

    public TwoStringArrayAdapterItem(String valueForLeftTextView, String valueForRightTextView){
        this.setValueForLeftTextView(valueForLeftTextView);
        this.setValueForRightTextView(valueForRightTextView);
    }

    public String getValueForLeftTextView() {
        return valueForLeftTextView;
    }

    public void setValueForLeftTextView(String valueForLeftTextView) {
        this.valueForLeftTextView = valueForLeftTextView;
    }

    public String getValueForRightTextView() {
        return valueForRightTextView;
    }

    public void setValueForRightTextView(String valueForRightTextView) {
        this.valueForRightTextView = valueForRightTextView;
    }
}
