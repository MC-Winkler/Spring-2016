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
        
    
ourDictionaryList = getDictionaryAsList("testDictionary.txt")
#print (getWordLength(ourDictionaryList))
#print (getGuesses())
#print (getRunningTotal())

allWordsOfChosenLength = getWordLength(ourDictionaryList)
guessesRemaining = getGuesses()
wantsRunningTotal = getRunningTotal()
lettersGuessed = []
currentWord = ""
playerWon = False
for i in range(len(allWordsOfChosenLength[0])):
    currentWord = currentWord + "-"
    
while guessesRemaining > 0 and playerWon is not True:
    #print("You have " + str(guessesRemaining) + " guesses left.")
    #if (wantsRunningTotal):
     #   print("There is/are " + str(len(allWordsOfChosenLength)) + " word/s left in the list." )
    #print("The letters you've guessed: " + str(lettersGuessed))
    #print("The word, with the letters you've guessed revealed: " + currentWord)
    
    user_input = ""
    while len(user_input) != 1 or user_input in lettersGuessed or not (re.search('[a-zA-Z]+', user_input)):
        user_input = input("Guess a letter: ")
    lettersGuessed.append(user_input)
        
    families = {}
    for word in allWordsOfChosenLength:
        key = currentWord
        if word.find(user_input) > -1:

            print("word = " + word)
            for i in range(len(word)):
                if word[i] == user_input:
                    print("In the inner if statement, i = " + str(i) )
                    print("key[:i] = " + key[:i])
                    print("user_input = " + user_input)
                    print("key[(i+1)] = " + key[(i+1):])                    
                    key = key[:i] + user_input + key[(i+1):]
        print("key got updated to " + key)
        if families.get(key) is None:
            families[key] = []
        tempFamilies = families.get(key)
        tempFamilies.append(word)
        families[key] = tempFamilies
        
    #print("families = " + str(families))
    longestLengthFound = 0
    longestKey = ""
    for key in families:
        if len(families.get(key)) > longestLengthFound:
            longestLengthFound = len(families.get(key))
            longestKey = key
    
    currentWord = longestKey
    allWordsOfChosenLength = families.get(longestKey)
   # if longestKey == allDashes:
    #    guessesRemaining -= 1
    
    print("After everything ran for one loop iteratrion, families = " + str(families))
    print("After everything ran for one loop iteration, currentWord = " + currentWord)
    
    if len(families.get(longestKey)) == 1 and currentWord.find("-") == -1:
        playerWon = True
        print("Hey good job you won, the word was " + currentWord)
    
    if guessesRemaining == 0:
        print("You lose and you should feel bad. The word was " + allWordsOfChosenLength.pop())
