package DesignPattern;

import java.io.*;
//we did not implement serializable it throws NotSerializableException
public class SingleTonExmple implements Serializable {
    private static final long serialVersionUID = 1L;
    private static SingleTonExmple Instance;

    private SingleTonExmple() {

    }

    public static SingleTonExmple getInstance() {
        try {
            if (Instance == null) {
                Instance = new SingleTonExmple();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Instance;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SingleTonExmple instance1 = SingleTonExmple.getInstance();
        //break singleton using serial and Deserial

            //Serial
            FileOutputStream fileOut = new FileOutputStream("single.ser");
            ObjectOutputStream opOut = new ObjectOutputStream(fileOut);
            opOut.writeObject(instance1);
            fileOut.close();
            opOut.close();
            //deSerial

            FileInputStream filein = new FileInputStream("single.ser");
            ObjectInputStream opin = new ObjectInputStream(filein);
            SingleTonExmple instance2 = (SingleTonExmple) opin.readObject();
            filein.close();
            opin.close();


        //print both instance
        System.out.println("Instance-1:" +instance1.hashCode());
        System.out.println("Instance-2:"+instance2.hashCode());
        //now compare two instance
        if(instance1==instance2){
            System.out.println("Same instance");
        }
        else{
            System.out.println("Singleton broken");
        }
    }
}