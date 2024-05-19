document.addEventListener('DOMContentLoaded', function() {
    var paymentMethodSelect = document.getElementById('payment-method');
    var qrCodeContainer = document.getElementById('qr-code-container');
    var confirmButton = document.getElementById('btn-pagamento');

    if (!paymentMethodSelect || !qrCodeContainer || !confirmButton) {
        console.error('Elemento não encontrado:', !paymentMethodSelect ? 'payment-method' : !qrCodeContainer ? 'qr-code-container' : 'btn-pagamento');
        return;
    }

    paymentMethodSelect.addEventListener('change', function() {
        console.log('Valor selecionado:', this.value); // Log para depuração
        if (this.value === 'bank-transfer') {
            qrCodeContainer.style.display = 'block';
            confirmButton.style.display = 'block'; // Exibe o botão de confirmação

        } else {
            qrCodeContainer.style.display = 'none';
            confirmButton.style.display = 'none'; // Oculta o botão de confirmação
        }
    });

    confirmButton.addEventListener('click', function() {
        window.location.href = 'https://mpago.la/2Lwr2oD';
    });
});


