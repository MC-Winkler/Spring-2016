# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""

import random

def make_dictionary(filename):
    pirate_dict = {}
    infile = open(filename, 'r')
    for line in infile:
        [english, pirate] = line.split(":")
        pirate_dict[english]=pirate.strip()
    return pirate_dict

def interact(pirate_dict):
    print("Arr! Welcome to the Pirate Translator")
    print("Enter your setence or q to quit.")
    user_input = input("Enter a line: ")
    user_input = " " + user_input + " "
    for word in pirate_dict:
        user_input = user_input.replace(" " + word + " ", " " + pirate_dict.get(word) + " ")
    if random.random() < .3:
        user_input = user_input + ", arr."
    return user_input[1:]
    

pirate_dict = make_dictionary("Translation.txt")

result = interact(pirate_dict)
print(result)
while not (result == "q"):
    result = interact(pirate_dict)
    print(result)