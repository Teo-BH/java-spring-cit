package br.com.treinamento.dojo.model.creditCard;

//AbstractFactory
public abstract class CreditCardFactory {

	//public static CreditCardFactory getCreditCardFactory(int creditScore);
	
	public abstract CreditCard getCreditCard(CardType cardType);	
}
