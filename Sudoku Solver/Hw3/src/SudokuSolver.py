"""
Python script that reads in a Sudoku puzzle.

Author: Daniel Rodosky

Usage:

    python SudokuSolver [ puzzle ] 
"""

import sys
import copy
from collections import defaultdict

'''
A class representing a Sudoku puzzle solver
'''

class SudokuSolver:

    def __init__(self):
        # set up the puzzle as a dictionary
        self.puzzle = { }

        # the size of the puzzle
        self.size = 0

    '''
    Read in the puzzle and set it up as a list of lists.
    '''

    def initializePuzzle(self, fileName):
    
        rowNumber = 0
            
        with open(fileName) as puzzle_file:
            for row in puzzle_file:
                columnNumber = 0
                for v in row.split():
                    self.puzzle[(rowNumber,columnNumber)] = v
                    columnNumber += 1
                rowNumber += 1

        self.size = rowNumber

    def outputPuzzle(self):
        for rowNumber in range(self.size):
            for columnNumber in range(self.size):
                print '(', rowNumber, ',', columnNumber, ')', self.puzzle[(rowNumber,columnNumber)]
            print '\n'
    '''
    createRegions() walks through all values in the board
    and assigns them to one of the 9 regions, then it checks
    if the two node passed to it are in the same region.
    If they are it returns false, otherwise it returns
    true and passes this constraint
    ''' 
    def createRegions(self, x, y, x1, y1):
        region1 = [(0, 0), (0, 1), (0, 2), (1, 0), (1, 1), (1, 2), (2, 0), (2, 1), (2, 2)]
        region2 = [(0, 3), (0, 4), (0, 5), (1, 3), (1, 4), (1, 5), (2, 3), (2, 4), (2, 5)]
        region3 = [(0, 6), (0, 7), (0, 8), (1, 6), (1, 7), (1, 8), (2, 6), (2, 7), (2, 8)]
        region4 = [(3, 0), (3, 1), (3, 2), (4, 0), (4, 1), (4, 2), (5, 0), (5, 1), (5, 2)]
        region5 = [(3, 3), (3, 4), (3, 5), (4, 3), (4, 4), (4, 5), (5, 3), (5, 4), (5, 5)]
        region6 = [(3, 6), (3, 7), (3, 8), (4, 6), (4, 7), (4, 8), (5, 6), (5, 7), (5, 8)]
        region7 = [(6, 0), (6, 1), (6, 2), (7, 0), (7, 1), (7, 2), (8, 0), (8, 1), (8, 2)]
        region8 = [(6, 3), (6, 4), (6, 5), (7, 3), (7, 4), (7, 5), (8, 3), (8, 4), (8, 5)]
        region9 = [(6, 6), (6, 7), (6, 8), (7, 6), (7, 7), (7, 8), (8, 6), (8, 7), (8, 8)]
        '''
        for x2 in range(self.size):
            for y2 in range(self.size):
                if x2 <= 2 and y2 <= 2:
                    region1.append((x2, y2))
                elif x2 > 2 and x2 <= 5 and y2 <= 2:
                    region2.append((x2, y2))
                elif x2 > 5 and x2 <= 8 and y2 <= 2:
                    region3.append((x2, y2))
                elif x2 <= 2 and y2 > 2 and y2 <= 5:
                    region4.append((x2, y2))
                elif x2 > 2 and x2 <= 5 and y2 > 2 and y2 <= 5:
                    region5.append((x2, y2))
                elif x2 > 5 and x2 <= 8 and y2 > 2 and y2 <= 5:
                    region6.append((x2, y2))
                elif x2 <= 2 and y2 > 5 and y2 <= 8:
                    region7.append((x2, y2))
                elif x2 > 2 and x2 <= 5 and y2 > 5 and y2 <= 8:
                    region8.append((x2, y2))
                elif x2 > 5 and x2 <= 8 and y2 > 5 and y2 <= 8:
                    region9.append((x2, y2))
        '''
        
        if (x, y) in region1 and (x1, y1) in region1:
            return False
        elif (x, y) in region2 and (x1, y1) in region2:
            return False
        elif (x, y) in region3 and (x1, y1) in region3:
            return False
        elif (x, y) in region4 and (x1, y1) in region4:
            return False
        elif (x, y) in region5 and (x1, y1) in region5:
            return False
        elif (x, y) in region6 and (x1, y1) in region6:
            return False
        elif (x, y) in region7 and (x1, y1) in region7:
            return False
        elif (x, y) in region8 and (x1, y1) in region8:
            return False
        elif (x, y) in region9 and (x1, y1) in region9:
            return False
        else:
            return True
       
    '''
    check each row to make sure the assigned value isnt already
    present
    '''   
    def checkRow(self, x, y):
        for x1 in range(self.size):
            if x != x1:
                if self.puzzle[(x, y)] == self.puzzle[(x1, y)]:
                    return False
        return True
    '''
    check each column to make sure the assigned value isnt already
    present
    '''
    def checkCol(self, x, y):
        for y1 in range(self.size):
            if y != y1:
                if self.puzzle[(x, y)] == self.puzzle[(x, y1)]:
                    return False
        return True
                
    '''
    constraints() walks through the board and checks each
    point to see if it conflicts with one of the three
    constraints of the game
    '''           
    def constraints(self, x, y):
        if not self.checkCol(x, y) or not self.checkRow(x, y):
            return False
        for x1 in range(self.size):
            for y1 in range(self.size):
                if self.puzzle[(x, y)] == self.puzzle[(x1, y1)] and x != x1 and y != y1:
                    if not self.createRegions(x, y, x1, y1):
                        return False
        return True
    '''
    Checks to see if the board is complete by making sure there
    are no '*' left on the board, and that no point conflicts with 
    the constraints
    '''
    def checkBoard(self):  
        for x in range(self.size):
            for y in range(self.size):
                if self.puzzle[(x, y)] == '*':
                    return False
                if not self.constraints(x, y):
                    return False
        return True
    '''
    finds all unassigned positions, and assigns them a domain
    of 1-9
    '''
    def setDomains(self):
        domains = defaultdict(list)
        for x in range(self.size):
            for y in range(self.size):
                if self.puzzle[(x, y)] == '*':
                    domains[(x, y)] = [1, 2, 3, 4, 5, 6, 7, 8 , 9]
        return domains
    '''
    checks to see if the value assigned is in the domain
    of any unassigned value in the same row, col or region then
    removes that values from unassigned positions domains
    '''              
    def forwardCheck(self, x, y, domains):
        
        for x1 in range(self.size):
            if self.puzzle[(x, y)] in domains[(x1, y)]:
                domains[(x1, y)].remove(self.puzzle[(x, y)])
                
        for y1 in range(self.size):
            if self.puzzle[(x, y)] in domains[(x, y1)]:
                domains[(x, y1)].remove(self.puzzle[(x, y)])

        for x1 in range(self.size):
            for y1 in range(self.size):
                if not self.createRegions(x, y, x1, y1):
                    if self.puzzle[(x, y)] in domains[(x1, y1)]:
                        domains[(x1, y1)].remove(self.puzzle[(x, y)])
        return True
    '''
    locates the first unassigned position in the board
    '''
    def finUnassignedPoint(self):
        rv = None  
        for x in range(self.size):
            for y in range(self.size):
                if self.puzzle[(x, y)] == '*':
                    return (x, y)
        return rv
                      
    '''
    backtracking algorithm, base case is if the board is 
    complete and doesn't violate the constraints
    '''      
    def CspBacktracking(self, board, domains):
        board = self.puzzle
        if self.checkBoard():
            return True
        
        else:
            success = False
            
            (x, y) = self.finUnassignedPoint()
            '''
            while the unnasigned position still has values in its domain,
            pop the next value off of the domain, call forwardCheck to restrain
            further domains, then check the constraints. if it works, recursivly
            check the next point untill the board is colplete of backtracking
            is triggered.
            '''
            while domains[(x, y)]:
                self.puzzle[(x, y)] = str(domains[(x, y)].pop(0))
                self.forwardCheck(x, y, domains)
                if self.constraints(x, y):  
                    result = self.CspBacktracking(board, copy.deepcopy(domains))         
                    if result == True:
                        return result
                    
            '''
            if it goes through a positions entire domain and no
            value satisfies the constraints, it backtracks. Restoring
            it to an * and restoring the positions domain to 
            1-9
            '''        
            success =  False        
            self.puzzle[(x, y)] = '*'
            domains[(x, y)] = [1, 2, 3, 4, 5, 6, 7, 8, 9]
                        
        return success 
                    

def main():
   
    solver = SudokuSolver()

    puzzle = sys.argv[1]    
  
    solver.initializePuzzle(puzzle)
    domains = solver.setDomains()
    solver.CspBacktracking(puzzle, domains)
    
    solver.outputPuzzle() 
    

if __name__ == "__main__":
    
    # some preliminary error checking
    
    if len(sys.argv) != 2:
        print 'Usage: python SudokuSolver.py [ puzzle ]'
    else:
        main()