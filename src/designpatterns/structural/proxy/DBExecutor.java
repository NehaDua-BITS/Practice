package designpatterns.structural.proxy;

public class DBExecutor implements IExecutor {

    @Override
    public void execute(String query) {
        System.out.println("Query executed : " + query);
    }
}
