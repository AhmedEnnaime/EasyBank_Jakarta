document.addEventListener("DOMContentLoaded", function() {
    const deleteButtons = document.querySelectorAll(".delete-button");
    const cancelButton = document.querySelector(".cancel-button");
    const deleteEmployeeModal = document.getElementById("deleteEmployeeModal");

    deleteButtons.forEach(function(button) {
        button.addEventListener("click", function() {
            const row = button.closest("tr");
            const employeeId = row.querySelector("td:first-child").textContent;
            console.log(employeeId);

            const deleteEmployeeIdInput = document.getElementById("deleteEmployeeId");
            deleteEmployeeIdInput.value = employeeId;

            deleteEmployeeModal.style.display = "block";
        });
    });

    cancelButton.addEventListener("click", function() {
        deleteEmployeeModal.style.display = "none";
    });
});

document.addEventListener("DOMContentLoaded", function() {
    const addEmployeeButton = document.querySelector(".add-button");
    const closeButtons = document.querySelectorAll(".close, .modal");
    const modalContents = document.querySelectorAll(".modal-content");
    const updateButtons = document.querySelectorAll(".update-button");
    const closeUpdateButtons = document.querySelectorAll(".close-update, #updateEmployeeModal");

    const employeeModal = document.getElementById("employeeModal");
    const updateEmployeeModal = document.getElementById("updateEmployeeModal");

    addEmployeeButton.addEventListener("click", function() {
        employeeModal.style.display = "block";
    });

    closeButtons.forEach(function(button) {
        button.addEventListener("click", function() {
            employeeModal.style.display = "none";
        });
    });

    modalContents.forEach(function(content) {
        content.addEventListener("click", function(event) {
            event.stopPropagation();
        });
    });

    updateButtons.forEach(function(button) {
        button.addEventListener("click", function() {
            const row = button.closest("tr");
            const employeeId = row.querySelector("td:first-child").textContent;
            const firstName = row.querySelector("td:nth-child(2)").textContent;
            const lastName = row.querySelector("td:nth-child(3)").textContent;
            const birthdate = row.querySelector("td:nth-child(4)").textContent;
            const phone = row.querySelector("td:nth-child(5)").textContent;
            const address = row.querySelector("td:nth-child(6)").textContent;
            const email = row.querySelector("td:nth-child(7)").textContent;
            const recruitmentDate = row.querySelector("td:nth-child(8)").textContent;

            const updateEmployeeIdInput = document.getElementById("updateEmployeeId");
            const updateFirstNameInput = document.getElementById("updateFirstName");
            const updateLastNameInput = document.getElementById("updateLastName");
            const updateBirthdateInput = document.getElementById("updateBirthdate");
            const updatePhoneInput = document.getElementById("updatePhone");
            const updateAddressInput = document.getElementById("updateAddress");
            const updateEmailInput = document.getElementById("updateEmail");
            const updateRecruitmentDateInput = document.getElementById("updateRecruitmentDate");

            updateEmployeeIdInput.value = employeeId;
            updateFirstNameInput.value = firstName;
            updateLastNameInput.value = lastName;
            updateBirthdateInput.value = birthdate;
            updatePhoneInput.value = phone;
            updateAddressInput.value = address;
            updateEmailInput.value = email;
            updateRecruitmentDateInput.value = recruitmentDate;

            updateEmployeeModal.style.display = "block";
        });
    });

    closeUpdateButtons.forEach(function(button) {
        button.addEventListener("click", function() {
            updateEmployeeModal.style.display = "none";
        });
    });
});