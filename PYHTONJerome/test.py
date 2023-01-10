import cv2

# Ouvrez la webcam avec cv2.VideoCapture
cap = cv2.VideoCapture(0)

# Boucle infinie pour afficher l'image capturée de la webcam
while True:
   # Capturez l'image de la webcam
    ret, frame = cap.read()
    
    # Appliquer un filtre gris à l'image
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    
    # Appliquer un filtre flou à l'image
    blur = cv2.GaussianBlur(frame, (5, 5), 0)
    
    # Appliquer un filtre de couleur inversée à l'image
    inv = cv2.bitwise_not(frame)
    
    # Affichez l'image filtrée
    cv2.imshow('Webcam', gray)
    
    # Attendre une touche pour quitter
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break
# Libérez la webcam et fermez toutes les fenêtres
cap.release()
cv2.destroyAllWindows()