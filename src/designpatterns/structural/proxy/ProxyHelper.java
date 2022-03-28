package designpatterns.structural.proxy;

/**
 * Structural Design Pattern - improves structure of the java code
 * Used to control access
 * For ex: in databases control access to delete operation
 */
public class ProxyHelper {

    public static void main(String[] args) {
        IExecutor executor = new DBExecutorProxy("admin", "admin");
        executor.execute("query123");

        executor = new DBExecutorProxy("non-admin", "admin");
        try {
            executor.execute("query456");
        } catch (Exception ex) {
            System.out.println("Execute Failed : " + ex.getMessage());
        }
    }
}
