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

"""
print(premierChiffres(6782,1))
print(premierChiffres(78295,2))
print(premierChiffres(65637765345,5))
print(premierChiffres(0,3))
"""

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


def quotient(a,b):
    if b == 0:
        print(" division par 0 impossible")
        return 
    i = 0
    while (a>=b):
        a = a - b
        i =i + 1
    
    return i
"""
quotient(3,8)
quotient(8,0)
quotient(8,3)
quotient(236,30)
"""


def reste(a,b):
    if b == 0:
        print(" division par 0 impossible")
        return 
    c = b
    while (a>=b):
        a = a - b
        
    
    return a


"""
reste(3,8)
reste(8,0)
reste(8,3)
reste(236,30)
"""



def div( a,b):
    if b == 0:
        print(" division par 0 impossible")
        return 
    i = 0
    while (a>=b):
        a = a - b
        i =i + 1
    
    return i,a
"""
div(3,8)
div(8,0)
div(8,3)
div(236,30)
"""

def quotient2(a,b):
    q,r = div(abs(a),abs(b))
    if r != 0:
        if a>=0 and b>0:
            return q
        if a>=0 and b<0:
            return -q
        if a<0 and b>0:
            return -q-1
        if a<0  and b<0 :
            return q+1
    else:
        if a>=0 and b>0:
            return q
        if a>=0 and b<0:
            return -q
        if a<0 and b>0:
            return -q
        if a<0  and b<0 :
            return q

"""          
print("quotien 2")
print(quotient2(26,5))
print(quotient2(26,-5))
print(quotient2(-26,5))
print(quotient2(-26,-5))
print(quotient2(25,5))
print(quotient2(25,-5))
print(quotient2(-25,5))
print(quotient2(-25,-5))
 """

def reste2(a,b):
    q,r = div(abs(a),abs(b))
    if r != 0:
        
        if a<0 and b>=0:
            return b-r
        if a<0  and b<0 :
            return -b-r
        return r
    else:
        return 0

""" 
print("reste 2")
print(reste2(26,5))
print(reste2(26,-5))
print(reste2(-26,5))
print(reste2(-26,-5))
print(reste2(25,5))
print(reste2(25,-5))
print(reste2(-25,5))
print(reste2(-25,-5))
 """

def div2(a,b):
    q,r = div(abs(a),abs(b))
    if r != 0:
        if a>=0 and b>=0:
            return q,r
        if a>=0 and b<0:
            return -q,r
        if a<0 and b>=0:
            return -q-1,b-r
        if a<0  and b<0 :
            return q+1,-b-r
    else:
        if a>=0 and b>=0:
            return q,r
        if a>=0 and b<0:
            return -q,r
        if a<0 and b>=0:
            return -q,r
        if a<0  and b<0 :
            return q,r


"""
print("div 2")
print(div2(26,5))
print(div2(26,-5))
print(div2(-26,5))
print(div2(-26,-5))
print(div2(25,5))
print(div2(25,-5))
print(div2(-25,5))
print(div2(-25,-5))
"""

""" 
for i in range(600000,2000000):
    print(i)
    print((1037**i)%5042)
    

 """
""" 
for i in range(10):
    print(i)
    print(reste(1037**i,5042))


 """

def puissance(a,b,c):
    res = 1
    a=a%c
    for i in range(b):
        res = a * res % c
    return res

""" 
for i in range(7):
    print(puissance(7,i,10))

"""


""" 
for i in range(5000000,10000000):
    print(puissance(1037,i,5042))

 """


def puissance2(a,b,c):
    a = a%c    
    if b==0:
        return 1 
    elif b==1:
        return a
    elif b%2 ==0:
        res = puissance2(a,b//2,c)
        return (res*res)%c
    else:
        res = puissance2(a,b//2,c)
        return (res*res*a)%c


""" 

for i in range(10**200,10**300):
    print(puissance2(7,i,10))


 """


def puissance3(a,b,c):
    a = a % c
    tab = [1]
    res = 1
    inTab = False
    while not inTab :
        res= (res*a%c)
        if (res not in tab):
            tab.append(res)
        else:
            inTab = True
    deb = tab.index(res)
    longCycle = len(tab)-deb
    if b<deb : 
        return tab[b]
    else:
        b%=longCycle
        i = deb 
        while i%longCycle != b:
            i+=1
        print(tab)
        print(deb)
        print(longCycle)
        return tab[i]
        



print(puissance3(1037,10**3000000 +567,5042))


