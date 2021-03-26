var chartData = decodeHtml(chartData);
var chartJson = JSON.parse(chartData);

var arrayLength = chartJson.length;
var numericData = [];
var labelData = [];

for(var i=0; i < arrayLength; i++){
	numericData[i] = chartJson[i].value;
	labelData[i] = chartJson[i].label;
}

new Chart(document.getElementById("myPieChart"), {
    type: 'doughnut',
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#ffb6b9", "#fae3d9", "#bbded6"],
            data: numericData
        }]
    },

    // Configuration options go here
    options: {
    	title: {
    		display: true,
    		text: "Current Project Status"
    	}
    }
});

function decodeHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}