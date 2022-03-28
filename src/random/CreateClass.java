package random;

import java.io.*;

//Different ways to create objects

public class CreateClass {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {

        //1. Using new keyword
        RandomClass obj = new RandomClass();
        System.out.println("Using new : " + obj);

        //2. Using newInstance() method of class
        Class c = Class.forName(RandomClass.class.getName());
        obj = (RandomClass) c.newInstance();
        System.out.println("Using newInstance() : " + obj);

//        System.out.println(InorderTraversal.class.getName());
//        System.out.println(InorderTraversal.class.getCanonicalName());
//        System.out.println(InorderTraversal.class.getSimpleName());
//        System.out.println(InorderTraversal.class.getTypeName());

        //3. Using clone() method ->> No constructor invoked
        RandomClass cloneObj = obj.clone();
        System.out.println("Using clone() : " + cloneObj);

        //4. Serialization Deserialization ->> No Constructore invoked
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("file.txt"));
        RandomClass randomObj = new RandomClass();
        randomObj.setX(10);
        randomObj.setY(12);
        System.out.println("Serializing Object...");
        os.writeObject(randomObj);
        os.close();

        System.out.println("Deserializing Object...");
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("file.txt"));
        RandomClass desObj = (RandomClass) is.readObject();
        System.out.println("Deserialised Obj = " + desObj);
        is.close();
    }
}
