document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('myForm');

    const cepInput = document.getElementById('cep');
    const logradouroInput = document.getElementById('logradouro');
    const numeroInput = document.getElementById('numero');
    const bairroInput = document.getElementById('bairro');
    const complementoInput = document.getElementById('complemento');
    const cidadeInput = document.getElementById('cidade');
    const ufInput = document.getElementById('uf');

    const cepFeedback = document.getElementById('cepFeedback');
    const logradouroFeedback = document.getElementById('logradouroFeedback');
    const numeroFeedback = document.getElementById('numeroFeedback');
    const bairroFeedback = document.getElementById('bairroFeedback');
    const cidadeFeedback = document.getElementById('cidadeFeedback');
    const ufFeedback = document.getElementById('ufFeedback');

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

    function validateCEP(value) {
        const regex = /^[0-9]{8}$/;
        if (!regex.test(value)) {
            return { valid: false, message: 'CEP inválido. Deve conter exatamente 8 dígitos numéricos.' };
        }
        return { valid: true, message: 'CEP válido.' };
    }

    function validateLogradouro(value) {
        if (value.length > 0 && value.length < 4) {
            return { valid: false, message: 'Logradouro deve ter no mínimo 4 caracteres.' };
        }
        return { valid: true, message: 'Logradouro válido.' };
    }

    function validateNumero(value) {
        const regex = /^[0-9]+$/;
        if (!regex.test(value)) {
            return { valid: false, message: 'Número inválido. Deve conter apenas dígitos numéricos.' };
        }
        return { valid: true, message: 'Número válido.' };
    }

    function validateBairro(value) {
        if (value.length > 0 && value.length < 4) {
            return { valid: false, message: 'Bairro deve ter no mínimo 4 caracteres.' };
        }
        return { valid: true, message: 'Bairro válido.' };
    }

    function validateCidade(value) {
        const regex = /^[a-zA-Z\s]{4,}$/;
        if (!regex.test(value)) {
            return { valid: false, message: 'Cidade inválida. Deve ter no mínimo 4 letras e não pode conter caracteres especiais.' };
        }
        return { valid: true, message: 'Cidade válida.' };
    }

    function validateUF(value) {
        const regex = /^[a-zA-Z]{2}$/;
        if (!regex.test(value)) {
            return { valid: false, message: 'UF inválido. Deve ter exatamente 2 letras e não pode conter números ou caracteres especiais.' };
        }
        return { valid: true, message: 'UF válido.' };
    }

    validateInput(cepInput, cepFeedback, validateCEP);
    validateInput(logradouroInput, logradouroFeedback, validateLogradouro);
    validateInput(numeroInput, numeroFeedback, validateNumero);
    validateInput(bairroInput, bairroFeedback, validateBairro);
    validateInput(cidadeInput, cidadeFeedback, validateCidade);
    validateInput(ufInput, ufFeedback, validateUF);
});