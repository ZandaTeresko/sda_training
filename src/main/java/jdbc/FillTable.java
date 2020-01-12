package jdbc;

import java.sql.SQLException;
import java.sql.Statement;

public class FillTable {

    public static void fillUsers() throws SQLException {

        Statement statement = DBUtil.getConnection().createStatement();
        int ret;
        ret = statement.executeUpdate("INSERT users(name, email, city)" +
                "VALUES ('Janis', 'janis@epasts.lv', 'Riga')");
        System.out.println(ret == 1 ? " Janis inserted" : "ERROR");

        ret = statement.executeUpdate("INSERT users(name, email, city)" +
                "VALUES ('Edgars', 'edgars@epasts.lv', 'Ventspils')");

        System.out.println(ret == 1 ? " Edgars inserted" : "ERROR");

        ret = statement.executeUpdate("INSERT users(name, email, city)" +
                "VALUES ('Zaiga', 'zaiga@epasts.lv', 'Sigulda')");

        System.out.println(ret == 1 ? " Zaiga inserted" : "ERROR");

    }

}
