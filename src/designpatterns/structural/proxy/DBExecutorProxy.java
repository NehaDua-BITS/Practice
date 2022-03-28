package designpatterns.structural.proxy;

public class DBExecutorProxy implements IExecutor {

    private DBExecutor dbExecutor;

    private boolean isAdmin;

    public DBExecutorProxy(String username, String password) {
        isAdmin = username.equals("admin") && password.equals("admin");
        dbExecutor = new DBExecutor();
    }

    @Override
    public void execute(String query) {
        if (!isAdmin) {
            throw new RuntimeException("Delete allowed only for admins");
        }
        dbExecutor.execute(query);
    }
}
