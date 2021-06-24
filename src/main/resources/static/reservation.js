function show()
{
    $.ajax({
        url: "http://localhost:8080/reservations",
        method: "GET",
        cache: false,
        success: function (data){
            $("#table_book").children('tr').remove();
            for (const obj of data) {
                $('#table tbody').append("<tr value=" + obj.id +"><td>" + obj.desk.number + "</td><td>" + obj.fio + "</td><td>" + obj.tel + "</td><td>" + obj.quantity + "</td><td>" + obj.beginTime.time + "</td><td>" + obj.endTime.time + "</td><td>" + obj.com + "</td><th><button " + "value=" + obj.id + " class=delete onclick=\"del(value)\">" + "Удалить" + "</button></th>" + "</tr>");
            }
        }
    });
}

$(document).ready(function(){
    show();
    setInterval('show()',10000);
});

function del(value) {
    $.ajax({
        url: "http://localhost:8080/reservation/"+value,
        method: "DELETE",
        cache: false,
        success: function (){
            show();
        }
    });
}