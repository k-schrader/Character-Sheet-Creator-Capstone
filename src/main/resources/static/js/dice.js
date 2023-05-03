var d20 = {
	sides: 20,
	roll: function() {
		var randomNumber = Math.floor(Math.random() * this.sides) + 1;
		return randomNumber;
	}
}
function printNumber(number) {
	var placeholder = document.getElementById('d20placeholder');
	placeholder.innerHTML = number;
}
var button = document.getElementById('d20');

button.onclick = function() {
	var result = d20.roll();
	printNumber(result);
};
var d12 = {
	sides: 12,
	roll: function() {
		var randomNumber = Math.floor(Math.random() * this.sides) + 1;
		return randomNumber;
	}
}
function printNumber(number) {
	var placeholder = document.getElementById('d12placeholder');
	placeholder.innerHTML = number;
}
var button = document.getElementById('d12');

button.onclick = function() {
	var result = d12.roll();
	printNumber(result);
};

var d10 = {
	sides: 10,
	roll: function() {
		var randomNumber = Math.floor(Math.random() * this.sides) + 1;
		return randomNumber;
	}
}
function printNumber(number) {
	var placeholder = document.getElementById('d10placeholder');
	placeholder.innerHTML = number;
}
var button = document.getElementById('d10');

button.onclick = function() {
	var result = d10.roll();
	printNumber(result);
};
var d8 = {
	sides: 8,
	roll: function() {
		var randomNumber = Math.floor(Math.random() * this.sides) + 1;
		return randomNumber;
	}
}
function printNumber(number) {
	var placeholder = document.getElementById('d8placeholder');
	placeholder.innerHTML = number;
}
var button = document.getElementById('d8');

button.onclick = function() {
	var result = d8.roll();
	printNumber(result);
};
var d6 = {
	sides: 6,
	roll: function() {
		var randomNumber = Math.floor(Math.random() * this.sides) + 1;
		return randomNumber;
	}
}
function printNumber(number) {
	var placeholder = document.getElementById('d6placeholder');
	placeholder.innerHTML = number;
}
var button = document.getElementById('d6');

button.onclick = function() {
	var result = d6.roll();
	printNumber(result);
};
var d4 = {
	sides: 4,
	roll: function() {
		var randomNumber = Math.floor(Math.random() * this.sides) + 1;
		return randomNumber;
	}
}
function printNumber(number) {
	var placeholder = document.getElementById('d4placeholder');
	placeholder.innerHTML = number;
}
var button = document.getElementById('d4');

button.onclick = function() {
	var result = d4.roll();
	printNumber(result);
};
var d100 = {
	sides: 100,
	roll: function() {
		var randomNumber = Math.floor(Math.random() * this.sides) + 1;
		return randomNumber;
	}
}
function printNumber(number) {
	var placeholder = document.getElementById('d100placeholder');
	placeholder.innerHTML = number;
}
var button = document.getElementById('d100');

button.onclick = function() {
	var result = d100.roll();
	printNumber(result);
};