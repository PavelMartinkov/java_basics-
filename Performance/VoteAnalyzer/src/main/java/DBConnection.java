import java.sql.*;

public class DBConnection {

    private static Connection connection;

    private static String dbName = "learn";
    private static String dbUser = "root";
    private static String dbPass = "Pahan1844";

    private static StringBuilder insertQuery = new StringBuilder();

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/".concat(dbName).concat(
                                "?user=").concat(dbUser).concat("&password=").concat(dbPass));
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count");
                connection.createStatement().execute("CREATE TABLE voter_count("
                        .concat("id INT NOT NULL AUTO_INCREMENT, ")
                        .concat("name TINYTEXT NOT NULL, ")
                        .concat("birthDate DATE NOT NULL, ")
                        .concat("`count` INT NOT NULL, ")
                        .concat("PRIMARY KEY(id),")
                        .concat("UNIQUE KEY name_date(name(50), birthDate))"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void executeMultiInsert() throws SQLException {
        String sql = "INSERT INTO voter_count(name, birthDate, `count`)"
                .concat("VALUES").concat(insertQuery.toString())
                .concat("ON DUPLICATE KEY UPDATE `count` = `count` + 1");
        DBConnection.getConnection().createStatement().execute(sql);
    }

    public static void countVoter(String name, String birthDay) throws SQLException {
        birthDay = birthDay.replace('.', '-');
        if (insertQuery.length() <= 1_500_000) {
            insertQuery.append((insertQuery.length() == 0 ? "" : ",").concat("('")
                    .concat(name).concat("', '").concat(birthDay).concat("', 1)"));
        } else {
            executeMultiInsert();
            insertQuery.setLength(0);
        }
    }

    public static void printVoterCounts() throws SQLException {
        String sql = "SELECT name, birthDate, `count` FROM voter_count WHERE `count` > 1";
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
        while (rs.next()) {
            System.out.println("\t".concat(rs.getString("name")).concat(" (")
                    .concat(rs.getString("birthDate")).concat(") - ").concat(String.valueOf(rs.getInt("count"))));
        }
    }
}
