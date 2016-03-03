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
for i in range(len(allWordsOfChosenLength[0])):
    currentWord = currentWord + "-"
    
while guessesRemaining > 0:
    print("You have " + str(guessesRemaining) + " guesses left.")
    if (wantsRunningTotal):
        print("There is/are " + str(len(allWordsOfChosenLength)) + " words left in the list." )
    print("The letters you've guessed: " + lettersGuessed)
    print("The word, with the letters you've guessed revealed: " + currentWord)
    
    user_input = ""
    while len(user_input) != 1 or user_input in lettersGuessed or not (re.search('[a-zA-Z]+', user_input)):
        user_input = input("Guess a new letter: ")