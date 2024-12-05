function editarPessoa(id, nome) {
    fetchInstrumento();
    document.getElementById('modalEdit').style.display = 'flex';
    document.getElementById("nomeEdit").value = nome;
    document.getElementById("idPessoa").value = id;
    

}

document.getElementById("enviarEdit").addEventListener("click", async () =>{
    const nomeAtualizado = document.getElementById("nomeEdit");
    const instrumentoIdAtualizado = document.getElementById("catEdit")
    const id = document.getElementById("idPessoa").value
    try {
        const response = await fetch(`http://192.168.1.14:8080/v1/api/pessoa/edit?id=${id}`, {
            method: 'PUT', 
            headers: {
                'Content-Type': 'application/json',  
            },
            body: JSON.stringify(
                {
                    nome: nomeAtualizado.value,
                    instrumentoId: instrumentoIdAtualizado.value
                }
            ), 
        });

      
    } catch (error) {
        console.error('Erro de rede ou outro erro:', error);
    }

    location.reload();
})


