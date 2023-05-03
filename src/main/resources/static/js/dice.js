var d20 = {
	sides: 20,
	roll: function() {
		var randomNumber = Math.floor(Math.random() * this.sides) + 1;
		return randomNumber;
	}
}
function printNumber20(number) {
	var placeholder = document.getElementById('d20placeholder');
	placeholder.innerHTML = number;
}
var button = document.getElementById('20');

button.onclick = function() {
	var result = d20.roll();
	printNumber20(result);
};
var d12 = {
	sides: 12,
	roll: function() {
		var randomNumber = Math.floor(Math.random() * this.sides) + 1;
		return randomNumber;
	}
}
function printNumber12(number) {
	var placeholder = document.getElementById('d12placeholder');
	placeholder.innerHTML = number;
}
var button = document.getElementById('12');

button.onclick = function() {
	var result = d12.roll();
	printNumber12(result);
};

var d10 = {
	sides: 10,
	roll: function() {
		var randomNumber = Math.floor(Math.random() * this.sides) + 1;
		return randomNumber;
	}
}
function printNumber10(number) {
	var placeholder = document.getElementById('d10placeholder');
	placeholder.innerHTML = number;
}
var button = document.getElementById('10');

button.onclick = function() {
	var result = d10.roll();
	printNumber10(result);
};
var d8 = {
	sides: 8,
	roll: function() {
		var randomNumber = Math.floor(Math.random() * this.sides) + 1;
		return randomNumber;
	}
}
function printNumber8(number) {
	var placeholder = document.getElementById('d8placeholder');
	placeholder.innerHTML = number;
}
var button = document.getElementById('8');

button.onclick = function() {
	var result = d8.roll();
	printNumber8(result);
};
var d6 = {
	sides: 6,
	roll: function() {
		var randomNumber = Math.floor(Math.random() * this.sides) + 1;
		return randomNumber;
	}
}
function printNumber6(number) {
	var placeholder = document.getElementById('d6placeholder');
	placeholder.innerHTML = number;
}
var button = document.getElementById('6');

button.onclick = function() {
	var result = d6.roll();
	printNumber6(result);
};
var d4 = {
	sides: 4,
	roll: function() {
		var randomNumber = Math.floor(Math.random() * this.sides) + 1;
		return randomNumber;
	}
}
function printNumber4(number) {
	var placeholder = document.getElementById('d4placeholder');
	placeholder.innerHTML = number;
}
var button = document.getElementById('4');

button.onclick = function() {
	var result = d4.roll();
	printNumber4(result);
};
