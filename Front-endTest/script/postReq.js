

const enviarPost = document.querySelector("#enviar");
const nome = document.getElementById("nome");
const instrumento = document.getElementById("instrumento");


enviarPost.addEventListener("click", async ()=>{
    try{
        const response = await fetch("http://192.168.1.14:8080/v1/api/pessoa/add",{
            method: "POST",
            headers:{
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                nome: nome.value,
                instrumentoId: cat.value
            })
        }) 

        if (response.ok) {
            const resultado = await response.json();
            alert('Sucesso: ' + JSON.stringify(resultado));
        } else {            
            alert('Erro: ' + response.statusText);
        }
    } catch (error) {
        console.error('Erro ao enviar a requisição:', error);
    }
    
    location.reload();
})