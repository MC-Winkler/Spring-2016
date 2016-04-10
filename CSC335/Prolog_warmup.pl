series(1,3).
series(N, Ans):- N1 is N-1, OldAns is Ans/2 -1, series(N1, OldAns).

