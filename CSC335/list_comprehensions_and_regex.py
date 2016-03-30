# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""

import re

#To make everything work, simply put this file in the same folder as 
#lowerwords.txt and run it.

#Part 1 

firstSentence = ['I', 'am', 'playing', 'xbox', 'and', 'trying', 'hard']
secondSentence = ['I', 'am', 'trying', 'hard', 'for', 'a', 'win']

print("Part I: ")
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
print("11. " + str([(firstSentence[i], secondSentence[i]) for i in range(2,7)]))
print("12. " + str([(x,y) for x in firstSentence for y in secondSentence if x==y]))
print("13. " + str([x+y for x in firstSentence for y in secondSentence if len(x) < len(y)]))
print("14. " + str([]))
print("15. " + str([(x[0], y[0]) for x in firstSentence for y in secondSentence]))


#Part 2

def filterList(myRegex, myList):
    return [x for x in myList if re.search(myRegex, x)]
    
theList = []
listFile = open ('lowerwords.txt', 'r')
for line in listFile:
    theList.append(line.strip())
    
print()
print("Part II: ")    
print("1. " + str(len(filterList('a$', theList))))
print("2. " + str(len(filterList('^\w{4}d$', theList))))
print("3. " + str(len(filterList('[aeiou]$', theList))))
print("4. " + str(len(filterList('^[aeiou]\w*[aeiou]$', theList))))
print("5. " + str(len(filterList('^((a\w*a)|(e\w*e)|(i\w*i)|(o\w*o)|(u\w*u))$', theList)))) 
print("6. " + str(len(filterList('[aeiou][aeiou][aeiou][aeiou]', theList))))
print("7. " + str(len(filterList('\w*in\w*in\w*in\w*', theList))))
print("8. " + str(len(filterList(r'\w*(\w{2})\w*\1\w*\1\w*', theList)))) 
print("9. " + str(len(filterList(r'', theList)))) 
print("10. " + str(len(filterList(r'\w*((w)\2)\w*\1\w*\1\w*', theList)))) 
print("11. " + str(len(filterList(r'', theList)))) 
print("12. " + str(len(filterList(r'(\w)(?!\1)\1', theList)))) 

