# import 
#-------factorielle(n)-----------
def factorielle(n):

    if n<0:
        print("erreur : n est inferieur a 0")

    if n==0 or n==1:
        return 1
    
    fact = 2
    for i in range(3,n+1):
        fact = fact*i #fact *= i

    return fact

#print(factorielle(0))
#print(factorielle(1))
#print(factorielle(2))
#print(factorielle(3))
#print(factorielle(4))
#print(factorielle(5))
#print(factorielle(25))


#------absolue(x)-------

def absolue(x):
    if x<0:
        x = x *-1
    return x

# print(absolue(0))
# print(absolue(1))
# print(absolue(-1))
# print(absolue(2))
# print(absolue(-2))
# print(absolue(-56))

#------U1(n)-------

def U1(n):
    if n<1:
        print("erreur : n<1")
    if n==1:
        return 1
    result = 1
    for i in range(2,n+1):
        result = result+i #fact += i
    return result
# print(U1(0))
# print(U1(1))
# print(U1(2))
# print(U1(3))
# print(U1(4))
# print(U1(25))


#----------U2(n)---------

def U2(n):
    if n<1:
        print("erreur : n<1")
    if n%2==0:
        return int((n+1)*(n/2))
    else:
        return int((n+1)*((n+1)/2)-(n/2))
    
# print(U2(0))
# print(U2(1))
# print(U2(2))
# print(U2(3))
# print(U2(4))
# print(U2(5))
# print(U2(6))
# print(U2(25))
# (n+1 * n+1)/ 2 

#----------V2(n)---------

def V(n):
    res = 1745
    for i in range (n):
        res = res*0.99972 +2123
    return res
# print(V(0))
# print(V(1))
# print(V(2))
# print(V(3))
# print(V(4))
# print(V(5))

# for i in range (1000):
#     print(V(i))


#il semble que la suite est croissante
i=0
while V(i+1) != V(i):
    i += 1
    print(i)
print(V(i))
print(i)
