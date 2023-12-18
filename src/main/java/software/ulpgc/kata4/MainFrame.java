package software.ulpgc.kata4;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private HistogramDisplay histogramDisplay;

    public MainFrame(){
        this.setTitle("Weight Histogram");
        this.setSize(800,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(createHistrogramDisplay());
    }

    private Component createHistrogramDisplay() {
        histogramDisplay = new JFreeChartHistogramDisplay();
        return (Component) histogramDisplay;
    }

    public HistogramDisplay histogramDisplay(){
        return histogramDisplay;
    }
}
