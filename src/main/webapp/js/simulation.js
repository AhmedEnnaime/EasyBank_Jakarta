const amountInput = document.getElementById('amount');
const amountValue = document.querySelector('.amount-value');

const monthsInput = document.getElementById('months');
const monthsValue = document.querySelector('.months-value');

amountInput.addEventListener("input", (event) => {
    amountValue.innerText = event.target.value;
});

monthsInput.addEventListener("input", (event) => {
    monthsValue.innerText = event.target.value;
});

