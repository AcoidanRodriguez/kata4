package software.ulpgc.kata4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:db1.db")){
            List<Person> people = new SQLitePersonLoader(connection).load();
            Histogram weightHistogram = new WeightHistogram(people);
            MainFrame mainFrame = new MainFrame();
            mainFrame.histogramDisplay().show(weightHistogram);
            mainFrame.setVisible(true);

        }
    }
}

