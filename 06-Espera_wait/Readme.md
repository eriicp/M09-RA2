1. Per què s'atura l'execució al cap d'un temps? 

L'execució pot semblar que s'atura perque, una vegada estan ocupades totes les plaçes, quan els fils que tinguin reserves intentin reservar es quedaran esperant infinitament ja que son ells els Assistents amb reserva que han de cancelar.

2.Què passaria si en lloc de una probabilitat de 50%-50% fora de 70% (ferReserva)-30% (cancel·lar)?

70% reservar :

int res = Random.nextInt(100);
if(res <= 70){
    Esdeveniment.ferReserva(this);
}
else{
    Esdeveniment.cancelaReserva(this);
}

Execucio:
Assistent - 0 ha fet una reserva. Places disponibles: 4
Assistent - 1 ha fet una reserva. Places disponibles: 3
Assistent - 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent - 3 ha fet una reserva. Places disponibles: 2
Assistent - 4 ha fet una reserva. Places disponibles: 1
Assistent - 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent - 5 ha fet una reserva. Places disponibles: 0
Assistent - 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 1 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 7 ha fet una reserva. Places disponibles: 0
Assistent - 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0



30 % reservar :
int res = Random.nextInt(100);
if(res <= 30){
    Esdeveniment.ferReserva(this);
}
else{
    Esdeveniment.cancelaReserva(this);
}

Execucio:
Assistent - 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent - 1 ha fet una reserva. Places disponibles: 4
Assistent - 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent - 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent - 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent - 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent - 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent - 7 ha fet una reserva. Places disponibles: 3
Assistent - 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent - 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent - 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent - 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent - 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent - 7 ha fet una reserva. Places disponibles: 2
Assistent - 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent - 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent - 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent - 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent - 1 ha cancel·lat una reserva. Places disponibles: 3
Assistent - 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent - 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent - 7 ha cancel·lat una reserva. Places disponibles: 4
Assistent - 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent - 7 ha fet una reserva. Places disponibles: 3
Assistent - 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent - 3 ha fet una reserva. Places disponibles: 2
Assistent - 2 ha fet una reserva. Places disponibles: 1
Assistent - 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent - 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent - 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent - 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent - 2 ha cancel·lat una reserva. Places disponibles: 2
Assistent - 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent - 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent - 4 ha fet una reserva. Places disponibles: 1
Assistent - 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent - 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent - 3 ha fet una reserva. Places disponibles: 0
Assistent - 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 7 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 6 ha fet una reserva. Places disponibles: 0
Assistent - 3 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 8 ha fet una reserva. Places disponibles: 0
Assistent - 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 7 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 0 ha fet una reserva. Places disponibles: 0
Assistent - 4 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent - 1 ha fet una reserva. Places disponibles: 0
Assistent - 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 8 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 2 ha fet una reserva. Places disponibles: 0
Assistent - 3 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 7 ha fet una reserva. Places disponibles: 0
Assistent - 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 6 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 1 ha fet una reserva. Places disponibles: 0
Assistent - 2 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 0 ha fet una reserva. Places disponibles: 0
Assistent - 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 1 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 4 ha fet una reserva. Places disponibles: 0
Assistent - 4 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 8 ha fet una reserva. Places disponibles: 0
Assistent - 7 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 0 ha fet una reserva. Places disponibles: 0
Assistent - 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 0 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 7 ha fet una reserva. Places disponibles: 0
Assistent - 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 7 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 6 ha fet una reserva. Places disponibles: 0
Assistent - 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 6 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 1 ha fet una reserva. Places disponibles: 0
Assistent - 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 1 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 2 ha fet una reserva. Places disponibles: 0
Assistent - 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 2 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 8 ha fet una reserva. Places disponibles: 0
Assistent - 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 1 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 5 ha fet una reserva. Places disponibles: 0
Assistent - 8 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 0 ha fet una reserva. Places disponibles: 0
Assistent - 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 8 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 9 ha fet una reserva. Places disponibles: 0
Assistent - 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 0 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 4 ha fet una reserva. Places disponibles: 0
Assistent - 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 0 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 3 ha fet una reserva. Places disponibles: 0
Assistent - 4 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 5 ha fet una reserva. Places disponibles: 0
Assistent - 0 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 9 ha fet una reserva. Places disponibles: 0
Assistent - 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 9 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 8 ha fet una reserva. Places disponibles: 0
Assistent - 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 8 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 1 ha fet una reserva. Places disponibles: 0
Assistent - 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 1 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 4 ha fet una reserva. Places disponibles: 0
Assistent - 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 4 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 2 ha fet una reserva. Places disponibles: 0
Assistent - 5 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 3 ha fet una reserva. Places disponibles: 0
Assistent - 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 3 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 9 ha fet una reserva. Places disponibles: 0
Assistent - 5 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 0 ha fet una reserva. Places disponibles: 0
Assistent - 0 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 8 ha fet una reserva. Places disponibles: 0
Assistent - 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 8 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 1 ha fet una reserva. Places disponibles: 0
Assistent - 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 1 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 7 ha fet una reserva. Places disponibles: 0
Assistent - 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 7 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 2 ha fet una reserva. Places disponibles: 0
Assistent - 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 2 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 6 ha fet una reserva. Places disponibles: 0
Assistent - 6 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 3 ha fet una reserva. Places disponibles: 0
Assistent - 3 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 9 ha fet una reserva. Places disponibles: 0
Assistent - 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 3 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 5 ha fet una reserva. Places disponibles: 0
Assistent - 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 9 ha cancel·lat una reserva. Places disponibles: 1
Assistent - 4 ha fet una reserva. Places disponibles: 0
Assistent - 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent - 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0


3. Perquè creus que fa falta la llista i no valdria només amb una variable sencera de reserves? 

Si només tinguéssim un contador, qualsevol assistent podria fer cancelaReserva i baixar el comptador, fins i tot si no tenia reserva prèvia. La llista permet comprovar que només qui té reserva la pot cancel·lar.