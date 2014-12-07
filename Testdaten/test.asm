mov ax, DATA             
mov ds, ax             
mov dx, offset Meldung 

mov ah, 09h            
int 21h                
mov ax, 4C00h          
int 21h                