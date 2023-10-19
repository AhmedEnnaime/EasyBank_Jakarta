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

const credit_details = document.querySelector('.credit-details');
const amount_recap = document.getElementById("amount-recap");
const duration = document.getElementById("duration");
const monthly_payment_recap = document.getElementById("monthly_payment_recap");
const client_job = document.getElementById("client_job");
const job = document.getElementById("job");

const client_details = document.querySelector('.client-details');
const client_firstName = document.getElementById("client-firstName");
const client_lastName = document.getElementById("client-lastName");
const client_birthDate = document.getElementById("client-birthDate");
const client_address = document.getElementById("client-address");
const client = document.getElementById("client");


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
    fillCreditDetails();
});

back_btn.addEventListener("click", () => {
    simulation_top_card.classList.add("active");
    info_top_card.classList.remove("active");
    info_card.classList.add("hidden");
    simulation_card.classList.remove("hidden");
    credit_details.classList.add("hidden");
});

client.addEventListener("change", () => {
    fillClientDetails();
})
const calculateMonthlyPayment = () => {
    const result =  (parseFloat(amountValue.innerText) * proportional_annual_rate / 12) / (1 - Math.pow(1 + proportional_annual_rate / 12, -parseFloat(monthsValue.innerText)));
    return result.toFixed(2);
}

const fillCreditDetails = () => {
    credit_details.classList.remove("hidden");
    amount_recap.innerText = amountValue.innerText + " DH";
    duration.innerText = monthsValue.innerText + " months";
    monthly_payment_recap.innerText = calculateMonthlyPayment() + " DH";
    client_job.innerText = job.value;
}

const fillClientDetails = () => {
    const selectedText = client.options[client.selectedIndex];
    client_details.classList.remove("hidden");
    client_firstName.innerText = selectedText.innerText.split(" ")[0];
    client_lastName.innerText = selectedText.innerText.split(" ")[2];
    client_birthDate.innerText = selectedText.getAttribute('data-birthDate');
    client_address.innerText = selectedText.getAttribute('data-address');
}

