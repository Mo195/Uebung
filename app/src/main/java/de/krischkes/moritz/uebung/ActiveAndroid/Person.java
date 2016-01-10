package de.krischkes.moritz.uebung.ActiveAndroid;

/**
 * Created by Moritzkrischke on 10/01/16.
 */
import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;


    @Table(name ="Person")
    public class Person extends Model {

        @Column(name="city")
        private String city;
        @Column(name="age")
        private int age;
        @Column(name = "vote")
        private int vote;

        public Person(){
            super();
            //default constructor --> required by ActiveAndroid
        }

        public Person(int age, String city, int vote){
            super();
            this.setAge(age);
            this.setCity(city);
            this.setVote(vote);
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getVote() {
            return vote;
        }

        public void setVote(int vote) {
            this.vote = vote;
        }
    }

