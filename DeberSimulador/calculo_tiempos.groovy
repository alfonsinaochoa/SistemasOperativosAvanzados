#input Decimal[] tiempo, String[] tipo, String tipo1, String tipo2

import java.lang.Object

def contador = 0
def tiempo1 = 0
def tiempo2 = 0
def total_tiempo = 0
def arreglo_downtime = []  

print "\n Calculando tiempos:"
for(int k=1; k<tipo.size(); k++) { 
      if(tipo[k] == tipo2){
      	tiempo2=tiempo[k]      
      }  	
      if(tipo[k] == tipo1){
      	tiempo1=tiempo[k]
      	arreglo_downtime[contador] = tiempo1 - tiempo2
      	total_tiempo = total_tiempo + (tiempo1 - tiempo2)
      	print " resta de tiempos: " + (tiempo1 - tiempo2)
      	contador = contador + 1
      }
}

print "\n Calculando tiempo promedio del arreglo de tamaño: " + arreglo_downtime.size
print "\n tiempo total: " + total_tiempo 
print "\n tiempo promedio(" + tipo1 + "-" + tipo2 + "): " + total_tiempo / arreglo_downtime.size


