package br.com.treinamento.dojo.service;

import br.com.treinamento.dojo.model.creditCard.CardType;
import br.com.treinamento.dojo.model.creditCard.CreditCard;

public interface CreditCardService {

	CreditCard create(int creditScore, CardType type);

}