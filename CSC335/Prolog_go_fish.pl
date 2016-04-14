%Michael Winkler
%CSC335, Prof. Shannon Duvall, 4/10/16

% - X is the element to be taken out .
% - H is the head of the input list if X is not the head of that list .
% - T is the tail of the input list.
% - PrevTail is the tail of the input list with all occurences of X
%   removed.
% - PrevTotal is the number of occurences of X removed via the
%   recursive call.
takeout(_, [], [], 0).
takeout(X, [X|T], PrevTail, Total):- takeout(X, T, PrevTail, PrevTotal), Total is PrevTotal + 1.
takeout(X, [H|T], [H|PrevTail], PrevTotal):- takeout(X,T, PrevTail, PrevTotal).

% alternate implementation of putIn - causes out of stack error and
% makes go fish crash
% putIn(L1, _, 0, L1).
% putIn(L1, Element, NumOccur,[Element|PrevList]):- PrevNumOccur is
% NumOccur -1, putIn(L1, Element, PrevNumOccur, PrevList).

% Works, but doesn't return false after its initial answer. Causes a bug
% in go fish when players ask for cards from each other.
putIn(L1, _, 0, L1).
putIn([], X, NumOccur, [X|PrevList]):- PrevNumOccur is NumOccur -1, putIn([],X, PrevNumOccur, PrevList).
putIn([H|T], X, NumOccur, [H|PrevList]):- putIn(T,X,NumOccur,PrevList).

% - X is the element to be counted.
% - H is the head of the input list if X is not the head of that list.
% - T is the Tail of the input list.
% - Count is the number of times X occurs in the input list.
% - PrevCount is how many times X occurs in the tail of the input list
count(_, [], 0).
count(X, [X|T], Count):- count(X, T, PrevCount), Count is PrevCount + 1.
count(X, [H|T], Count):- count(X, T, Count).

% - X is the number to be deleted.
% - H is the head of the input list if X is not the head of that list.
% - T is the tail of the input list.
% - NewList is the input list with the correct number of instances of X
%   deleted.
% - NumToDelete is the number of instances of X to delete.
% - RecursiveNumToDelete is the number of Xs that were deleted via the
%   recursive call.
deleteNum(_, List, List ,0).
deleteNum(X, [X|T], NewList, NumToDelete):- RecursiveNumToDelete is NumToDelete -1, deleteNum(X, T, NewList, RecursiveNumToDelete).
deleteNum(X, [H|T], [H|RecursiveNewList], NumToDelete):- deleteNum(X,T,RecursiveNewList,NumToDelete).

% - H is the head of the input list
% - T is the tail of the input list
% - InHand is the input list with four instances of the head deleted
%   (only relevant if there exist four instances of the head in the
%   list).
% - InSet is the input set with and instance of the head added to it
%   (again, only relevant if there are four instances of H in the input
%   list).
% - PrevHand is the Tail of the input list with all sets of four (or
%   eight, twelve, etc) elements removed.
% - PrevSet holds one instance of each element that occurs four (or
%   eight, tweleve, etc.) times in the tail of the input list.
groupFours([],Set,[],Set).
groupFours([H|T], Set, NewHand, NewSet):- count(H,[H|T],4), deleteNum(H, [H|T], InHand, 4), putIn(Set, H, 1, InSet), groupFours(InHand, InSet, NewHand, NewSet).
groupFours([H|T], Set, [H|PrevHand], PrevSet):- groupFours(T, Set,PrevHand, PrevSet).



