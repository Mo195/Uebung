package de.krischkes.moritz.uebung;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.krischkes.moritz.uebung.ActiveAndroid.Person;

public class ActiveAndroidActivity extends Activity {

    //keys for retrieve old input
    private final String INPUTAGE ="input_age";
    private final String INPUTCITY="input_city";

    EditText inputAge, inputCity;
    TextView outputAverageAge, outputVoteDistribution;
    Button add;
    ArrayList<Long> allIds;
    SharedPreferences sharedPrefs;
    List<Person> allPersons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_android);

        //initialize ActiveAndroid
        ActiveAndroid.initialize(getApplication());
        allIds = new ArrayList<>();

        //get views
        inputAge = (EditText) findViewById(R.id.inputAge);
        inputCity = (EditText) findViewById(R.id.inputCity);

        outputAverageAge = (TextView) findViewById(R.id.outputAverageAge);
        outputVoteDistribution = (TextView) findViewById(R.id.outputVoteDistribution);

        add = (Button) findViewById(R.id.add);
        //implementing showresults
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int vote=0;
                //get vote of Person
                if(((RadioButton)findViewById(R.id.votedSPD)).isChecked()){
                    vote = 0;
                }else if(((RadioButton)findViewById(R.id.votedCDU)).isChecked()){
                    vote=1;
                }else if(((RadioButton)findViewById(R.id.votedLinke)).isChecked()){
                    vote=2;
                }else if(((RadioButton)findViewById(R.id.votedGruene)).isChecked()){
                    vote=3;
                }
                Person tempPerson = new Person(Integer.valueOf(inputAge.getText().toString()), inputCity.getText().toString(), vote);
                long id = tempPerson.save();
                allIds.add(id);
                generateResults();
            }
        });

    }

    protected void onStart(){
        super.onStart();
        sharedPrefs = getPreferences(MODE_PRIVATE);
        inputAge.setText(sharedPrefs.getString(INPUTAGE,null));
        inputCity.setText(sharedPrefs.getString(INPUTCITY,null));
        this.generateResults();
    }

    protected void onStop(){
        super.onStop();
        SharedPreferences.Editor edit= sharedPrefs.edit();
        edit.putString(INPUTAGE,inputAge.getText().toString());
        edit.putString(INPUTCITY, inputCity.getText().toString());
        edit.commit();
    }


    private void generateResults (){
        allPersons = new Select().from(Person.class).execute();
        Iterator iterator = allPersons.iterator();
        double averageAge=0;
        int allAges=0;
        int votesCDU=0;
        int votesFDP=0;
        int votesGruene=0;
        int votesSPD=0;
        while(iterator.hasNext()){
            Person tempPerson = (Person)iterator.next();
            allAges += tempPerson.getAge();
            switch(tempPerson.getVote()){
                case 0:
                    votesSPD+=1;
                    break;
                case 1:
                    votesCDU+=1;
                    break;
                case 2:
                    votesFDP+=1;
                    break;
                case 3:
                    votesGruene+=1;
                    break;
            }}
        //prevent division by 0
        if ((votesCDU+votesFDP+votesGruene+votesSPD)!=0){
            averageAge = allAges / (votesCDU + votesFDP + votesGruene + votesSPD);
        }
        //show results on screen
        outputAverageAge.setText("Durchschnittsalter: "+String.valueOf(averageAge));
        outputVoteDistribution.setText("Votes SPD: "+String.valueOf(votesSPD) +"\n"+
                "Votes CDU: "+String.valueOf(votesCDU) +"\n"+
                "Votes Die Linke: "+String.valueOf(votesFDP) +"\n"+
                "Votes Die Grünen: "+String.valueOf(votesGruene) +"\n");
    }
}
