#-------dernierChiffre(n)-----------

def dernierChiffre(n):
    if n>=0:
        return n%10
    else:
        return 10-(n%10)

"""print(dernierChiffre(6782))
print(dernierChiffre(78295))
print(dernierChiffre(-65637))
print(dernierChiffre(0))"""


#-------deuxDernierChiffre(n)-----------

def deuxDernierChiffre(n):
    if n>=0:
        return n%100
    else:
        return 100-(n%100)


"""print(deuxDernierChiffre(6782))
print(deuxDernierChiffre(78295))
print(deuxDernierChiffre(-65637))
print(deuxDernierChiffre(0))"""


#-------dernierChiffres(n)-----------

def dernierChiffres(n,nbr):
    
    return n%(10**nbr)
    
"""print(dernierChiffres(6782,1))
print(dernierChiffres(78295,2))
print(dernierChiffres(65637,3))
print(dernierChiffres(0,3))"""

#----------nombreChiffres(n)-------
def nombreChiffres(n):
    if n==0 :
        return n
    i = 0
    while n >0:
        i+=1
        n=n//10 #n //= 10
    return i

"""
print(nombreChiffres(6782))
print(nombreChiffres(78295))
print(nombreChiffres(5665637))
print(nombreChiffres(0))
"""

#----------premierChiffre(n)-------


def premierChiffre(n):
    
    if n<0:
        return n
    
    while n >= 10:
       
        n=n//10 
    return n

"""
print(premierChiffre(6782))
print(premierChiffre(78295))
print(premierChiffre(5665637))
print(premierChiffre(0))
"""


#----------premierChiffres(n)-------

def premierChiffres(n,nbre):
    if n<0:
        return n
    
    while n >= 10**nbre:
       
        n=n//10 
    return n


print(premierChiffres(6782,1))
print(premierChiffres(78295,2))
print(premierChiffres(65637765345,5))
print(premierChiffres(0,3))


#---------------chiffres(n,debut,fin)-------

def chiffres(n,debut,fin):
    n = dernierChiffres(n,nombreChiffres(n)-debut+1)
    n = premierChiffres (n,fin -debut+1)
    return n

"""print(chiffres(6782,1,3))
print(chiffres(78295,2,6))
print(chiffres(65637765345,5,7))"""


#-------Petit Probleme graphique-------*

def Graph():
    h = 5867
    l = 32567
    nbr = 3456234
    print("le numero ")
    print(nbr //l)




#-----------DEUXIEME PARTIE----------





























