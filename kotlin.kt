Here is a short implementation of Monte Carlo Tree Search in Kotlin:

import java.util.Random

class MonteCarloTreeSearch {
    fun run(state: State): Action {
        val root = Node(state)
        val rand = Random()

        for (i in 1..MAX_ITERATIONS) {
            var node = root
            var tempState = state

            while (!tempState.isTerminal() && node.hasUntriedActions()) {
                val action = node.getUntriedAction()
                tempState = tempState.takeAction(action)
                node = node.addChild(tempState, action)
            }

            while (!tempState.isTerminal()) {
                tempState = tempState.takeRandomAction()
            }

            node.backpropagate(tempState.getResult())
        }

        return root.getBestChild().action
    }
}

interface State {
    fun isTerminal(): Boolean
    fun getResult(): Int
    fun takeAction(action: Action): State
    fun takeRandomAction(): State
}

class Node(val state: State) {
    private val children = mutableListOf<Node>()
    private val untriedActions = state.getActions().toMutableList()
    private var wins = 0
    private var visits = 0
    var action: Action? = null

    fun addChild(state: State, action: Action): Node {
        val child = Node(state)
        child.action = action
        children.add(child)
        untriedActions.remove(action)
        return child
    }

    fun backpropagate(result: Int) {
        visits++
        wins += result
    }

    fun hasUntriedActions(): Boolean = untriedActions.isNotEmpty()
    fun getUntriedAction(): Action = untriedActions[0]
    fun getBestChild(): Node {
        children.sortByDescending { it.wins / it.visits + Math.sqrt(2.0 * Math.log(visits) / it.visits) }
        return children[0]
    }
}

interface Action

const val MAX_ITERATIONS = 1000
