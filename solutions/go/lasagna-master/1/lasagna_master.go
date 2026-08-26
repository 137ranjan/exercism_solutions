package lasagnamaster

// TODO: define the 'PreparationTime()' function
func PreparationTime(layers []string, avgPrepTime int) int {
	if avgPrepTime == 0 {
		avgPrepTime = 2
	}
	return len(layers) * avgPrepTime
}

// TODO: define the 'Quantities()' function
func Quantities(layers []string) (int, float64) {
	noodleCount := 0
	sauceCount := 0.0
	for _, layer := range layers {
		switch layer {
		case "noodles":
			noodleCount++
		case "sauce":
			sauceCount++
		}
	}
	return noodleCount * 50, sauceCount * 0.2
}

// TODO: define the 'AddSecretIngredient()' function
func AddSecretIngredient(friendsList []string, myList []string) {
	secretIngredient := friendsList[len(friendsList)-1:]
	myList = append(myList[:len(myList)-1], secretIngredient[0])
}

// TODO: define the 'ScaleRecipe()' function
func ScaleRecipe(amounts []float64, numberOfPortions int) []float64 {
	var scaledAmounts []float64
	for _, amount := range amounts {
		scaledAmounts = append(scaledAmounts, float64(numberOfPortions)*(amount/2))
	}
	return scaledAmounts
}

// Your first steps could be to read through the tasks, and create
// these functions with their correct parameter lists and return types.
// The function body only needs to contain `panic("")`.
//
// This will make the tests compile, but they will fail.
// You can then implement the function logic one by one and see
// an increasing number of tests passing as you implement more
// functionality.
