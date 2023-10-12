document.addEventListener("DOMContentLoaded", function() {
    const deleteButtons = document.querySelectorAll(".delete-button");
    const cancelButtons = document.querySelectorAll(".cancel-button");
    const addClientButton = document.querySelector(".add-button");
    const closeButtons = document.querySelectorAll(".close, .modal");
    const modalContents = document.querySelectorAll(".modal-content");
    const updateButtons = document.querySelectorAll(".update-button");
    const closeUpdateButtons = document.querySelectorAll(".close-update, #updateClientModal");

    const deleteClientModal = document.getElementById("deleteClientModal");
    const deleteClientIdInput = document.getElementById("deleteClientId");
    const clientModal = document.getElementById("clientModal");
    const updateClientModal = document.getElementById("updateClientModal");

    addClientButton.addEventListener("click", function() {
        console.log("Add Client button clicked");
        clientModal.style.display = "block";
    });

    closeButtons.forEach(function(button) {
        button.addEventListener("click", function() {
            clientModal.style.display = "none";
        });
    });

    modalContents.forEach(function(content) {
        content.addEventListener("click", function(event) {
            event.stopPropagation();
        });
    });

    updateButtons.forEach(function(button) {
        button.addEventListener("click", function() {
            console.log("update clicked");
            const row = button.closest("tr");
            const clientId = row.querySelector("td:first-child").textContent;
            const firstName = row.querySelector("td:nth-child(2)").textContent;
            const lastName = row.querySelector("td:nth-child(3)").textContent;
            const birthdate = row.querySelector("td:nth-child(4)").textContent;
            const phone = row.querySelector("td:nth-child(5)").textContent;
            const address = row.querySelector("td:nth-child(6)").textContent;

            const updateClientIdInput = document.getElementById("updateClientId");
            const updateFirstNameInput = document.getElementById("updateFirstName");
            const updateLastNameInput = document.getElementById("updateLastName");
            const updateBirthdateInput = document.getElementById("updateBirthdate");
            const updatePhoneInput = document.getElementById("updatePhone");
            const updateAddressInput = document.getElementById("updateAddress");

            updateClientIdInput.value = clientId;
            updateFirstNameInput.value = firstName;
            updateLastNameInput.value = lastName;
            updateBirthdateInput.value = birthdate;
            updatePhoneInput.value = phone;
            updateAddressInput.value = address;

            updateClientModal.style.display = "block";
        });
    });

    closeUpdateButtons.forEach(function(button) {
        button.addEventListener("click", function() {
            updateClientModal.style.display = "none";
        });
    });

    deleteButtons.forEach(function(button) {
        button.addEventListener("click", function() {
            const row = button.closest("tr");
            const clientId = row.querySelector("td:first-child").textContent;
            deleteClientIdInput.value = clientId;
            deleteClientModal.style.display = "block";
        });
    });

    cancelButtons.forEach(function(button) {
        button.addEventListener("click", function() {
            deleteClientModal.style.display = "none";
        });
    });
});