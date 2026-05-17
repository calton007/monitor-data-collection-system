document.addEventListener("DOMContentLoaded", function () {
  var buttons = document.querySelectorAll(".toggle-btn");
  for (var i = 0; i < buttons.length; i++) {
    buttons[i].addEventListener("click", function () {
      document.body.classList.toggle("left-side-collapsed");
    });
  }
});
