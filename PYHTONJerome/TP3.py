#-----------------------isPremier(n)--------------

from math import *


def isPrime(n):
    if n == 2:
        return True
    if n % 2 == 0:
        return False
    d=3
    while d*d <= n:
        if n % d == 0:
            return False
        d += 2
    return True

"""for i in range(10**14,10**14+100):
    print(i)
    print(isPrime(i))
"""

#-----------------------ithPrime(n)--------------

def ithPrime(n):
    if n == 2:
        return 2
    i = 1
    j = 3
    while i < n:
        if isPrime(j):
            i += 1
        j += 2
    return j - 2


"""n=4
for i in range(10**n,10**n+100):
    print(i)
    print(ithPrime(i))
"""




#-----------------------decomposition(n)--------------
#Permet de décomposer un nombre en produit de facteurs premiers
def decomposition(n):
    tab=[]
    while n % 2 == 0:
        n = n // 2
        tab = tab + [2]
    if n==1:
        return tab
    d=3
    while n >= (d*d):
        if n % d == 0:
            n//=d
            tab.append(d)
        else:
            d += 2

    return tab + [n]

#test decomposition
# n=20
# for i in range(10**n,10**n+100):
#     print(i)
#     print(decomposition(i))


#------racine(n)--------------
#Revoie deux entiers a et b tels que √n = a √b, avec a maximal et b minimal (simplicateur de racines carrées).


def racine(n):
   a=1
   b=n
  
   if n==1:
        return a,b
   
   while b%4 == 0:
        b//=4
        a *=2
   
   d=3
   while (d*d) <= b :
        if b%(d*d) == 0:
            b//=d*d
            a*=d
        else:
            d+=2

   return a,b


print(racine(25419680))
print(racine(36))


#----------------------pgcd(n)---------------------
#Renvoie le pgcd de deux entiers a et b
def euclide(a,b):
    if a < b:
        a,b = b,a
    r = 1
    while r != 0:
        r = a % b
        a = b
        b = r
    return a

print(euclide(10**1000000+5990,10**1000000+42832))