package practicaUT6;

import java.util.Arrays;

public class Calculadora implements App {

	@Override
	public int [] sumaColumnasMatriz(int [][] m) {
		int [] sumaArray=new int [m[0].length];
		
//		El bucle exterior recorre columnas
		for (int i=0; i<m[0].length; i++) {
			
//			Bucle interior para filas
			for(int j=0; j<m.length; j++) {
				sumaArray[i]+=m[j][i];
			}
			
		}
		
		return sumaArray;
	}

	@Override
	public int secuenciaMayor(int[] v) {
//		Inicializamos el contador a 1 ya que consideramos que cuando un numero no  se repite esta 1 vez
		int mayor=0, cont=1;
		
		for(int i=0; i<(v.length-1); i++) {
//			En cada entrada toma el valor en [i] para compararlo al siguiente
			int valor=v[i];
			if(valor==v[i+1]) {
				cont++;
				if(cont>mayor) {
					mayor=cont;
				}
			}
//			Else reincia el contador cuando un numero deja de repetirse
			else {
				cont=1;
			}
			
		}
		return mayor;
	}

	@Override
	public int mediaImparesDesdePrimerPar(int[] v) {
		int suma=0, cont=0;
		boolean yaPar=false;
		
		for(int i=0; i<v.length; i++) {
//			Entra en esta condicion con el primer par de la array
			if(yaPar==false && (v[i]%2)==0) {
				yaPar=true;
			}
			
//			No entrara en esta condicion a menos que entre en la anterior
			if(yaPar==true && (v[i]%2)!=0) {
				suma=suma+v[i];
				cont++;
			}
		}
		
//		Con esta condicion evitamos calculos fallidos con el 0 si no hay pares o impares tras pares
		if(suma==0 || cont==0) {
			return 0;
		}
		else {
//			El metodo devuelve un int sin decimales
			return Math.round(suma/cont);
		}
		
	}
	
	public static void main(String[] args) {
//		Creacion del objeto calculadora sin constructo
		Calculadora calc=new Calculadora();
		
		int [][] m=new int [3][4];
		
		System.out.println("Matriz de la que se sumaran las columnas:");
//		Rellenar e imprime una matriz con numeros aleatorios entre 1 y 10
		for(int i=0; i<m.length; i++) {
			System.out.print("\t\t");
			for (int j=0; j<m[0].length; j++) {
				m[i][j]=(int)(Math.random()*10);
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
//		Impresion del array resultado de la suma de las columnas
		System.out.print("\tSuma: ");
		System.out.println(Arrays.toString(calc.sumaColumnasMatriz(m)));
		System.out.println("********************************");
		
//		Array aletoria de longitud 7
		int [] l=new int [7];
		for (int i=0; i<l.length; i++) {
			l[i]=(int)(1+Math.random()*10);
		}
		
		System.out.println("Vamos a buscar la mayor cantidad de numeros repetidos de manera consecutiva en el siguiente array: ");
		System.out.println(Arrays.toString(l));
		System.out.println("Mayor numero repeticiones consecutivas: "+calc.secuenciaMayor(l));
		System.out.println("********************************************");
		
		System.out.println("Y ahora la media de los números pares existentes tras el primer número par de la anterior array:");
		System.out.println(Arrays.toString(l));
		
		if(calc.mediaImparesDesdePrimerPar(l)==0) {
			System.out.println("No hay calculo posible");
		}
		else {
			System.out.println("Media impares tras primer par: "+calc.mediaImparesDesdePrimerPar(l));
		}
		
		System.out.println("**********************************");
		System.out.println("ADIOS!");
	}


}