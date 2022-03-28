package random;

public class DataTypeSize {

    public static void main(String[] args) {
        int i = 4;
        float f = 4;
        System.out.println(i);
        System.out.println(f);

        Integer intObj = new Integer(10);
        Float floatObj = 4.0f;
        System.out.println(intObj);
        System.out.println(floatObj.getClass());

        Object o = true ? intObj : floatObj;
        System.out.println("Obj using ternary operator = " + o);
    }
}
