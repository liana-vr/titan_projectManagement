
var chartDataDecoded = decodeHtml(chartTimeData);
var chartJsonArray = JSON.parse(chartDataDecoded)
var resultArray = [];


for(var i in chartJsonArray){
    resultArray.push([i, chartJsonArray[i]]);
}

google.charts.load('current', {'packages':['timeline']});
google.charts.setOnLoadCallback(drawChart);
    
function drawChart() {
    var container = document.getElementById('chart_div');
    var chart = new google.visualization.Timeline(container);
    var dataTable = new google.visualization.DataTable();

    dataTable.addColumn({ type: 'string', id: 'Project' });
    dataTable.addColumn({ type: 'date', id: 'Start' });
    dataTable.addColumn({ type: 'date', id: 'End' });

    for (var i = 0; i < resultArray.length; i++) {
        dataTable.addRows([
                        [resultArray[i][1]["projectName"], 
                        new Date(resultArray[i][1]["startDate"]),
                        new Date(resultArray[i][1]["endDate"])]
            ]);
    }
    
    var options = {
      colors: ["#db009f", "#9600d1", "#0079e0", "#00adab"],
      backgroundColor: '#562a63',
      
      timeline: {rowLabelStyle: {color: 'white'}},
      
    };
    


    chart.draw(dataTable, options);


}