package br.com.treinamento.dojo.model.creditCard.visa;

import br.com.treinamento.dojo.model.creditCard.CardType;
import br.com.treinamento.dojo.model.creditCard.CreditCard;
import br.com.treinamento.dojo.model.creditCard.CreditCardFactory;

public class VisaFactory extends CreditCardFactory {

	@Override
	public CreditCard getCreditCard(CardType cardType) {
		switch (cardType) {
			case GOLD:
				
				return new VisaGoldCreditCard();
	
			case PLATINUM:
				
				return new VisaBlackCreditCard();	
			
		}
		
		return null;
	}

}
