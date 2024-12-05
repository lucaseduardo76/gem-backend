

 // Função para deletar uma pessoa
 async function deletePessoa(id) {
    if (confirm('Tem certeza que deseja deletar essa pessoa?')) {
        try {
            const response = await fetch(`http://192.168.1.14:8080/v1/api/pessoa/delete?id=${id}`, {
                method: 'DELETE'
            });

            if (response.ok) {
                alert('Pessoa deletada com sucesso!');
                fetchPessoas(); // Recarrega a tabela
            } else {
                alert('Erro ao deletar pessoa!');
            }
        } catch (error) {
            console.error('Erro ao deletar pessoa:', error);
        }
    }
}
