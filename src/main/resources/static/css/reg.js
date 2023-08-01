let flag = false;

function test(obj) {


}

function changePass1() {
    let pass1 = document.getElementById('pass1');
    if (/[а-яА-ЯЁё]/.test(pass1.value)) {
        pass1.setCustomValidity("Нельзя вводить русские буквы!")
    } else {
        pass1.setCustomValidity("");
    }
}

function changePass2() {
    let pass1 = document.getElementById('pass1');
    let pass2 = document.getElementById('pass2');
    if (pass1.value !== pass2.value) {
        pass2.setCustomValidity("Пароли не совпадают");
    } else {
        pass2.setCustomValidity("");
    }
}

let sizePhoneNumber;

function setCursor() {
    let obj = document.getElementById('phone-number');
    if (obj.value.length < 5) {
        obj.value = "+7()";
        sizePhoneNumber = obj.value.length;
        flag = true;
    }
    let end = obj.value.length;
    if (end < 7) {
        obj.setSelectionRange(end - 1, end - 1);
        obj.focus();
    }
}

function changePhoneNumber(obj) {
    if (obj.value.length === 7) {
        let end = obj.value.length;
        obj.setSelectionRange(end, end);
        obj.focus();
    }
    if (obj.value.length < sizePhoneNumber && obj.value.length === 7) {
        let end = obj.value.length;
        obj.value = obj.value.substring(0, obj.value.length - 2) + ")";
        obj.setSelectionRange(end - 2, end - 2);
        obj.focus();
        console.log('opaoap');
    }
    sizePhoneNumber = obj.value.length;
    if (obj.value.length > 14) {
        obj.setCustomValidity("Invalid");
    } else {
        obj.setCustomValidity("");
    }

}

function test4() {
    console.log(document.getElementById('pass1').checkValidity())
}

function noDigits(event) {
    if ("1234567890".indexOf(event.key) !== -1)
        event.preventDefault();
}

