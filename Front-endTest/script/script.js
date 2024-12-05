const apiUrl = 'http://localhost:8080/v1/api/pessoa';

const apiUrlInstrumento = 'http://localhost:8080/v1/api/inst';

 function abrirModal() {
    document.getElementById('modal').style.display = 'flex';
}

function fecharModal() {
    document.getElementById('modal').style.display = 'none';
}


function abrirModalEdit() {
    document.getElementById('modalEdit').style.display = 'flex';
}

function fecharModalEdit() {
    document.getElementById('modalEdit').style.display = 'none';
}