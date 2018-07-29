// Initialize Firebase
var config = {
  apiKey: "AIzaSyDBWAEfwIN7XM55l6zH4t8iDyMsbxKkKk0",
    authDomain: "doctor-anywhere-b81ee.firebaseapp.com",
    databaseURL: "https://doctor-anywhere-b81ee.firebaseio.com",
    projectId: "doctor-anywhere-b81ee",
    storageBucket: "doctor-anywhere-b81ee.appspot.com",
    messagingSenderId: "777501267038"
};
firebase.initializeApp(config);

// Firebase Variables
var auth = firebase.auth();

// on state changed
auth.onAuthStateChanged(firebaseUser => {
  // check email
  if(firebaseUser){

    currentEmail.innerHTML = auth.currentUser.email
    currentEmail.style.display = 'block';
    singoutButton.style.display = 'block';
    singinForm.style.display = 'none';
    patinetView.style.display='block';
  } else{
    singoutButton.style.display = 'none';
    singinForm.style.display = 'block';
    currentEmail.style.display = 'none';
    patinetView.style.display='none';
  }

});


var singoutButton = document.querySelector("#signout");
var currentEmail = document.querySelector("#current-email");

var singinForm = document.querySelector("#signin");
var patinetView = document.querySelector("#patinetView");

patinetView
var userName = document.querySelector("#username");
var email = document.querySelector("#email");
var password = document.querySelector("#password");
singoutButton.addEventListener("click", clickSignoutButton);

function clickSignoutButton(){
  auth.signOut()
}

// •••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••
// singin form
// •••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••
var signinEmail = document.querySelector("#signinEmail");
var signinPassword = document.querySelector("#signinPassword");
var singinButton = document.querySelector("#signin");

singinButton.addEventListener("click", clickSigninButton);


function clickSigninButton() {

  auth.signInWithEmailAndPassword(signinEmail.value, signinPassword.value).
  then(function(user){
    console.log(user)
  }, function(error) {
    console.log(error.message);
    // error message show that you need to enable that authentication in firebase
  });

}
