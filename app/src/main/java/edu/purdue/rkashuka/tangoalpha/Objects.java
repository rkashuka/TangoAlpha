package edu.purdue.rkashuka.tangoalpha;

/**
 * Created by harshparakh on 11/13/16.
 */

public class Objects {
    private static String Name;
    private static String Birthday;
    private static String Diagnosis;

    public Objects(){

    }

    public Objects(String name, String birthday, String diagnosis){
        this.Name = name;
        this.Birthday = birthday;
        this.Diagnosis = diagnosis;
    }
    public String getName(){
        return Name;
    }
    public String getBirthday(){
        return Birthday;
    }
    public String getDiagnosis(){
        return Diagnosis;
    }

    public void setName(String name){
        this.Name = name;
    }
    public void setBirthday(String birthday){
        this.Birthday = birthday;
    }
    public void setDiagnosis(String diagnosis){
        this.Diagnosis = diagnosis;
    }
}
