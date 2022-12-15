#-----------------------isPremier(n)--------------

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
n=20
for i in range(10**n,10**n+100):
    print(i)
    print(decomposition(i))


