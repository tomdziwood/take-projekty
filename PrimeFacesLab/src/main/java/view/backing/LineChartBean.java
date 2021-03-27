/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.title.Title;

/**
 *
 * @author woodpecker
 */
@Named(value = "lineChartBean")
@RequestScoped
public class LineChartBean {
    
    private LineChartModel trigoChart;

    /**
     * Creates a new instance of LineChartBean
     */
    public LineChartBean() {
        trigoChart = new LineChartModel();
        ChartData data = new ChartData();
        
        List<String> arguments = new ArrayList<>();
        List<Number> sinValues = new ArrayList<>();
        List<Number> cosValues = new ArrayList<>();
        for(int x = 0; x <= 360; x+=10) {
            arguments.add(String.valueOf(x));
            sinValues.add(Math.sin(Math.toRadians(x)));
            cosValues.add(Math.cos(Math.toRadians(x)));
        }
        
        LineChartDataSet sinDataSet = new LineChartDataSet();
        sinDataSet.setData(sinValues);
        sinDataSet.setLabel("Sinus");
        sinDataSet.setYaxisID("sinYaxis");
        sinDataSet.setBorderColor("rgb(255, 0, 0)");
        data.addChartDataSet(sinDataSet);
        
        LineChartDataSet cosDataSet = new LineChartDataSet();
        cosDataSet.setData(cosValues);
        cosDataSet.setLabel("Cosinus");
        cosDataSet.setYaxisID("cosYaxis");
        cosDataSet.setBorderColor("rgb(0, 0, 255)");
        data.addChartDataSet(cosDataSet);
        
        data.setLabels(arguments);
        trigoChart.setData(data);
        
        LineChartOptions options = new LineChartOptions();
        
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes sinLinearAxes = new CartesianLinearAxes();
        sinLinearAxes.setId("sinYaxis");
        sinLinearAxes.setPosition("left");
        cScales.addYAxesData(sinLinearAxes);
        CartesianLinearAxes cosLinearAxes = new CartesianLinearAxes();
        cosLinearAxes.setId("cosYaxis");
        cosLinearAxes.setPosition("right");
        cScales.addYAxesData(cosLinearAxes);
        options.setScales(cScales);
        
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Line chart of trigonometric functions");
        options.setTitle(title);
        
        trigoChart.setOptions(options);
    }

    /**
     * @return the trigoChart
     */
    public LineChartModel getTrigoChart() {
        return trigoChart;
    }

    /**
     * @param trigoChart the trigoChart to set
     */
    public void setTrigoChart(LineChartModel trigoChart) {
        this.trigoChart = trigoChart;
    }
    
}
