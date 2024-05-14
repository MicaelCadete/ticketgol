document.addEventListener('DOMContentLoaded', function() {
    var paymentMethodSelect = document.getElementById('payment-method');
    var qrCodeContainer = document.getElementById('qr-code-container');

    if (!paymentMethodSelect || !qrCodeContainer) {
        console.error('Elemento não encontrado:', !paymentMethodSelect ? 'payment-method' : 'qr-code-container');
        return;
    }

    paymentMethodSelect.addEventListener('change', function() {
        console.log('Valor selecionado:', this.value); // Log para depuração
        if (this.value === 'bank-transfer') {
            qrCodeContainer.style.display = 'block';
        } else {
            qrCodeContainer.style.display = 'none';
        }
    });
});
