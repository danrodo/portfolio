'''
Created on Aug 28, 2014

@author: simplymac
'''
"""
    StableMatch.py

    Stable match implementation
    
    This algorithm operates by reading an input file of
    the form
    
    [man|women] pref1, pref2, pref3, ...
    
    Any whitespace occurring in the input files is stripped off.
    
    Usage:
    python StableMatch.py [men preferences file] [women preferences file]
    
    
    Daniel Rodosky
"""

import csv
import sys

class StableMatch:

    # __init__ behaves similarly to a constructor
    def __init__(self):
        """
        Think of 
            
            freeMen
            menMappings
            womenMappings
            matches

        as being instance data for your class.

        Whenever you want to refer to instance data, you must
        prepend it with 'self.<instance data>'

        i.e. 
            self.freeMen
            self.menMappings
            self.womenMappings
            self.matches
        """

        # list of available men
        self.freeMen = [ ]
    
        # mapping of person with list of preferences
        self.menMappings = { }
        self.womenMappings = { }
    
        # dictionary of matches where mapping is [woman:man]
        self.matches = { }

        # read in the preference files
        
        '''
        This constructs a dictionary mapping a man to a list of women in order of preference
        '''
        prefsReader = csv.reader(open (sys.argv[1],'r'), delimiter = ',')
        for row in prefsReader:
            # Add the man to the list of free men
            man = row[0].strip()
            #self.freeMen.append(row[0].strip())
            self.freeMen.append(man)
            
            # This line strips off any whitespace when constructing a new list
            self.menMappings[row[0].strip()] = [row[i].strip() for i in range(1,len(row))]
            self.menMappings[man] = [x.strip() for x in row[1:]]

        '''
        This constructs a dictionary mapping a woman to a list of men in order or preference
        '''
        prefsReader = csv.reader(open(sys.argv[2],'r'), delimiter = ',')
        for row in prefsReader:
            # This line strips off any whitespace when constructing a new list
            #self.womenMappings[row[0].strip()] = [row[i].strip() for i in range(1,len(row))]
            woman = row[0].strip()
            self.womenMappings[woman] = [x.strip() for x in row[1:]]
        
            # initially have each women unmatched
            self.matches[woman] = None
            
    def propose(self, man, woman):
        
        currentMatch = (self.matches[woman])
        if currentMatch == None:
            return True
        if (self.womenMappings[woman]).index(man) < (self.womenMappings[woman]).index(currentMatch):
            (self.freeMen.append(currentMatch))
            return True
        else:
            return False

    def runMatch(self):
        """ 
        it is suggested you use the debugger or similar output statements
        to determine what the contents of the data structures are.

        Remember - we use 'self.<instance data>' in front of whatever
        instance data we want to reference.
        """
        
        while self.freeMen:
            man = self.freeMen.pop()
            woman = (self.menMappings[man]).pop(0)
            
            while self.propose(man, woman) == False:
                woman = (self.menMappings[man]).pop(0)
                            
            (self.matches[woman]) = man
                
        for x in self.matches:
            print x, ' Is Matched To ', self.matches[x]

if __name__ == "__main__":
    
        # some error checking
    if len(sys.argv) != 3:
        print 'ERROR: Usage\n python StableMatch.py [mens preferences] [womens preferences]'
        quit()
   
        # create an instance of StableMatch 
    stable = StableMatch()
    
        # now call the runMatch() function
    stable.runMatch()