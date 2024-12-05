

// Função para buscar os dados e preencher a tabela
async function fetchPessoas() {
    try {
        const response = await fetch('http://192.168.1.14:8080/v1/api/pessoa');
        const data = await response.json();
        const tbody = document.querySelector('#pessoaTable tbody');

        // Limpa a tabela antes de renderizar novamente
        tbody.innerHTML = '';

        data.forEach(pessoa => {
            const tr = document.createElement('tr');

            tr.innerHTML = `
                <td>${pessoa.id}</td>
                <td>${pessoa.nome}</td>
                <td>${pessoa.instrumento.nome}</td>
                <td>${pessoa.instrumento.categoriaInstrumento}</td>
                <td>
                    <button class="delete-btn" onclick="deletePessoa(${pessoa.id})">Deletar</button>

                    <button class="edit-btn" onclick="editarPessoa('${pessoa.id}' ,'${pessoa.nome}')">Editar</button>
                </td>
            `;

            tbody.appendChild(tr);
        });
    } catch (error) {
        console.error('Erro ao buscar dados:', error);
    }
}


async function fetchInstrumento() {
    try {
        const response = await fetch('http://192.168.1.14:8080/v1/api/inst');
        const data = await response.json();
        const select = document.querySelector('#cat');
        const selectEdit = document.querySelector('#catEdit');
        // Limpa a tabela antes de renderizar novamente
        select.innerHTML = `<option value="" selected disabled >Selecione um instrumento</option>`;

        selectEdit.innerHTML = `<option value="" selected disabled >Selecione um instrumento</option>`;

        data.forEach(instrumento => {

            select.innerHTML += `
                <option value="${instrumento.id}">${instrumento.nome}</option>
            `;

            selectEdit.innerHTML += `
                <option value="${instrumento.id}">${instrumento.nome}</option>
            `;

        });
    } catch (error) {
        console.error('Erro ao buscar dados:', error);
    }
}

/*
async function pessoaFindById (id) {

    

    console.log(`http://localhost:8080/v1/api/pessoa/findById?id=${id}`)

    try {
        const response = await fetch(`http://localhost:8080/findById?id=1`, {
            method: "GET",
            Headers: {
                'Content-Type': "application/json"
            }
        });

        const data = await response.json();
    
        if (response.ok) {
            const data = await response.json();
            // Exibe o resultado no HTML
            alert(`Resultado: ${JSON.stringify(data)}`);
        } else {
            alert(`Erro: ${response.status} - ${response.statusText}`);
        }

        return data;
    } catch (error) {
        console.error('Erro ao buscar o recurso:', error);
        resultadoDiv.innerText = 'Erro ao conectar ao servidor.';
    }

}
*/
fetchInstrumento()
fetchPessoas();