document.getElementById('jogoForm').addEventListener('submit', function (event) {
    event.preventDefault(); // Evita o envio do formulário padrão

    // Verifica se todos os campos estão preenchidos
    var nomeJogo = document.getElementById('nomeEvento').value;
    var setorJogo = document.getElementById('setor').value;
    var localJogo = document.getElementById('local').value;
    var dataJogo = document.getElementById('data').value;
    var horarioJogo = document.getElementById('horario').value;
    var quantidadeJogo = document.getElementById('qtdDisponivel').value;

    // Verifica se algum campo está vazio
    if (nomeJogo.trim() === '' || setorJogo.trim() === '' || localJogo.trim() === '' || dataJogo.trim() === '' || horarioJogo.trim() === '' || quantidadeJogo.trim() === '') {
        // Se algum campo estiver vazio, exiba uma mensagem de erro
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Por favor, preencha todos os campos!',
        });
    } else {
        // Se todos os campos estiverem preenchidos, exiba o alerta de sucesso
        Swal.fire({
            icon: 'success',
            title: 'Cadastro realizado com sucesso!',
            showConfirmButton: false,
            timer: 1500
        });
    }
});
