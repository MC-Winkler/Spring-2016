# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""

firstSentence = ['I', 'am', 'playing', 'xbox', 'and', 'trying', 'hard']

secondSentence = ['I', 'am', 'trying', 'hard', 'for', 'a', 'win']

print("1. " + str([x for x in (firstSentence + secondSentence) if len(x) > 2]))
print("2. " + str([x for x in firstSentence if x[:1]== 'a'])) 
print("3. " + str([x[-2:] for x in firstSentence ])) 
print("4. " + str([x for x in firstSentence + secondSentence if (len(x) % 2)== 0]))
print("5. " + str())
print("6. " + str([x for x in (firstSentence + secondSentence) if x[-3:] == 'ing']))
print("7. " + str([firstSentence[x] for x in range(len(firstSentence)) if firstSentence[x] == secondSentence[x]]))
print("8. " + str([x for x in firstSentence for y in secondSentence if x == y]))
print("9. " + str([x.capitalize() for x in firstSentence]))
print("10. " + str([x.replace('a','ee') for x in firstSentence]))
print("11. " + str())
print("12. " + str([(x,y) for x in firstSentence for y in secondSentence if x==y]))
print("13. " + str([x+y for x in firstSentence for y in secondSentence if len(x) < len(y)]))
print("14. " + str([]))
print("15. " + str([(x[0], y[0]) for x in firstSentence for y in secondSentence]))