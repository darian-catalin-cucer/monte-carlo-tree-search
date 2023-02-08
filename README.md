# Monte Carlo Tree Search in Kotlin

This repository contains a short implementation of Monte Carlo Tree Search in Kotlin. Monte Carlo Tree Search is a probabilistic algorithm used in game AI to find the best move. The algorithm runs simulations starting from the current state and evaluates the result, updating the values of each node based on the simulations. The final move is then selected based on the results of the simulations.

This implementation uses a Node class to represent a state and its children, and a MonteCarloTreeSearch class to run the simulations and select the best move. The implementation uses a random number generator to simulate random moves, and the algorithm can be tuned by changing the MAX_ITERATIONS constant.

The implementation also uses an interface for the State and Action classes, allowing for easy integration with different game engines.

This implementation serves as a simple introduction to Monte Carlo Tree Search and can be used as a starting point for more complex applications.
