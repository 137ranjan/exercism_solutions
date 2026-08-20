package blackjack

// ParseCard returns the integer value of a card following blackjack ruleset.
func ParseCard(card string) int {
	var value int

	switch card {
	case "ace":
		value = 11
	case "two":
		value = 2
	case "three":
		value = 3
	case "four":
		value = 4
	case "five":
		value = 5
	case "six":
		value = 6
	case "seven":
		value = 7
	case "eight":
		value = 8
	case "nine":
		value = 9
	case "ten":
		value = 10
	case "jack":
		value = 10
	case "queen":
		value = 10
	case "king":
		value = 10
	default:
		value = 0
	}
	return value
}

// FirstTurn returns the decision for the first turn, given two cards of the
// player and one card of the dealer.
func FirstTurn(card1, card2, dealerCard string) string {
	var option string

	switch {
	case card1 == "ace" && card2 == "ace":
		option = "P"
	case (ParseCard(card1)+ParseCard(card2)) >= 21 && (dealerCard != "ace" && dealerCard != "jack" && dealerCard != "queen" && dealerCard != "king" && dealerCard != "ten"):
		option = "W"
	case (ParseCard(card1)+ParseCard(card2)) >= 21 && (dealerCard == "ace" || dealerCard == "jack" || dealerCard == "queen" || dealerCard == "king" || dealerCard == "ten"):
		option = "S"
	case (ParseCard(card1)+ParseCard(card2)) >= 17 && (ParseCard(card1)+ParseCard(card2) <= 20):
		option = "S"
	case (ParseCard(card1)+ParseCard(card2)) >= 12 && (ParseCard(card1)+ParseCard(card2) <= 16) && ParseCard(dealerCard) < 7:
		option = "S"
	case (ParseCard(card1)+ParseCard(card2)) >= 12 && (ParseCard(card1)+ParseCard(card2) <= 16) && ParseCard(dealerCard) >= 7:
		option = "H"
	case (ParseCard(card1) + ParseCard(card2)) <= 11:
		option = "H"
	}
	return option

}
