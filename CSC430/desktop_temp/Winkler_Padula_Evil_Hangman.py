"""
Alexis Padula and Michael Winkler
CSC335 Evil Hangman
"""

import re

def getDictionaryAsList(filename):
    dictionaryList = []
    dictionaryFile = open (filename, 'r')
    for line in dictionaryFile:
        dictionaryList.append(line.strip())
    return dictionaryList
    
def getWordLength(dictionaryAsList):
    allWordsOfChosenLength = []
    inputMatchesWords = False    
    while (inputMatchesWords==False):
        user_input = input("Enter a word length: ")
        for word in dictionaryAsList:
            if (len(word)==int(user_input)):
                allWordsOfChosenLength.append(word)
                inputMatchesWords = True
    return allWordsOfChosenLength
                
def getGuesses():
    user_input = 0
    while user_input < 1:
        user_input = int(input("Enter a number of guesses greater than 0: "))
    return user_input

def getRunningTotal():
    user_input = ""
    while ("yes" not in user_input and "no" not in user_input 
        and "Yes" not in user_input and "No" not in user_input):
        user_input = input("Do you want me to display a running total of the words" 
        + " left in the list? yes/no: ")
    if user_input == "yes":
        return True
    else:
        return False

def afterGuessOutput(guesses,lettersGuessed,currentWord,allWordsOfLength):
    print ("Guesses remaining: " + str(guesses))
    print("Letters guessed: " + str(lettersGuessed))
    print("Word currently is: " + currentWord)
    print("Words left in list: "+str(len(allWordsOfLength)))

    
        
    
ourDictionaryList = getDictionaryAsList("dictionary.txt")

wantsToPlay = "yes"
while wantsToPlay == "yes":
    #initializations
    allWordsOfChosenLength = getWordLength(ourDictionaryList)
    guessesRemaining = getGuesses()
    wantsRunningTotal = getRunningTotal()
    lettersGuessed = []
    currentWord = ""
    playerWon = False
    for i in range(len(allWordsOfChosenLength[0])):
        currentWord = currentWord + "-"
    allDashes = ""
    for i in range(len(allWordsOfChosenLength[1])):
        allDashes = allDashes + "-"
      
    #game loop
    while guessesRemaining > 0 and playerWon is not True:   
        user_input = ""
        while len(user_input) != 1 or user_input in lettersGuessed or not (re.search('[a-zA-Z]+', user_input)):
            user_input = input("Guess a letter: ")
        lettersGuessed.append(user_input)
        
        #creating the word families, which are lists held in a dictionary
        #keys are strings that are a combination of dashes and letters
        families = {}
        for word in allWordsOfChosenLength:
            key = currentWord
            if word.find(user_input) > -1:
                for i in range(len(word)):
                    if word[i] == user_input:
                        key = key[:i] + user_input + key[(i+1):]
            if key not in families:
                families[key] = []
            families[key].append(word)
            
        #longestkey is the key that grants access to the longest list
        #of words in the dictionary, unless the user only has one guess left,
        #in which case it will be all dashes, causing the user to lose their
        #last guess
        longestLengthFound = 0
        longestKey = ""
        if(guessesRemaining == 1 and families[allDashes] != None):
            longestKey = allDashes
        else:
            for key in families:
                if len(families[key]) > longestLengthFound:
                    longestLengthFound = len(families[key])
                    longestKey = key
        
        currentWord = longestKey
        allWordsOfChosenLength = families[longestKey]
        
    
        if longestKey == allDashes:
            guessesRemaining = guessesRemaining-1
         
        afterGuessOutput(guessesRemaining,lettersGuessed,currentWord,allWordsOfChosenLength)
        
        
        if len(families[longestKey]) == 1 and currentWord.find("-") == -1:
            playerWon = True
            print("Hey good job you won, the word was " + currentWord)
            wantsToPlay = input("Do you want to play again? yes/no: " )
        
        if guessesRemaining == 0:
            print("You lose and you should feel bad. The word was " + allWordsOfChosenLength.pop())
            wantsToPlay = input("Do you want to play again? yes/no: " )

        
