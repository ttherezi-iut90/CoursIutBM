def narcisse():
    val = input("val : ")
    somme = 0
    taille = len(val)
    for i in range(taille):
        somme += int(val[i])**taille
    
    if (int(val) == somme):
        print(val + " est un narcisse")
    
def narcisseAll():
    val = input ("val : ")
    
    for i in range(int(val)):
        somme = 0
        tail                                                             le = len(str(i))
        strval = str(i)
        for u in range(taille):
            somme += int(strval[u])**taille

        if (i == somme):
            print(str(somme) + " est un narcisse")



    
    
    

narcisseAll()            