package de.krischkes.moritz.uebung.ContentClasses;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created to get used to JSON
 */
public class Car {

    private int wheels;
    private Engine engine;
    private int doors;
    private String name;
    private double price;
    private ArrayList<Service> services;

    //JSON keys
    private final String WHEELKEY="car_wheels";
    private final String ENGINEKEY="car_engine";
    private final String DOORSKEY="car_doors";
    private final String NAMEKEY="car_name";
    private final String PRICEKEY="car_price";
    private final String SERVICEKEY="car_service";


    public Car(int wheels, int hoursePower, int cubicCapacity, boolean fuel, int doors, String name, double price, int date, double servicePrice, int milage){
        //instantiate ArrayList
        services= new ArrayList<>();
        //create other fields
        this.setWheels(wheels);
        this.setEngine(hoursePower, cubicCapacity, fuel);
        this.setDoors(doors);
        this.setName(name);
        this.setPrice(price);
        this.addService(date, servicePrice, milage);
    }

    //Method handles parsing to JSON
    public String toJSON(){
        JSONObject carJSON = new JSONObject();
        String jsonString="";
        try{
            carJSON.put(WHEELKEY, this.getWheels());
            carJSON.put(ENGINEKEY, getEngine().toJSON());
            carJSON.put(DOORSKEY, this.getDoors());
            carJSON.put(NAMEKEY, this.getName());
            carJSON.put(PRICEKEY, this.getPrice());
            //handling multiple items
            JSONArray servicesJSONArray = new JSONArray();
            for(int i=0; i<services.size();i++){
                JSONObject tempServiceJSON = (services.get(i)).toJson();
                servicesJSONArray.put(tempServiceJSON);
            }
            //adding Array to JSON
            carJSON.put(SERVICEKEY, servicesJSONArray);
            //parsing json to string (with pretty spacing --> just for human readability)
            //parameter of toString() show how many spaces are used to intend each level
            jsonString = carJSON.toString(2);
        }catch(JSONException ex){
            Log.d("car","error parsing car to JSON");
        }
        return jsonString;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public void addService(int date, double price, int milage) {
        Service service= new Service(date,price,milage);
        services.add(service);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }


    public void setEngine(int hoursePower, int cubicCapacity, boolean fuel) {
        Engine tempEngine= new Engine(hoursePower,cubicCapacity,fuel);
        this.engine = tempEngine;
    }

    public Engine getEngine(){
        return engine;
    }

    //inner class to work with JSON in JSON
    class Engine{

        private int hoursePower;
        private int cubicCapacity;
        private boolean fuel; //false = unleaded, true = diesel

        //JSON keys
        private final String HOURSEPOWERKEY="engine_hoursepower";
        private final String CUBICCAPACITYKEY="engine_cubiccapacity";
        private final String FUELKEY="engine_fuel";

        public Engine(int hoursePower, int cubicCapacity, boolean fuel){
            this.setHoursePower(hoursePower);
            this.setCubicCapacity(cubicCapacity);
            this.setFuel(fuel);
        }

        //method handles parsing to JSON
        public JSONObject toJSON(){
            JSONObject engineJSON = new JSONObject();
            try{
                engineJSON.put(HOURSEPOWERKEY,this.getHoursePower());
                engineJSON.put(CUBICCAPACITYKEY, this.getCubicCapacity());
                engineJSON.put(FUELKEY,this.getFuel());
            }catch(JSONException ex){
                Log.d("car","Error by parsing engine to JSON");
            }
            return engineJSON;
        }

            //Getter and Setter
        public int getHoursePower() {
            return hoursePower;
        }

        public void setHoursePower(int hoursePower) {
            this.hoursePower = hoursePower;
        }

        public int getCubicCapacity() {
            return cubicCapacity;
        }

        public void setCubicCapacity(int cubicCapacity) {
            this.cubicCapacity = cubicCapacity;
        }

        public boolean getFuel() {
            return fuel;
        }

        public void setFuel(boolean fuel) {
            this.fuel = fuel;
        }
    }

    //inner class to show behaviour of JSON arrays
    class Service{

        private int date;
        private double price;
        private int milage;

        //JSON keys
        private final String DATEKEY ="service_date";
        private final String PRICEKEY ="service_price";
        private final String MILAGEKEY ="service_milage";

        public Service(int date, double price, int milage){
            this.setDate(date);
            this.setPrice(price);
            this.setMilage(milage);
        }

        //method that handles parsing to JSON
        public JSONObject toJson(){
            JSONObject serviceJSON = new JSONObject();
            try{
                serviceJSON.put(DATEKEY, this.getDate());
                serviceJSON.put(PRICEKEY, this.getPrice());
                serviceJSON.put(MILAGEKEY, this.getMilage());
            }catch (JSONException ex){
                Log.d("Car", "Error by parsing Service to JSON");
            }
            return serviceJSON;
        }

        //Getter and Setter
        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getMilage() {
            return milage;
        }

        public void setMilage(int milage) {
            this.milage = milage;
        }
    }
}
