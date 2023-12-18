package software.ulpgc.kata4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;

public class SQLitePersonLoader implements  PersonLoader{
    private static final String QUERY = "select * from Persons;" ;
    private final Connection connection;

    public SQLitePersonLoader(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Person> load() {
        try {
            return load(queryAll());
        } catch (SQLException e) {
            return emptyList();
        }
    }

    private List<Person> load(ResultSet resultSet) throws SQLException {
        List<Person> people = new ArrayList<>();
        while(resultSet.next())
            people.add(personFrom(resultSet));
        return people;
    }

    private Person personFrom(ResultSet resultSet) throws SQLException {
        return new Person(
                resultSet.getInt("Index"),
                resultSet.getDouble("Height"),
                resultSet.getDouble("Weight")
        );
    }

    private ResultSet queryAll() throws SQLException {
        return connection.createStatement().executeQuery(QUERY);
    }
}
