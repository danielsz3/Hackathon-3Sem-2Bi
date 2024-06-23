document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('myForm');

    const fullNameInput = document.getElementById('fullName');
    const cpfInput = document.getElementById('cpf');
    const phoneInput = document.getElementById('phone');
    const emailInput = document.getElementById('email');
    const caregiverNameInput = document.getElementById('caregiverName');
    const caregiverPhoneInput = document.getElementById('caregiverPhone');
    const cnsInput = document.getElementById('cns');

    const fullNameFeedback = document.getElementById('fullNameFeedback');
    const cpfFeedback = document.getElementById('cpfFeedback');
    const phoneFeedback = document.getElementById('phoneFeedback');
    const emailFeedback = document.getElementById('emailFeedback');
    const caregiverNameFeedback = document.getElementById('caregiverNameFeedback');
    const caregiverPhoneFeedback = document.getElementById('caregiverPhoneFeedback');
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

    function validateFullName(value) {
        const regex = /^[a-zA-Z\s]{4,}$/;
        if (!regex.test(value)) {
            return { valid: false, message: 'Nome Completo inválido. Deve ter no mínimo 4 letras e não pode ter caracteres especiais.' };
        }
        return { valid: true, message: 'Nome Completo válido.' };
    }

    function validateCPF(value) {
        const regex = /^[0-9]{11}$/;
        if (!regex.test(value)) {
            return { valid: false, message: 'CPF inválido. Deve conter exatamente 11 dígitos numéricos.' };
        }
        return { valid: true, message: 'CPF válido.' };
    }

    function validatePhone(value) {
        const regex = /^[0-9]{11}$/;
        if (!regex.test(value)) {
            return { valid: false, message: 'Telefone inválido. Deve conter exatamente 11 dígitos numéricos.' };
        }
        return { valid: true, message: 'Telefone válido.' };
    }

    function validateEmail(value) {
        const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!regex.test(value)) {
            return { valid: false, message: 'E-mail inválido. Deve conter um @ e um domínio.' };
        }
        return { valid: true, message: 'E-mail válido.' };
    }

    function validateCaregiverName(value) {
        const regex = /^[a-zA-Z\s]{4,}$/;
        if (!regex.test(value)) {
            return { valid: false, message: 'Nome do Cuidador inválido. Deve ter no mínimo 4 letras e não pode ter caracteres especiais.' };
        }
        return { valid: true, message: 'Nome do Cuidador válido.' };
    }

    function validateCaregiverPhone(value) {
        const regex = /^[0-9]{11}$/;
        if (!regex.test(value)) {
            return { valid: false, message: 'Telefone do Cuidador inválido. Deve conter exatamente 11 dígitos numéricos.' };
        }
        return { valid: true, message: 'Telefone do Cuidador válido.' };
    }

    function validateCNS(value) {
        const regex = /^[0-9]{15}$/;
        if (!regex.test(value)) {
            return { valid: false, message: 'CNS inválido. Deve conter exatamente 15 dígitos numéricos.' };
        }
        return { valid: true, message: 'CNS válido.' };
    }

    validateInput(fullNameInput, fullNameFeedback, validateFullName);
    validateInput(cpfInput, cpfFeedback, validateCPF);
    validateInput(phoneInput, phoneFeedback, validatePhone);
    validateInput(emailInput, emailFeedback, validateEmail);
    validateInput(caregiverNameInput, caregiverNameFeedback, validateCaregiverName);
    validateInput(caregiverPhoneInput, caregiverPhoneFeedback, validateCaregiverPhone);
    validateInput(cnsInput, cnsFeedback, validateCNS);
});