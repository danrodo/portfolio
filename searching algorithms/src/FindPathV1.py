"""
Python script that reads in a graph with specified starting and goal states.

The objective is to design search algorithms that find a path from the start
to gaol state. Algorithms include:

Author: [YOUR NAME GOES HERE]

(1) Depth-first search
(2) Breadth-first search
(3) uniform cost search
(4) A* search

Usage:

    python FindPath [ maze ] [ astar | ucs | bfs | dfs ]
"""

import sys
import heapq

'''
A class representing a search problem
'''

class SearchProblem:

    def __init__(self):
        self.startState = None
        self.goalState = None
        self.numberOfRows = 0
        self.numberOfColumns = 0
        self.mazeAsDictionary = { }
    
    '''
    Reads in the maze and returns a dictionary that maps
    the maze as a dictionary.
    '''

    def initializeMaze(self, fileName):
        
        self.fileName = fileName
        
        with open(fileName) as maze:
            row = 0
            for line in maze:
                for col in range(0,len(line)-1):
                    # set up the dictionary
                    self.mazeAsDictionary[(row,col)] = line[col]
            
                    # determine the start and goal states
                    if line[col] == 'S':
                        self.startState = (row,col)
                    if line[col] == 'G':
                        self.goalState = (row,col)
        
                row += 1

        # set the number of rows and columns in the maze
        self.numberOfRows = row - 1
        self.numberOfColumns = col

        return self.mazeAsDictionary


    '''
    returns a list of successors we can reach
    from the current state
    '''
    def getSuccessors(self):
        
        mazeWithSuccessors = { }

        for (currentRow, currentCol) in self.mazeAsDictionary.keys():
            # where can we go?
    
            successors = []
            nextState = ()
 

            # check NORTH
            if currentRow > 0:
                rowAbove = currentRow - 1
     
                if self.mazeAsDictionary[(rowAbove,currentCol)] != '%':
                    direction = 'NORTH'
                    nextState = (rowAbove,currentCol)

                    cost = getCost(rowAbove, currentCol)
        
                    successors.append( (cost, nextState, direction) )
                    
            # check EAST
            if currentCol < self.numberOfColumns:
                columnToTheRight = currentCol + 1
    
                if self.mazeAsDictionary[(currentRow, columnToTheRight)] != '%':
                    direction = 'EAST'
                    nextState = (currentRow, columnToTheRight)
                    
                    cost = getCost(currentRow, columnToTheRight)

                    successors.append( (cost, nextState, direction) )
 
            # check SOUTH
            if currentRow < self.numberOfRows:
                rowBelow = currentRow + 1
                
                if self.mazeAsDictionary[(rowBelow,currentCol)] != '%':
                    direction = 'SOUTH'
                    nextState = (rowBelow,currentCol)

                    cost = getCost(rowBelow, currentCol)

                    successors.append( (cost, nextState, direction) )

            # check WEST
            if currentCol > 0:
                columnToTheLeft = currentCol - 1
        
                if self.mazeAsDictionary[(currentRow, columnToTheLeft)] != '%':
                    direction =  'WEST'
                    nextState = (currentRow, columnToTheLeft)

                    cost = getCost(currentRow, columnToTheLeft)

                    successors.append( (cost, nextState, direction) )
                    
           
                    

            '''
            we only need to populate if there are successors 
            from (currentRow,currentState)
            '''
            if successors:
                mazeWithSuccessors[(currentRow, currentCol)] = successors

        return mazeWithSuccessors

    '''
    Returns the start state
    '''
    def getStartState(self):
        return self.startState

    '''
    Returns the goal state
    '''
    def getGoalState(self):
        return self.goalState

    """
    UGLY ..... but it works.
    
    This function is passed a list of states and outputs
    the path taken from the starting state to goal state

    states is a list containing (row,column) tuples
    """
    def reportGraph(self, states):
        if states == None:
            return

        rows = [ ]
        
        with open(self.fileName) as maze:
            for line in maze:
                row = []
                for c in line[:-1]:
                    row.append(c)
                rows.append(row)
    
        # highlight each state that is along the path
        for (row,col) in states:
            rows[row][col] = '.'

        # ensure start and goal states are identified
        (startRow, startColumn) = self.startState
        rows[startRow][startColumn] = 'S'
        (goalRow, goalColumn) = self.goalState
        rows[goalRow][goalColumn] = 'G'

        # output the maze with the path
        for row in rows:
            print "".join(row)

