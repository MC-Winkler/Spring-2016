%Michael Winkler
%CSC335, Prof. Shannon Duvall, 4/10/16

takeout(_, [], [], 0).
takeout(X, [X|T], PrevTail, Total):- takeout(X, T, PrevTail, PrevTotal), Total is PrevTotal + 1.
takeout(X, [Y|T], [Y|PrevTail], PrevTotal):- Y\==X, takeout(X,T, PrevTail, PrevTotal).

putIn(L1, _, 0, L1).
putIn([], X, NumOccur, [X|PrevList]):- PrevNumOccur is NumOccur -1, putIn([],X, PrevNumOccur, PrevList).
putIn([H|T], X, NumOccur, [H|PrevList]):- putIn(T,X,NumOccur,PrevList).

count(_, [], 0).
count(X, [X|T], Count):- count(X, T, PrevCount), Count is PrevCount + 1.
count(X, [Y|T], Count):- Y\==X, count(X, T, Count).

deleteNum(_, List, List ,0).
deleteNum(X, [X|T], NewList, NumToDelete):- RecursiveNumToDelete is NumToDelete -1, deleteNum(X, T, NewList, RecursiveNumToDelete).
deleteNum(X, [Y|T], [Y|RecursiveNewList], NumToDelete):- Y\==X, deleteNum(X,T,RecursiveNewList,NumToDelete).
