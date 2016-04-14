% Shannon Duvall's Go Fish Code 
% 
% Top level query is either: 
% goFish(Cheat).  where Cheat is either true or false, or 
% goFish(P1Hand, P2Hand,Cheat) where other than the Cheat argument,
% The first argument is Player 1's 
% initial hand, and the second argument is Player 2's initial hand. The lists 
% should contain numbers from 1 to 9. 
% If the Cheat variable is true, the computer's hand and the deck will be printed.
%
% Example query: 
% ?- goFish([1,2,3,4,5],[6,7,8,9,1],true).
%
% or
% 
% ?- goFish(false).

:- use_module(library(random)).

cards([0,0,0,0,
       1,1,1,1,
       2,2,2,2,
       3,3,3,3,
       4,4,4,4,
       5,5,5,5,
       6,6,6,6,
       7,7,7,7,
       8,8,8,8,
       9,9,9,9]).


% Shuffle the deck.  Call with X unbound.
scramble(X):-cards(L), shuffle(L,X), !.

shuffle([],[]).
shuffle([X],[X]).
shuffle([H|T],Out):- shuffle(T,Out2), random_insert(H,Out2,Out).

random_insert(Card,Deck1,Deck2):- length(Deck1,X), Upper is X +1,
  random(1,Upper,Rand), 
  insert_at(Card,Rand,Deck1,Deck2).

insert_at(C,1,D,[C|D]).
insert_at(C,X,[DeckHead|DeckTail],[DeckHead|Done]):-X1 is X-1, insert_at(C,X1,DeckTail,Done).



goFish(Cheat):- assert(cheat(Cheat)), scramble(Deck),Deck = [A1,A2,A3,A4,A5,A6,A7,
				B1,B2,B3,B4,B5,B6,B7|Rest],
  assert(deck(Rest)),!,goFish([A1,A2,A3,A4,A5,A6,A7],[B1,B2,B3,B4,B5,B6,B7],Cheat).

goFish(P1Hand, P2Hand, Cheat) :- assert(cheat(Cheat)),!,
	go_fish_round(P1Hand, [], P2Hand, []). 


% One round consists of each player taking a turn, and checking for game over.
go_fish_round(P1Hand, P1Set, P2Hand, P2Set) :- 
	player_turn(P1Hand, P1Set, P2Hand, P1Hand2, P1Set2, P2Hand2),!,
	computer_turn(P2Hand2, P2Set, P1Hand2, P2Hand3, P2Set2, P1Hand3),!,
        ((gameOver(P1Hand3,P1Set2,P2Hand3,P2Set2),!); go_fish_round(P1Hand3, P1Set2, P2Hand3, P2Set2)).

% The game is over when either one of the player's hands or the deck is empty.
gameOver(_,P1Set,_,P2Set):- deck([]), proclaimWinner(P1Set,P2Set).
gameOver([],P1Set,_,P2Set):-proclaimWinner(P1Set,P2Set).
gameOver(_,P1Set,[],P2Set):-proclaimWinner(P1Set,P2Set).

proclaimWinner(P1Set,P2Set):- length(P1Set, Score1), length(P2Set, Score2),
  write('Your sets are '), writeList(P1Set), nl,
  write('My sets are '), writeList(P2Set), nl,
  ((Score1>Score2, write('Game over, You win!'));
   (Score1<Score2, write('Game over, I win!'));
   (Score1=Score2, write('We tied!'))).

% computer_turn takes as arguments the computer's Hand and Set lists,
% the asked player's Hand, and the new Hand and Set list for the 
% computer and the new asked player's hand.
%
% The computer's strategy is to always ask for the card it has the most of.

% Both players have the basic algorithm:
% ask the other player for a card number
% Pull out all of that card from the other player.
% If the other player had none, then the player "goes fish" by getting a card from the deck.
% At the end of the turn, see if there are 4 of a card type.  If so, remove them from the hand 
% and add it to the "sets" list.

computer_turn(P1Hand, P1Set, P2Hand, P1NewHand, P1NewSet, P2NewHand) :-
	write('Computer\'s turn'), nl,
	((cheat(true), writeList(P1Hand));true),
	maxOccur(P1Hand, Num),
	write('Gimme all your '), write(Num), write('s!'),nl,
	((takeout(Num, P2Hand, P2NewHand, 0), go_fish(P1Hand,P1Set,P1NewHand,P1NewSet,false));
	 (takeout(Num, P2Hand, P2NewHand, SwapNum), SwapNum > 0, dont_go_fish(P1Hand,P1Set,Num,SwapNum,P1NewHand,P1NewSet))),
	((cheat(true), writeList(P1NewHand));true),
	  write('Computer\'s sets are '),writeList(P1NewSet), nl.