"""
This represents a node in the search tree
"""
class Node:
    """
    pathCost    - the cost of reaching this node from the starting node
    state       - the state (row,col)
    direction   - the direction we came from
    parent      - the parent of this node
    """
    def __init__(self, pathCost, state, direction = None, parent = None):
        self.state = state
        self.direction = direction
        self.parent = parent
        
        if parent:
            self.pathCost = parent.pathCost + pathCost
        else:
            self.pathCost = pathCost


'''
determine the cost of reaching this (row,col) state
'''
def getCost(row,col):
    '''
    Very simple stepwise cost
    '''

    cost = 1

    return cost

"""
the heuristic for a-star search algorithm.
   
(point1, point2) are tuples of type (row,col)
 
this can be any admisssable heuristic such
as the Manhattan distance between the pair of points
"""
def heuristic(point1, point2):
    # use the following Manhattan heuristic for a-star and uniform cost
    distance = abs(point1[0] - point2[0]) + abs(point1[1] - point2[1])
    
    return distance

'''
A-Star search algorithm.
'''
def astar(problem, maze):
    '''
    Astar creates the frontier based on a tuple of the path cost of the current node
    plus the heuristic of that node, combined with the node itself. It then pops the 
    item with the lowest value associated with the node.
    '''
    print 'A*'
    '''
    initializes the maze, and gets a maze with all successors
    to be utilized later on
    '''
    problem.initializeMaze(maze)
    mazeWithSuccessors = problem.getSuccessors()
    'Gets Starting node'
    node = Node(0, problem.getStartState())
    frontier = []
    'Pushes first node onto the heapq, which behaves like a priority queue'
    heapq.heappush(frontier, (heuristic(node.state, problem.getGoalState()), node))
    'initialize the explored set and the states list to empty'
    explored = set()
    states = []
    
    'while there are nodes still in the frontier'
    while frontier:
        'pops the node with the lowest currentDistanse from the frontier'
        (currentDistance, currentNode) = heapq.heappop(frontier)
        'if the node popped has the same state as the goal, construct the path back to the top'
        if currentNode.state == problem.getGoalState():
            f = currentNode
            cost = 0
            '''
            while the current node has a parent, append that state to the
            states list, then set that current node to its parent, this
            will continue until the current node is back at the starting
            nodes position
            '''
            while f.parent:
                states.append(f.state)
                f = f.parent
                cost += 1
            'Its now finished, and thus breaks out of the main while loop'    
            break
        'If we have not visited the current node'
        if currentNode.state not in explored:
            'add it to the set of explored nodes'
            explored.add(currentNode.state)
            'then access its successors'
            successors = mazeWithSuccessors[currentNode.state]
            'this for loop repopulates the frontier with the current nodes successors'
            for s in successors:
                successorNode = Node(s[0], s[1], s[2], currentNode)
                heapq.heappush(frontier, ((currentNode.pathCost + (heuristic(s[1], problem.getGoalState()))), successorNode))
    print 'cost: ', cost
    return states

'''
uniform cost search
'''
def ucs(problem, maze):
    '''
    Uniform Cost is different from ASTAR because it only uses the heuristic
    of the current node to populate the tupled frontier, it then uses the 
    heuristic to pop out of the heapq by a lowest value priority.
    '''
    print 'UCS'
    '''
    initializes the maze, and gets a maze with all successors
    to be utilized later on
    '''
    problem.initializeMaze(maze)
    mazeWithSuccessors = problem.getSuccessors()
    'Gets Starting node'
    node = Node(0, problem.getStartState())
    frontier = []
    'Pushes first node onto the heapq, which behaves like a priority queue'
    heapq.heappush(frontier, (heuristic(node.state, problem.getGoalState()), node))
    'initialize the explored set and the states list to empty'
    explored = set()
    states = []
    
    'while there are nodes still in the frontier'
    while frontier:
        'pops the node with the lowest currentDistanse from the frontier'
        (currentDistance, currentNode) = heapq.heappop(frontier)
        'if the node popped has the same state as the goal, construct the path back to the top'
        if currentNode.state == problem.getGoalState():
            f = currentNode
            cost = 0
            '''
            while the current node has a parent, append that state to the
            states list, then set that current node to its parent, this
            will continue until the current node is back at the starting
            nodes position
            '''
            while f.parent:
                states.append(f.state)
                f = f.parent
                cost += 1
            'Its now finished, and thus breaks out of the main while loop'    
            break
        'If we have not visited the current node'
        if currentNode.state not in explored:
            'add it to the set of explored nodes'
            explored.add(currentNode.state)
            'then access its successors'
            successors = mazeWithSuccessors[currentNode.state]
            'this for loop repopulates the frontier with the current nodes successors'
            for s in successors:
                successorNode = Node(s[0], s[1], s[2], currentNode)
                heapq.heappush(frontier, (heuristic(s[1], problem.getGoalState()), successorNode))
    print 'cost: ', cost
    return states

