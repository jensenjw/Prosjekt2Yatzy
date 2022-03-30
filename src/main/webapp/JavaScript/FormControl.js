/**
 * 
 */

class formcontroller {
	constructor(rootNavn = null) {
		this.run = this.run.bind(this);
		this.root = rootNavn;
	}

	run() {
		const rootEl = document.getElementById(this.root);
		rootEl.querySelector("div[data-info='password']").classList.add("formcontroller_hidden");
		rootEl.querySelector("div[data-info='submit']").classList.add("formcontroller_hidden");

		/* sjekke fornavn*/
		const fornavn = rootEl.querySelector("input[name='firstname']");
		fornavn.addEventListener("input", function() {
			if (this.value.length >= 2 && this.value.length <= 20) {
				this.classList.add('formcontroller_validInput');
				this.classList.remove('formcontroller_invalidInput');
			} else {
				this.classList.add('formcontroller_invalidInput');
				this.classList.remove('formcontroller_validInput');
			}
		});

		/*sjekke etternavn*/
		const etternavn = rootEl.querySelector("input[name='lastname']");
		etternavn.addEventListener("input", function() {
			if (this.value.length >= 2 && this.value.length <= 20) {
				this.classList.add('formcontroller_validInput');
				this.classList.remove('formcontroller_invalidInput');
			} else {
				this.classList.add('formcontroller_invalidInput');
				this.classList.remove('formcontroller_validInput');
			}
		});

		/*sjekke mobil*/
		const mobil = rootEl.querySelector("input[name='mobile']");
		mobil.addEventListener("input", function() {
			if (this.value.length == 8 && !isNaN(this.value)) {
				this.classList.add('formcontroller_validInput');
				this.classList.remove('formcontroller_invalidInput');
			} else {
				this.classList.add('formcontroller_invalidInput');
				this.classList.remove('formcontroller_validInput');
			}
		});




		/*skjekke passord styrke*/
		const passord = rootEl.querySelector("input[name='password']");
		const passord2 = rootEl.querySelector("input[name='passord2']");
		passord.addEventListener('input', function() {
			if (this.value.length < 3) {
				this.classList.add('formcontroller_invalidInput');
				this.classList.remove('formcontroller_mediumPassword');
				this.classList.remove('formcontroller_validInput');
			} else if (this.value.length < 16) {
				this.classList.remove('formcontroller_invalidInput');
				this.classList.add('formcontroller_mediumPassword');
				this.classList.remove('formcontroller_validInput');
			} else {
				this.classList.remove('formcontroller_invalidInput');
				this.classList.remove('formcontroller_mediumPassword');
				this.classList.add('formcontroller_validInput');
			}
		});


		//vise passord info og ta vekk
		const pass = rootEl.querySelector("input[name='password']");
		pass.addEventListener("mouseover", function() {
			rootEl.querySelector("div[data-info='password']").classList.remove("formcontroller_hidden");
		});
		pass.addEventListener("mouseout", function() {
			rootEl.querySelector("div[data-info='password']").classList.add("formcontroller_hidden");
		})


		/*sjekke passord matcher*/
		passord2.addEventListener('input', function() {
			if (this.value == passord.value) {
				this.classList.add('formcontroller_validInput');
				this.classList.remove('formcontroller_invalidInput');
			} else {
				this.classList.add('formcontroller_invalidInput');
				this.classList.remove('formcontroller_validInput');
			}
		});

		let gyldig = true;
		let subBtn = rootEl.querySelector("button");
		let submitBox = rootEl.querySelector("div[data-info='submit']");
		subBtn.addEventListener('click', function(evt) {
			let counter = 0;
			let inputs = ["firstname", "lastname", "mobile", "password", "passord2"];
			inputs.forEach(function(x) {
				if (!rootEl.querySelector("input[name=" + x + "]")
						.classList.contains("formcontroller_invalidInput")
					&& (rootEl.querySelector("input[name=" + x + "]")
						.classList.contains("formcontroller_validInput")
					|| rootEl.querySelector("input[name=" + x + "]")
						.classList.contains("formcontroller_mediumPassword"))) {
					counter++;
				}
			});

			gyldig = (counter == inputs.length); // true = sender videre
			if (gyldig) {
				if (!confirm("Send info til tjener")) {
					evt.preventDefault();
				}
			} else {
				submitBox.classList.remove("formcontroller_hidden");
				evt.preventDefault();
			}
		});

	}
}

const val = new formcontroller("root");
document.addEventListener("DOMContentLoaded", val.run, true);/**
 * 
 */