document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('myForm');

    const cnsInput = document.getElementById('cns');
    const cnsFeedback = document.getElementById('cnsFeedback');

    function validateInput(input, feedback, validationFunc) {
        input.addEventListener('input', function() {
            const result = validationFunc(input.value);
            if (result.valid) {
                feedback.textContent = '';
                input.classList.remove('is-invalid');
                input.classList.add('is-valid');
            } else {
                feedback.textContent = result.message;
                input.classList.remove('is-valid');
                input.classList.add('is-invalid');
            }
        });
    }

    function validateCNS(value) {
        const regex = /^[0-9]{15}$/;
        if (!regex.test(value)) {
            return { valid: false, message: 'CNS inválido. Deve conter exatamente 15 dígitos numéricos.' };
        }
        return { valid: true, message: '<br><br> CNS válido.' };
    }

    validateInput(cnsInput, cnsFeedback, validateCNS);
});