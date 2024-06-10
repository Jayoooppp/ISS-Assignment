const container = document.querySelector(".container"),
    pwShowHide = document.querySelectorAll(".showHidePw"),
    pwFields = document.querySelectorAll(".password"),
    signUp = document.querySelector(".signup-link"),
    login = document.querySelector(".login-link");



//   js code to show/hide password and change icon
pwShowHide.forEach(eyeIcon => {
    eyeIcon.addEventListener("click", () => {
        pwFields.forEach(pwField => {
            if (pwField.type === "password") {
                pwField.type = "text";

                pwShowHide.forEach(icon => {
                    icon.classList.replace("uil-eye-slash", "uil-eye");
                })
            } else {
                pwField.type = "password";

                pwShowHide.forEach(icon => {
                    icon.classList.replace("uil-eye", "uil-eye-slash");
                })
            }
        })
    })
})

// js code to appear signup and login form
signUp.addEventListener("click", () => {
    container.classList.add("active");
});
login.addEventListener("click", () => {
    container.classList.remove("active");
});

const loginForm = document.querySelector('#loginForm')
const signupForm = document.querySelector('#signupForm')

// Login button event listener
loginForm.addEventListener('submit', (e) => {
    e.preventDefault();
    console.log("Login button clicked")
    if (validateInputs("login")) {
        // redirect to home.html 
        document.location.href = "home.html"
    }
})

// Signup button event listener
signupForm.addEventListener('submit', (e) => {
    e.preventDefault();
    console.log("Signup button clicked")
    if (validateInputs("signup")) {
        // redirect to home.html 
        document.location.href = "home.html"
    }
})

//  Function to validate the user inputs
const validateInputs = (formType = "login") => {
    if (formType === "login") {
        const email = document.querySelector('#email');
        const password = document.querySelector('#password');

        if (email.value.trim() === "" || password.value.trim() === "") {
            alert("Please fill in all fields")
            return false;
        } else {
            return true;
        }
    } else {
        const name = document.querySelector('#name');
        const email = document.querySelector('#s-email');
        const password = document.querySelector('#s-password');
        const cpassword = document.querySelector('#cpassword');
        if (name.value.trim() === "" || email.value.trim() === "" || password.value.trim() === "" || cpassword.value.trim() === "") {
            alert("Please fill in all fields");
            return false;
        } else if (password.value !== cpassword.value) {
            setError(password, "Passwords do not match");
            alert("Passwords do not match");
            return false;
        } else {
            return true;
        }
    }
}

