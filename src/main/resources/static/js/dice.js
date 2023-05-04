//Custom Javascript for the dice roller page 
//function rollDie takes in a number of sides an a placeholder to put the number in the HTML
//The function then rolls a random number based on the number of sides and put the number in the placeholder 
function rollDie(sides, placeholderId) {
	var die = {
		sides: sides,
		roll: function() {
			var randomNumber = Math.floor(Math.random() * this.sides) + 1;
			return randomNumber;
		}
	}
	var result = die.roll();
	var placeholder = document.getElementById(placeholderId);
	placeholder.innerHTML = result;
}

var button20 = document.getElementById('20');
button20.onclick = function() {
	rollDie(20, 'd20placeholder');
};

var button12 = document.getElementById('12');
button12.onclick = function() {
	rollDie(12, 'd12placeholder');
};

var button10 = document.getElementById('10');
button10.onclick = function() {
	rollDie(10, 'd10placeholder');
};

var button8 = document.getElementById('8');
button8.onclick = function() {
	rollDie(8, 'd8placeholder');
};

var button6 = document.getElementById('6');
button6.onclick = function() {
	rollDie(6, 'd6placeholder');
};

var button4 = document.getElementById('4');
button4.onclick = function() {
	rollDie(4, 'd4placeholder');
};

