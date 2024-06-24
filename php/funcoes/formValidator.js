import CPFvalidator from './CPFvalidator.js';

function validateCPF() {
    const cpf = document.getElementById('cpf').value;
    const feedback = document.getElementById('cpfFeedback');
    if (!CPFvalidator(cpf)) {
        feedback.textContent = "CPF inválido";
        feedback.style.display = "block";
        return false;
    } else {
        feedback.style.display = "none";
        return true;
    }
}

function validateFormData() {
    return new Promise((resolve, reject) => {
        const cpf = document.getElementById('cpf').value;
        const cns = document.getElementById('cns').value;
        const phone = document.getElementById('phone').value;
        const email = document.getElementById('email').value;

        const xhr = new XMLHttpRequest();
        xhr.open("POST", "validateData.php", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {
                    const response = JSON.parse(xhr.responseText);
                    if (Object.keys(response).length === 0) {
                        resolve();
                    } else {
                        reject(response);
                    }
                } else {
                    reject({ error: "Erro ao validar os dados." });
                }
            }
        };

        const params = `cpf=${cpf}&cns=${cns}&phone=${phone}&email=${email}`;
        xhr.send(params);
    });
}

function cadastrarUsuario() {
    if (validateCPF()) {
        validateFormData()
            .then(() => {
                document.getElementById('myForm').action = 'dados';
                document.getElementById('myForm').submit();
            })
            .catch(errors => {
                for (const key in errors) {
                    const feedback = document.getElementById(key + 'Feedback');
                    feedback.textContent = errors[key];
                    feedback.style.display = "block";
                }
            });
    }
}

export { validateCPF, cadastrarUsuario };
