var chartData = decodeHtml(chartData);
var chartJson = JSON.parse(chartData);

var arrayLength = chartJson.length;
var numericData = [];
var labelData = [];

for(var i=0; i < arrayLength; i++){
	numericData[i] = chartJson[i].value;
	labelData[i] = chartJson[i].label;
}

Chart.defaults.global.defaultFontColor = 'rgba(255,255,255,0.6)';
new Chart(document.getElementById("myPieChart"), {
    type: 'doughnut',
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#db009f", "#9600d1", "#0079e0", "#00adab"],
            data: numericData,
            borderWidth: 0
        }]
    },

    // Configuration options go here
    options: {
    	title: {
    		display: true,
    		fontSize: 20
    	}
    	
    }
});

function decodeHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}