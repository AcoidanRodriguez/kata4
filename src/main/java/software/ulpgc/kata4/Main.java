package software.ulpgc.kata4;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Person> people = TsvFilePersonLoader.with("hw_25000.tsv").load();
        Histogram weightHistogram = new WeightHistogram(people);
        MainFrame mainFrame = new MainFrame();
        mainFrame.histogramDisplay().show(weightHistogram);
        mainFrame.setVisible(true);
    }
}

