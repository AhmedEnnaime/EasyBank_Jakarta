const amountInput = document.getElementById('amount');
const amountValue = document.querySelector('.amount-value');

const monthsInput = document.getElementById('months');
const monthsValue = document.querySelector('.months-value');

const nextBtn = document.querySelector('.btn-div');
const simulation_top_card = document.querySelector('.simulation-top-card');
const info_top_card = document.querySelector('.info-top-card');

const info_card = document.querySelector('.info-card');
const simulation_card = document.querySelector('.card');
const back_btn = document.querySelector('.back-btn');

const monthly_payment_input = document.getElementById("monthly_payment");

const proportional_annual_rate = 0.12;

amountInput.addEventListener("input", (event) => {
    amountValue.innerText = event.target.value;
    monthly_payment_input.value = calculateMonthlyPayment();
});

monthsInput.addEventListener("input", (event) => {
    monthsValue.innerText = event.target.value;
    monthly_payment_input.value = calculateMonthlyPayment();
});

nextBtn.addEventListener("click", () => {
    simulation_top_card.classList.remove("active");
    info_top_card.classList.add("active");
    info_card.classList.remove("hidden");
    simulation_card.classList.add("hidden");
});

back_btn.addEventListener("click", () => {
    simulation_top_card.classList.add("active");
    info_top_card.classList.remove("active");
    info_card.classList.add("hidden");
    simulation_card.classList.remove("hidden");
});

const calculateMonthlyPayment = () => {
    const result =  (parseFloat(amountValue.innerText) * proportional_annual_rate / 12) / (1 - Math.pow(1 + proportional_annual_rate / 12, -parseFloat(monthsValue.innerText)));
    return result.toFixed(2);
}


