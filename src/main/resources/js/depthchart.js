var url = "https://api.binance.com/api/v3/depth?symbol=XTZUSDT&limit=5000";

function httpGet(url){
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", url, false ); // false for synchronous request
    xmlHttp.send( null );
    return xmlHttp.responseText;
}


var xtzJson = httpGet(url);

console.log(xtzJson);