package software.ulpgc.kata4;

import java.io.*;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.*;

public class TsvFilePersonLoader implements PersonLoader{
    private final File file;

    private TsvFilePersonLoader(File file) {
        this.file = file;
    }
    public static TsvFilePersonLoader with(String file){
        return new TsvFilePersonLoader(new File(file));
    }

    @Override
    public List<Person> load() {
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return load(reader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Person> load(BufferedReader reader) {
        return reader.lines()
                .skip(1)
                .map(line->toPerson(line))
                .collect(toList());
    }

    private Person toPerson(String line) {
        return toPerson(line.split("\t"));
    }

    private Person toPerson(String[] split) {
        return new Person(
                parseInt(split[0]),
                parseDouble(split[1]),
                parseDouble(split[2])
        );
    }
}
