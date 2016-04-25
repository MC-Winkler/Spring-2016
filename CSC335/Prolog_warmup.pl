series(1,3).
series(N, Ans):- N1 is N-1, OldAns is Ans/2 -1, series(N1, OldAns).

scalarMult([], Factor, []).
scalarMult([H|T], Factor, [H2|T2]):- NewHead is H*Factor, H2=NewHead, scalarMult(T,Factor,T2).