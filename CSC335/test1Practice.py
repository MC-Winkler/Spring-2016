# -*- coding: utf-8 -*-
"""
Created on Thu Mar 10 23:40:47 2016

@author: Michael
"""

list1 = ['string', 'string2', 'string3', 'strin1']

def method1 (lst):
    dict1={}
    for word in lst:
        key = len(word)
        if key not in dict1:
            print("in if statement")
            dict1[key]=[]
        dict1[key].append(word)
    print("dict1 = " + str(dict1))
        
method1(list1)