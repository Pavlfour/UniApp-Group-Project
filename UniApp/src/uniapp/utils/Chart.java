package uniapp.utils;

import java.awt.Toolkit;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import org.jfree.chart.axis.NumberAxis;
import uniapp.database.DBQueries;

public class Chart {

    public static String totalUniversities;

    public static void createChart(int numOfTopSearches) {
        DBQueries.initializeDB();

        // Παίρνουμε τα δεδομένα με το query
        List<University> universities = DBQueries.topSearches(numOfTopSearches);
        DBQueries.closeDB();
        totalUniversities = String.valueOf(universities.size());
        // Φτιάχνουμε ένα dataset με τα πανεπιστήμια
        DefaultCategoryDataset dataset = createDataset(universities);

        // Create a chart based on the dataset
        JFreeChart chart = createChart(dataset);

        // Create a panel to hold the chart
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        // Create a JFrame to display the chart
        JFrame frame = new JFrame("Διάγραμμα");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Chart.class.getResource("/uniapp/media/cap.png")));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }

    // Create a dataset for the bar chart
    private static DefaultCategoryDataset createDataset(List<University> universitiesList) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (University uni : universitiesList) {

            dataset.addValue(uni.getSearches(), uni.getCurrentName(), uni.getCurrentName());

        }

        return dataset;
    }

    // Create a bar chart using the dataset
    private static JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Top " + totalUniversities + " University Searches", // Chart title
                "University", // X-axis label
                "Searches", // Y-axis label
                dataset, // Data
                PlotOrientation.VERTICAL, // Orientation
                false, // Hide legend (no need since labels are directly below bars)
                true, // Enable tooltips
                false // Disable URLs
        );

        var plot = chart.getCategoryPlot();
        var renderer = new org.jfree.chart.renderer.category.BarRenderer();

        // Set the bar width
        renderer.setMaximumBarWidth(0.5);

        // Reduce gap between bars by setting item margin
        renderer.setItemMargin(0.01);

        plot.setRenderer(renderer);

        // Set background color to white
        chart.setBackgroundPaint(java.awt.Color.WHITE);
        plot.setBackgroundPaint(java.awt.Color.WHITE);

        // Ensure Y-axis displays integers only
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        // Force integer display
        yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        return chart;
    }

}
