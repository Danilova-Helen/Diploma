window.onload = function () {

};

function modal(value, id) {
    document.location.href ='#dark';
    if (id == 'c1' || id == 'c2' || id == 'c3' || id == 'c4' || id == 'c5') {
        let title = "<h1>Барный стул №"+id.substring(1)+"</h1>";
        document.getElementById('table').innerHTML = title;
    } else {
        let title = "<h1>Стол №"+id.substring(1)+"</h1>";
        document.getElementById('table').innerHTML = title;
    }
    let str = "<h3>Количество мест: "+value+"</h3>";
    document.getElementById('place').innerHTML = str;
}