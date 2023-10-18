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

amountInput.addEventListener("input", (event) => {
    amountValue.innerText = event.target.value;
});

monthsInput.addEventListener("input", (event) => {
    monthsValue.innerText = event.target.value;
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
})

