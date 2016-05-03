package br.com.treinamento.dojo.model.creditCard.amex;

import br.com.treinamento.dojo.model.creditCard.CardType;
import br.com.treinamento.dojo.model.creditCard.CreditCard;
import br.com.treinamento.dojo.model.creditCard.CreditCardFactory;

public class AmexFactory extends CreditCardFactory {

	@Override
	public CreditCard getCreditCard(CardType cardType) {

		switch (cardType) {
		case GOLD:
			return new AmexGoldCreditCard();

		case PLATINUM:
			return new AmexPlatinumCreditCard();

		default:
			break;
		}

		return null;
	}
}
