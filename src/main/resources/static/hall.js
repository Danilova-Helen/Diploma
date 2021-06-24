window.onload = function () {
    let optOld = document.getElementById('old').getElementsByTagName('option');
    optOld[optOld.length-1].setAttribute('style', 'display:none;');

    let optNew = document.getElementById('new').getElementsByTagName('option');
    optNew[1].setAttribute('style', 'display:none;');

    $("#qua").val('1');
};

function selectChanged1() {
    let optOld = document.getElementById('old').getElementsByTagName('option');
    let optNew = document.getElementById('new').getElementsByTagName('option');

    let optOldValue = document.getElementById('old').value;
    let optNewValue  = document.getElementById('new').value;

    for (let i = 0; i < optNew.length; i++) {
        if (Number(optNew[i].value)-1 < optOldValue) {
            optNew[i].setAttribute('style', 'display:none;');
        } else optNew[i].removeAttribute('style');
        if (Number(optNew[i].value)-1 == optOldValue) {
            optNew[i].setAttribute('selected', 'selected');
        } else optNew[i].removeAttribute('selected');
    }

    for (let i = 0; i < optNew.length; i++) {
        if (Number(optNew[i].value) - Number(optOldValue) > 8) {
            optNew[i].setAttribute('style', 'display:none;');
        }
    }

    let child = document.querySelector('.but').children;

    for (let i = 0; i < child.length; i++) {
        child[i].removeAttribute('disabled');
    }

    optOldValue = document.getElementById('old').value;
    optNewValue  = document.getElementById('new').value;

    $.ajax({
        url: "http://localhost:8080/times",
        method: "POST",
        data: {beginTimeId:optOldValue, endTimeId:optNewValue},
        success: function(data) {
            const tables = data.map((booking) => booking.desk.id);
            const buttons = $(".but").children('button');
            for (const btn of buttons) {
                const btnId = btn.id;
                if (tables.includes(Number(btnId))) {
                    $(btn).css('box-shadow', '0 0 15px 1px #ff0000, inset 0 0 5px 1px #ff0000');
                    btn.setAttribute('disabled', 'disabled');
                } else {
                    $(btn).css('box-shadow', '0 0 15px 1px #00ff00, inset 0 0 5px 1px #00ff00');
                    btn.removeAttribute('disabled');
                }
            }
        }
    });
}

function closeD1() {
    document.location.href ='#';

    $("#picture").children('img').remove();
    $("#timeF").children('h3').remove();
    $("#timeS").children('h3').remove();
    $("#qua").val('1');
}

function modal1(id, value, number) {
    document.location.href ='#dark1';

    if (value == 1) {
        let title = "<h1>Барный стул №"+number+"</h1>";
        document.getElementById('table').innerHTML = title;
    } else {
        let title = "<h1>Стол №"+number+"</h1>";
        document.getElementById('table').innerHTML = title;
    }

    let str = "<h3>Количество мест: "+value+"</h3>";

    document.getElementById('place').innerHTML = str;
    document.getElementById('place').setAttribute('value', value);
    document.getElementById('but2').setAttribute('value', id);

    $.ajax({
        url: "http://localhost:8080/desk/"+id+"/img",
        method: "GET",
        cache: false,
        success: function (data){
            $('#picture').append("<img class=\"picTable\" src=\"../"+data+"\">");
        }
    });
}

function modal2(value) {
    document.location.href ='#dark2';

    let selOld = $("#old");
    let selectOldV = selOld.find('option:selected').val();
    let selectOldT = selOld.find('option:selected').text();

    $("#timeF").append("<h3>"+ selectOldT +"</h3>");
    $("#timeFin").attr("value", selectOldV);

    let selNew = $("#new");
    let selectNewV = selNew.find('option:selected').val();
    let selectNewT = selNew.find('option:selected').text();

    $("#timeS").append("<h3>"+ selectNewT +"</h3>");
    $("#timeSin").attr("value", selectNewV);

    let input = document.getElementById('deskNum');
    input.setAttribute('value', value);

    let max = document.getElementById('place').getAttribute('value');
    $("#qua").attr('max', max);

}

function modal3() {
    document.location.href ='#dark3';
}
