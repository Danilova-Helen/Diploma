window.onload = function () {
    let optOld = document.getElementById('old').getElementsByTagName('option');
    let timeF = document.getElementById('timeF').getElementsByTagName('option');
    optOld[optOld.length-1].setAttribute('style', 'display:none;');
    timeF[timeF.length-1].setAttribute('style', 'display:none;');

    let optNew = document.getElementById('new').getElementsByTagName('option');
    let timeS = document.getElementById('timeS').getElementsByTagName('option');
    optNew[1].setAttribute('style', 'display:none;');
    timeS[1].setAttribute('style', 'display:none;');
};

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
    document.getElementById('but2').setAttribute('value', id);
}

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
        if (Number(optNew[i].value)+9 > Number(optOldValue)+8) {
            optNew[i + 9].setAttribute('style', 'display:none;');
        }
    }
}

/*function selectChanged2(value) {
    let optNew = document.getElementById('timeS').getElementsByTagName('option');
    for (i = 0; i < optNew.length; i++) {
        if (Number(optNew[i].value)-1 < Number(value)) {
            optNew[i].setAttribute('style', 'display:none;');
        }
        else optNew[i].setAttribute('style', 'display:block;');
        if (Number(optNew[i].value)-1 == Number(value)) {
            optNew[i].setAttribute('selected', 'selected');
        }
    }
}*/

function modal2(value) {
    document.location.href ='#dark2';
    let optOld = document.getElementById('old').value;
    let optNew = document.getElementById('new').value;
    let optF = document.getElementById('timeF').getElementsByTagName('option');
        for (i = 0; i < optF.length; i++) {
            if (Number(optF[i].value) == Number(optOld)) {
                optF[i].setAttribute('selected', 'selected');
            }
        }
    let optS = document.getElementById('timeS').getElementsByTagName('option');
    for (i = 0; i < optS.length; i++) {
        if (Number(optS[i].value) == Number(optNew)) {
            optS[i].setAttribute('selected', 'selected');
        }
    }
    let input = document.getElementById('deskNum');
    input.setAttribute('value', value);
}

function modal3() {
    document.location.href ='#dark3';
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'phones.json', true);
    xhr.send();
}
