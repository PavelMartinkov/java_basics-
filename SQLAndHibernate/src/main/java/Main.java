import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "Pahan1844";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT `course_name`, (MONTH(MAX(`subscription_date`)) - MONTH(MIN(`subscription_date`)) + 1) / 12 AS `average_subscription`" +
                            " FROM `purchaseList`" +
                            " WHERE `subscription_date` BETWEEN '2018-01-01 00:00:00' AND '2018-12-31 23:59:59'" +
                            " GROUP BY `course_name`");

            while (resultSet.next()) {
                String nameCourses = resultSet.getString("course_name");
                String averageSubscription = resultSet.getString("average_subscription");
                System.out.println(nameCourses + " - " + averageSubscription);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
