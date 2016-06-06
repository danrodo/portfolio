'''
Created on Nov 17, 2014

@author: Daniel Rodosky
'''
import copy

class TicTacToe:
    '''
    Initializes the tic tac toe baord
    its a 3x3 board with all points 
    set to '_' initially
    '''
    def initializeBoard(self):
        board = {}
        size = 10
        for i in range(size):
            if i != 0:
                board[i] = '_'
        return board
    '''
    returns true if the entire board
    is populated with either 'X' or 'O'
    and neither played has won. or a draw
    '''
    def draw(self, board):
        count = 0
        for n in range(10):
            if n >= 1 and (board[n] == 'X' or board[n] == 'O'):
                count +=1
        if count == 9:
            return True
        else:
            return False
    '''
    Check every case where a player could win or draw
    and returns a -1 if the player wins, a 0 is its a draw
    and a 1 if the computer won
    '''
    def checkBoard(self, board):
        if board[1]  == 'X' and board[2] == 'X' and board[3] == 'X':
            return -1
        elif board[1]  == 'O' and board[2] == 'O' and board[3] == 'O':
            return 1
        elif board[4]  == 'X' and board[5] == 'X' and board[6] == 'X':
            return -1
        elif board[4]  == 'O' and board[5] == 'O' and board[6] == 'O':
            return 1
        elif board[7]  == 'X' and board[8] == 'X' and board[9] == 'X':
            return -1
        elif board[7]  == 'O' and board[8] == 'O' and board[9] == 'O':
            return 1
        elif board[1]  == 'X' and board[4] == 'X' and board[7] == 'X':
            return -1
        elif board[1]  == 'O' and board[4] == 'O' and board[7] == 'O':
            return 1
        elif board[2]  == 'X' and board[5] == 'X' and board[8] == 'X':
            return -1
        elif board[2]  == 'O' and board[5] == 'O' and board[8] == 'O':
            return 1
        elif board[3]  == 'X' and board[6] == 'X' and board[9] == 'X':
            return -1
        elif board[3]  == 'O' and board[6] == 'O' and board[9] == 'O':
            return 1
        elif board[1]  == 'X' and board[5] == 'X' and board[9] == 'X':
            return -1
        elif board[1]  == 'O' and board[5] == 'O' and board[9] == 'O':
            return 1
        elif board[3]  == 'X' and board[5] == 'X' and board[7] == 'X':
            return -1
        elif board[3]  == 'O' and board[5] == 'O' and board[7] == 'O':
            return 1
        elif self.draw(board) == True:
            return 0
        else:
            return 2
        
    '''
    getSuccessorrs() is passed a board, and it returns
    a list of all positions on the board that are 
    unassigned
    '''    
    def getSuccessors(self, board):
        posMoves = []
        
        for i in range(10):
            
            if i >= 1 and (board[i] != 'X' and board[i] != 'O'):
                
                posMoves.append(i)
                
        #print posMoves
        return posMoves
    
    def minimax(self, board, level):
        pos = 0
        '''
        This checks if the game is over by calling checkboard,
        whcih returns -1, 0 or 1 depending on the outcome
        '''
        if self.checkBoard(board) != 2:
            return (self.checkBoard(board), pos)
  
        else:
            if level% 2 == 0: #max node
                max = float("-inf")
                for s in self.getSuccessors(board):
                    tBoard = copy.deepcopy(board)
                    tBoard[s] = 'O'
                    temp, v = self.minimax(tBoard, level + 1)
                    if temp > max:
                        max = temp
                        pos = s
                        
                return (max, pos)
            
            else: #min node
                min = float("inf")
                for s in self.getSuccessors(board):
                    tBoard = copy.deepcopy(board)
                    tBoard[s] = 'X'
                    temp, v = self.minimax(tBoard, level + 1)
                    if temp < min:
                        min = temp
                        pos = s
                        
                return (min, pos)
                    

    '''
    places an X on the positing entered
    by the user
    '''    
    def userMove(self, board, pos):
        board[pos] = 'X'
    '''
    calls minimax to decide where the computer
    will place an O
    '''
    def cpuMove(self, board):
        val, pos = self.minimax(copy.deepcopy(board), 0)
        board[pos] = 'O'
        
    '''
    Simple print function to show the player 
    the current board
    '''
    def reportBoard(self, board):
        print board[1], board[2], board[3]
        print board[4], board[5], board[6]
        print board[7], board[8], board[9]
        
if __name__ == "__main__":
    game = TicTacToe()
    board = game.initializeBoard()
    
    '''
    while no one has won or there isnt a draw
    '''
    while game.checkBoard(board) == 2:
        game.reportBoard(board)
        print 'make your move'
        pos = input()
        
        game.userMove(board, pos)
        print '\n \n'
        game.reportBoard(board)
        print '\n \n'
        game.cpuMove(board)
        
        if game.checkBoard(board) == -1:
            print 'user won'
            game.reportBoard(board)
            break
        elif game.checkBoard(board) == 0:
            print 'draw'
            game.reportBoard(board)
            break
        elif game.checkBoard(board) == 1:
            print 'computer won'
            game.reportBoard(board)
            break
        
        