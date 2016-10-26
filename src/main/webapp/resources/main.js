function proverka(input) {
    ch = input.value.replace(/[^\d,.]/g, '');
    document.getElementById('calories').onkeypress = function (e) {
        if (this.value.indexOf(".") != '-1' || this.value.indexOf(",") != '-1') {
            return !(/[.,]/.test(String.fromCharCode(e.charCode)));
        }
    }
    input.value = ch;
}

function validateForm() {
    var x = document.forms["myForm"]["name"].value;
    var y = document.forms["myForm"]["color"].value;
    if (x == null || x == "") {
        alert("Name must be filled out");
        return false;
    }
    if (y == null || y == "") {
        alert("Color must be filled out");
        return false;
    }
}