'''
bradth-first search
'''
def bfs(problem, maze):
    print 'BFS'
    '''
    Breadth first uses a queue to check objects on the fronier, that
    means that it is a FIFO algorithm. This means that the frontier will
    get quite large, but it will also generally find the optimal path 
    
    these first lines simply initilize the maze, and the maze with its
    successors
    ''' 
    problem.initializeMaze(maze)
    mazeWithSuccessors = problem.getSuccessors()
    'gets the starting node'
    node = Node(0, problem.getStartState())
    'sets the frontier and the set of explored nodes to empty'
    frontier = [node]
    explored = set()
    states = []
    
    '''
    as long as there are objects in the frontier 
    this code will run
    '''
    while frontier:
        currentNode = frontier.pop(0)
        'if the current node is the goal, re construct the path'
        if currentNode.state == problem.getGoalState():
            f = currentNode
            cost = 0
            'while the node has a parent, add it to the states path, then set it to its parent'
            while f.parent:
                states.append(f.state)
                f = f.parent
                cost += 1
            break
        'if the current node has not been explored'
        if currentNode.state not in explored:
            'add it to the explored set'
            explored.add(currentNode.state)
            'get that nodes successors'
            successors = mazeWithSuccessors[currentNode.state]
            'add them to the frontier'
            for s in successors:
                successorNode = Node(s[0], s[1], s[2], currentNode)
                frontier.append(successorNode)
    print 'cost: ', cost 
    return states

'''
depth-first search
'''
def dfs(problem, maze):
    '''
    Depth first is nearly identical to breadth first, but it uses a stack
    instead of a queue making it a FILO algorithm. 
    '''
    print 'DFS'
   
    problem.initializeMaze(maze)
    mazeWithSuccessors = problem.getSuccessors()
    node = Node(0, problem.getStartState())
    frontier = [node]
    explored = set()
    states = []
    
    '''
    as long as there are objects in the frontier 
    this code will run
    '''
    while frontier:
        currentNode = frontier.pop()
        'if the current node is the goal, re construct the path'
        if currentNode.state == problem.getGoalState():
            f = currentNode
            cost = 0
            'while the node has a parent, add it to the states path, then set it to its parent'
            while f.parent:
                states.append(f.state)
                f = f.parent   
                cost += 1 
            break
        'if the current node has not been explored'    
        if currentNode.state not in explored:
            'add it to the explored set'
            explored.add(currentNode.state)
            'get that nodes successors'
            successors = mazeWithSuccessors[currentNode.state]
            'add them to the frontier'
            for s in successors:
                successorNode = Node(s[0], s[1], s[2], currentNode)
                frontier.append(successorNode)
    print 'cost: ', cost
    return states

'''
Invokes the appropriate search algorithm.
'''
def searchStrategy(problem, maze, algorithm):
    if algorithm == 'astar':
        return astar(problem, maze)
    elif algorithm == 'ucs':
        return ucs(problem, maze)
    elif algorithm == 'bfs':
        return bfs(problem, maze)
    elif algorithm == 'dfs':
        return dfs(problem, maze)
    else:
        return 'Error: Unimplemented Algorithm'

def main():
   
    problem = SearchProblem()

    maze = sys.argv[1]    
    algorithm = sys.argv[2]
   
    problem.reportGraph( searchStrategy(problem, maze, algorithm) )


if __name__ == "__main__":
    
    # some preliminary error checking
    
    if len(sys.argv) != 3:
        print 'Usage: python FindPath.py [maze] [dfs | bfs | astar | ucs]'
    elif sys.argv[2] == 'bfs' or sys.argv[2] == 'dfs' or sys.argv[2] == 'ucs' or sys.argv[2] == 'astar': 
        main()
    else:
        print 'Invalid algorihm: Must be [dfs | bfs | ucs | astar'
