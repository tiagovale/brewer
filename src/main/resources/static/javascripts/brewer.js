var Brewer = Brewer || {};

Brewer.MaskMoney = (function() {

	function MaskMoney() {
		this.decimal = $('.js-decimal');
		this.plain = $('.js-plain');

	}

	MaskMoney.prototype.enable = function() {
		this.decimal.maskMoney({
			decimal : ',',
			thousands : '.'
		});

		this.plain.maskMoney({
			precision : 0,
			thousands : '.'
		});

	}

	return MaskMoney;
}());

Brewer.MaskPhoneNumber = (function() {
	function MaskPhoneNumber() {
		this.inputPhoneNumber = $('.js-phone-number');
	}
	MaskPhoneNumber.prototype.enable = function() {
		var maskBehavior = function(val) {
			return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000'
					: '(00) 0000-00009';
		}, options = {
			onKeyPress : function(val, e, field, options) {
				field.mask(maskBehavior.apply({}, arguments), options);
			}
		};
		this.inputPhoneNumber.mask(maskBehavior, options);
	}
	return MaskPhoneNumber;
}());

Brewer.MaskCep = (function() {
	function MascaraCep() {
		this.inputCep = $('.js-cep');
	}
	MascaraCep.prototype.enable = function() {
		this.inputCep.mask('00.000-000');
	}

	return MascaraCep;
}())

$(function() {

	var maskMoney = new Brewer.MaskMoney();
	maskMoney.enable();

	var maskPhoneNumber = new Brewer.MaskPhoneNumber();
	maskPhoneNumber.enable();

	var maskCep = new Brewer.MaskCep();
	maskCep.enable();
});