player_turn(P1Hand, P1Set, P2Hand, P1NewHand, P1NewSet, P2NewHand) :- 
	write('Your turn.  Your hand is: '),nl,
	writeList(P1Hand),nl, write('Your sets are: '),writeList(P1Set),nl,
	write('What do you want to ask for?'), nl,
	read(Num),nl,
        ((takeout(Num,P2Hand,P2NewHand,0),go_fish(P1Hand,P1Set,P1NewHand,P1NewSet, true));
	(takeout(Num,P2Hand,P2NewHand,SwapNum),dont_go_fish(P1Hand, P1Set, Num, SwapNum, P1NewHand, P1NewSet))),
	write('Your Hand is '),	writeList(P1NewHand),nl,  write(' and Sets are '), writeList(P1NewSet), nl.

dont_go_fish(P1Hand, P1Set, Num, SwapNum, P1NewHand, P1NewSet):-
	putIn(P1Hand, Num, SwapNum, P1Hand2),
	write(SwapNum), 	
	write(' '), write(Num), write('s received.'),nl, 
	groupFours(P1Hand2, P1Set, P1NewHand, P1NewSet).

go_fish(P1Hand, P1Set, P1NewHand, P1NewSet, User) :-
	write('Go Fish!'),nl,
	draw(P1Hand, P1Hand2,User),
	groupFours(P1Hand2, P1Set, P1NewHand, P1NewSet).

% These are Helper predicates.

writeList(L):- write('['), wl(L), write(']').
wl([]):-!.
wl([H|T]):- write(H), write(' '), wl(T).

% To draw a new number, add the first element of the master list
% as the first element of the hand list. Also remove the element
% from the master list using retract and assert.
draw(P1Hand, [H|P1Hand],Print):-
	deck([H|T]),
	((Print=true,write('Draws a '), write(H),nl);(Print=false)),
	((cheat(true), write('Deck is '), writeList(T), nl);true),	
	retract(deck(_)), assert(deck(T)), !.

% Determine the winner as being the player whose set list is the
% longest.
winner(P1Set, P2Set):-
	length(P1Set, N), length(P2Set, M), N > M,
	write('Player one wins with '), write(N), write(' sets.'),nl,!.

winner(P1Set, P2Set):-
	length(P1Set, N), length(P2Set, M), M > N,
	write('Player two wins with '),
	write(M), write(' sets.'),nl,!.

winner(_, _):-
	write('Tie Game!'),!.

% maxOccur (List, Element) returns the element that occurs most often in
% the list.  First, I create a separate list of all elements and how many
% times each occurs.  Then, I return the element in the occurList with the
% maximal count.

maxOccur([E],E):-!.
maxOccur(L,Element) :-
	occurList(L,L2),
	countOccur(L2,Element, _).

occurList([],[]).
occurList([H|T],L1) :-
	occurList(T,L2),
	(member((H,Cnt),L2) -> delete((H,Cnt),L2,L3), 			
	append([(H,Cnt+1)],L3,L1); append([(H,1)],L2,L1)).

countOccur([(E,_)],E, 1):-!.

countOccur([(H,Num)|T],Element,Cnt):-
	co(T,H,Num,Element,Cnt).

co([],H,Num,H,Num).

co([(H,Num)|T],_,Csf,E,C):-
	Num > Csf,
	NCsf = Num, NEsf = H,
	co(T,NEsf,NCsf,E,C).

co([(_,Num)|T],Esf,Csf,E,C):-
	Num < Csf,
	NCsf = Csf, NEsf = Esf,
	co(T,NEsf,NCsf,E,C).

co([(_,Num)|T],Esf,Csf,E,C):-
	Num = Csf,
	NCsf = Csf, NEsf = Esf,
	co(T,NEsf,NCsf,E,C).

co([(H,Num)|T],_,Csf,E,C):-
	Num = Csf,
	NCsf = Num, NEsf = H,!,
	co(T,NEsf,NCsf,E,C).

delete(E,[E|T],T):- !.
delete(E,[H|T],[H|L]):- delete(E,T,L).




