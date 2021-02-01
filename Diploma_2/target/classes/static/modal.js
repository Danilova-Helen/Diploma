window.onload = function () {

};

function modal(value, number) {
    document.location.href ='#dark';
    if (value == 1) {
        let title = "<h1>Барный стул №"+number+"</h1>";
        document.getElementById('table').innerHTML = title;
    } else {
        let title = "<h1>Стол №"+number+"</h1>";
        document.getElementById('table').innerHTML = title;
    }
    let str = "<h3>Количество мест: "+value+"</h3>";
    document.getElementById('place').innerHTML = str;
}