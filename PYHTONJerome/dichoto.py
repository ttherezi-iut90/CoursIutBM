def dichotomie(f,a,b,e):
    delta = 1
    while delta > e:
        m = a + (b - a) / 2
        delta = abs(b - a)
        print("{:15} , {:15} , {:15} , {:15} , {:15} , {:15} , {:15} ".format(a,b,m,f(a),f(b),f(m),delta) )
        if f(m) == 0:
            return m
        elif f(a) * f(m)  > 0:
            a = m
        else:
            b = m
    return a, b, delta
        
print( dichotomie(lambda x: x*x - 2, 0, 2, 0.001) )