/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.model.chart.LineChartModel;

/**
 *
 * @author woodpecker
 */
@Named(value = "chartBean")
@RequestScoped
public class ChartBean {
    
    private org.primefaces.model.chart.LineChartModel trigoZoomedChart;

    /**
     * Creates a new instance of ChartBean
     */
    public ChartBean() {
        trigoZoomedChart = new LineChartModel();
        
        org.primefaces.model.chart.LineChartSeries sinSeries = new org.primefaces.model.chart.LineChartSeries();
        sinSeries.setLabel("Sinus");
        for(int x = 0; x < 360; x += 10) {
            sinSeries.set(x, Math.sin(Math.toRadians(x)));
        }
        
        org.primefaces.model.chart.LineChartSeries cosSeries = new org.primefaces.model.chart.LineChartSeries();
        cosSeries.setLabel("Cosinus");
        for(int x = 0; x < 360; x += 10) {
            cosSeries.set(x, Math.cos(Math.toRadians(x)));
        }
        
        trigoZoomedChart.addSeries(sinSeries);
        trigoZoomedChart.addSeries(cosSeries);
        
        trigoZoomedChart.setTitle("Zoomed chart");
        trigoZoomedChart.setZoom(true);
    }

    /**
     * @return the trigoZoomedChart
     */
    public LineChartModel getTrigoZoomedChart() {
        return trigoZoomedChart;
    }

    /**
     * @param trigoZoomedChart the trigoZoomedChart to set
     */
    public void setTrigoZoomedChart(LineChartModel trigoZoomedChart) {
        this.trigoZoomedChart = trigoZoomedChart;
    }
    
}
